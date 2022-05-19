package com.dancestudioSpring.Facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Component.JwtUtil;
import com.dancestudioSpring.Entity.Admin;
import com.dancestudioSpring.Service.AdminService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Admin.AdminProfileViewModel;

@Component
public class AdminFacade {

	@Autowired
	AdminService adminService;
    
	public JsonAnswerStatus login(String username, String password) {

		try {
			UserDetails adminUserDetails = adminService.loadUserByUsername(username);
			//if(adminUserDetails.getPassword())
			BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
			if(!passwordEcorder.matches(password, adminUserDetails.getPassword())) {
				return new JsonAnswerStatus("error", "wrong");
			}
			
			JwtUtil jwtUtil = new JwtUtil();
			String accessToken = jwtUtil.generateToken(adminUserDetails);
			return new JsonAnswerStatus("success", null, accessToken);
		
		} catch(UsernameNotFoundException exception) {
			return new JsonAnswerStatus("error", "not_found");
		}
	}
	
	
	public JsonAnswerStatus getProfile(int id_of_admin) {
		Admin admin = adminService.findById(id_of_admin);
		if(admin == null)return new JsonAnswerStatus("error", "not_found");

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setAdminProfileViewModel(new AdminProfileViewModel(
					admin.getUsername(),
					admin.getPosition()
				));
        
		return jsonAnswerStatus;
	}
	
	public int getIdOfAdminFromSecurityName(String name) {
		try {
			int id_of_admin = Integer.parseInt(name);
			return id_of_admin;
		}
		catch(NumberFormatException ex) {
			return 0;
		}
	}
}
