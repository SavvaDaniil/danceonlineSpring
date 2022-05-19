package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.Admin.AdminLoginDTO;
import com.dancestudioSpring.Facade.AdminFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
public class ApiAdminController {

	@Autowired
	AdminFacade adminFacade;
	
	@PostMapping("/api/admin/login")
	public JsonAnswerStatus login(AdminLoginDTO adminLoginDTO) {
		return adminFacade.login(adminLoginDTO.getUsername(), adminLoginDTO.getPassword());
	}
	
	
	@PostMapping("/api/admin/profile")
	public JsonAnswerStatus getProfile() {
		
		
		return adminFacade.getProfile(
			adminFacade.getIdOfAdminFromSecurityName(SecurityContextHolder.getContext().getAuthentication().getName())
		);
	}
}
