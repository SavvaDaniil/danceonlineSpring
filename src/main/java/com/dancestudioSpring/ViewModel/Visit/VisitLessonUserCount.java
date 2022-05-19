package com.dancestudioSpring.ViewModel.Visit;

import java.util.Date;

public class VisitLessonUserCount {

    private int id_of_dance_group;
    private int id_of_dance_group_day_of_week;
    private String dateOfLessonStr;
    private Date dateOfLesson;

    private int count;

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

	public String getDateOfLessonStr() {
		return dateOfLessonStr;
	}

	public void setDateOfLessonStr(String dateOfLessonStr) {
		this.dateOfLessonStr = dateOfLessonStr;
	}

	public Date getDateOfLesson() {
		return dateOfLesson;
	}

	public void setDateOfLesson(Date dateOfLesson) {
		this.dateOfLesson = dateOfLesson;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public VisitLessonUserCount(int id_of_dance_group, int id_of_dance_group_day_of_week, String dateOfLessonStr,
			Date dateOfLesson) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.dateOfLessonStr = dateOfLessonStr;
		this.dateOfLesson = dateOfLesson;
	}
    
    
}
