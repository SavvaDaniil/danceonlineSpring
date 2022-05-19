package com.dancestudioSpring.DTO.DanceGroupDayOfWeek;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupDayOfWeekNewDTO implements ValidatedObject {

	private int id_of_dance_group;

	private int isEvent;

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	public int getIsEvent() {
		return isEvent;
	}

	public void setIsEvent(int isEvent) {
		this.isEvent = isEvent;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0;
	}
	
	
}
