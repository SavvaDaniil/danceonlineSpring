package com.dancestudioSpring.DTO.DanceGroupDayOfWeek;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupDayOfWeekIdDTO implements ValidatedObject {
	
	private int id_of_dance_group_day_of_week;

	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}

	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group_day_of_week != 0;
	}
    
	
}
