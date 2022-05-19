package com.dancestudioSpring.DTO.ConnectionAbonementPrivateToUser;

import com.dancestudioSpring.Interface.ValidatedObject;

public class ConnectionAbonementPrivateToUserUpdateDTO implements ValidatedObject {

    private int id_of_abonement;

    private int id_of_user;

    private int status;

	public int getId_of_abonement() {
		return id_of_abonement;
	}

	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
	}

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean isValid() {
		return this.id_of_user != 0 && this.id_of_abonement != 0;
	}
    
    
}
