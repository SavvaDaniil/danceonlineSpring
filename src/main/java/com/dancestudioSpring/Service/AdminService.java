package com.dancestudioSpring.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dancestudioSpring.Entity.Admin;
import com.dancestudioSpring.Repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUsername(username);
		if(admin == null)throw new UsernameNotFoundException("not_found");
		//return new User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
		return new User(Integer.toString(admin.getId()), admin.getPassword(), new ArrayList<>());
	}
	
	public UserDetails loadAdminById(int id) throws UsernameNotFoundException {
		Admin admin = adminRepository.findById(id);
		if(admin == null)throw new UsernameNotFoundException("not_found");
		//return new User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
		return new User(Integer.toString(admin.getId()), admin.getPassword(), new ArrayList<>());
	}
	
	public Admin findById(int id) {
		return adminRepository.findById(id);
	}

}
