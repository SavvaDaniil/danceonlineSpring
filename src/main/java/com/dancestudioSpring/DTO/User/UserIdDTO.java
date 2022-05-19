package com.dancestudioSpring.DTO.User;

import com.dancestudioSpring.Interface.ValidatedObject;

public class UserIdDTO implements ValidatedObject {

    private int id_of_user;

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

	@Override
	public boolean isValid() {
		return id_of_user != 0;
	}
    
    
}
