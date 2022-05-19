package com.dancestudioSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
public class ApiIndexController {

	//@Autowired
	//private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public JsonAnswerStatus Index() {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success", null);
		return jsonAnswerStatus;
	}

	@GetMapping("/secret")
	public JsonAnswerStatus Secret() {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("auth success", null);
		return jsonAnswerStatus;
	}
}
