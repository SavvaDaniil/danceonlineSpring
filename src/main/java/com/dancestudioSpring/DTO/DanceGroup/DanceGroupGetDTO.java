package com.dancestudioSpring.DTO.DanceGroup;

public class DanceGroupGetDTO {

	private int id_of_dance_group;
	private int id_of_dance_group_day_of_week;
	private String date_of_lesson_str;
	private int id_of_visit;
	
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
	public String getDate_of_lesson_str() {
		return date_of_lesson_str;
	}
	public void setDate_of_lesson_str(String date_of_lesson_str) {
		this.date_of_lesson_str = date_of_lesson_str;
	}
	public int getId_of_visit() {
		return id_of_visit;
	}
	public void setId_of_visit(int id_of_visit) {
		this.id_of_visit = id_of_visit;
	}
	
	
}
