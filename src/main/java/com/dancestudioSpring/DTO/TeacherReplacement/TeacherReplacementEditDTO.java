package com.dancestudioSpring.DTO.TeacherReplacement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherReplacementEditDTO implements ValidatedObject {

    public int id_of_dance_group;

    public int id_of_dance_group_day_of_week;

    public String dateOfDay;

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}

	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}

	public String getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(String dateOfDay) {
		this.dateOfDay = dateOfDay;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0 && this.id_of_dance_group_day_of_week != 0;
	}
    
    
}
