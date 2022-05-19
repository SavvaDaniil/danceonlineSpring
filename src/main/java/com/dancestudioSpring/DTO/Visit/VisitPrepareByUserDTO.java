package com.dancestudioSpring.DTO.Visit;

public class VisitPrepareByUserDTO {

    private int id_of_dance_group;

    private int id_of_dance_group_day_of_week;

    private String date_of_lesson;

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

	public String getDate_of_lesson() {
		return date_of_lesson;
	}

	public void setDate_of_lesson(String date_of_lesson) {
		this.date_of_lesson = date_of_lesson;
	}
    
    
}
