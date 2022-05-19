package com.dancestudioSpring.DTO.TeacherReplacement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherReplacementUpdateDTO implements ValidatedObject {

    public int id_of_dance_group;

    public int id_of_dance_group_day_of_week;

    public int id_of_teacher_replace;

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

	public int getId_of_teacher_replace() {
		return id_of_teacher_replace;
	}

	public void setId_of_teacher_replace(int id_of_teacher_replace) {
		this.id_of_teacher_replace = id_of_teacher_replace;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0;
	}
    
    
}
