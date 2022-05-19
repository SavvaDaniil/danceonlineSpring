package com.dancestudioSpring.DTO.DanceGroupEventDate;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupEventDateIdDTO implements ValidatedObject {

    private int id_of_dance_group_event_date;

	public int getId_of_dance_group_event_date() {
		return id_of_dance_group_event_date;
	}

	public void setId_of_dance_group_event_date(int id_of_dance_group_event_date) {
		this.id_of_dance_group_event_date = id_of_dance_group_event_date;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group_event_date != 0;
	}
    
    
}
