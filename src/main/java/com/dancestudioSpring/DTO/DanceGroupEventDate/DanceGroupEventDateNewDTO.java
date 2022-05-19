package com.dancestudioSpring.DTO.DanceGroupEventDate;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupEventDateNewDTO implements ValidatedObject {

    private int id_of_dance_group;

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0;
	}
    
    
}
