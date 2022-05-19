package com.dancestudioSpring.DTO.ConnectionAbonementToDanceGroup;

import com.dancestudioSpring.Interface.ValidatedObject;

public class ConnectionAbonementToDanceGroupUpdateDTO implements ValidatedObject {

    private int id_of_abonement;

    private int id_of_dance_group;

    private int status;

	public int getId_of_abonement() {
		return id_of_abonement;
	}

	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
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
		return this.id_of_abonement != 0 && this.id_of_dance_group != 0;
	}
    
    
}
