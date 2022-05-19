package com.dancestudioSpring.DTO.DanceGroupCansel;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupCanselIdDTO implements ValidatedObject {

    public int id_of_dance_group_cansel;

	public int getId_of_dance_group_cansel() {
		return id_of_dance_group_cansel;
	}

	public void setId_of_dance_group_cansel(int id_of_dance_group_cansel) {
		this.id_of_dance_group_cansel = id_of_dance_group_cansel;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group_cansel != 0;
	}
    
    
}
