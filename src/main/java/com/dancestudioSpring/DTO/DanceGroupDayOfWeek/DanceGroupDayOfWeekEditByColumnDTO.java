package com.dancestudioSpring.DTO.DanceGroupDayOfWeek;

import java.sql.Time;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupDayOfWeekEditByColumnDTO implements ValidatedObject {

    private int id_of_dance_group_day_of_week;

    private String name;

    private int value;

    private String dateData;

    private Time time;

	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}

	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDateData() {
		return dateData;
	}

	public void setDateData(String dateData) {
		this.dateData = dateData;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group_day_of_week != 0;
	}
    
    
}
