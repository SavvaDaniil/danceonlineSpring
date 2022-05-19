package com.dancestudioSpring.Model;

public class DanceGroupLesson {

    private String dateOfLesson;
    private int id_of_dance_group_day_of_week;
    
	public String getDateOfLesson() {
		return dateOfLesson;
	}
	public void setDateOfLesson(String dateOfLesson) {
		this.dateOfLesson = dateOfLesson;
	}
	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}
	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
	public DanceGroupLesson(String dateOfLesson, int id_of_dance_group_day_of_week) {
		super();
		this.dateOfLesson = dateOfLesson;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
    
    
}
