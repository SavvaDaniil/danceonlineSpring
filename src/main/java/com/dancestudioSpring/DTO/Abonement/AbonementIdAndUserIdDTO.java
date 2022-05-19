package com.dancestudioSpring.DTO.Abonement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class AbonementIdAndUserIdDTO implements ValidatedObject {

    private int id_of_user;
    private int id_of_abonement;
    
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}
	public int getId_of_abonement() {
		return id_of_abonement;
	}
	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
	}
	
	@Override
	public boolean isValid() {
		return id_of_user != 0 && id_of_abonement != 0;
	}
    
    
}
