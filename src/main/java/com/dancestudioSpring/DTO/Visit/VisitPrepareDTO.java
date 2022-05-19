package com.dancestudioSpring.DTO.Visit;

import com.dancestudioSpring.Interface.ValidatedObject;

public class VisitPrepareDTO implements ValidatedObject {

    private int id_of_user;

    private int id_of_dance_group;

    private int id_of_dance_group_day_of_week;

    private String date_of_day;

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

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

	public String getDate_of_day() {
		return date_of_day;
	}

	public void setDate_of_day(String date_of_day) {
		this.date_of_day = date_of_day;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_user != 0 && this.id_of_dance_group != 0;
	}
    
    
}
