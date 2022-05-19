package com.dancestudioSpring.DTO.ConnectionUserToDanceGroup;

import com.dancestudioSpring.Interface.ValidatedObject;

public class ConnectionUserToDanceGroupUpdateDTO implements ValidatedObject {

    private int id_of_user;

    private int id_of_dance_group;

    private int status;

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_user != 0 && this.id_of_dance_group != 0;
	}
    
    
}
