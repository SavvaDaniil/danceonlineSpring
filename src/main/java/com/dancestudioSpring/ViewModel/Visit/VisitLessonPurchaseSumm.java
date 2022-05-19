package com.dancestudioSpring.ViewModel.Visit;

import java.util.Date;

public class VisitLessonPurchaseSumm {

    private int id_of_dance_group;
    private int id_of_dance_group_day_of_week;
    private String dateOfLessonStr;
    private Date dateOfLesson;

    private int summ;
    private boolean isAlreadyCount;
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
	public int getSumm() {
		return summ;
	}
	public void setSumm(int summ) {
		this.summ = summ;
	}
	public boolean isAlreadyCount() {
		return isAlreadyCount;
	}
	public void setAlreadyCount(boolean isAlreadyCount) {
		this.isAlreadyCount = isAlreadyCount;
	}
	public VisitLessonPurchaseSumm(int id_of_dance_group, int id_of_dance_group_day_of_week, String dateOfLessonStr,
			Date dateOfLesson) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.dateOfLessonStr = dateOfLessonStr;
		this.dateOfLesson = dateOfLesson;
	}
	public VisitLessonPurchaseSumm(int id_of_dance_group, int id_of_dance_group_day_of_week, String dateOfLessonStr,
			Date dateOfLesson, boolean isAlreadyCount) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.dateOfLessonStr = dateOfLessonStr;
		this.dateOfLesson = dateOfLesson;
		this.isAlreadyCount = isAlreadyCount;
	}
	public VisitLessonPurchaseSumm(int id_of_dance_group, int id_of_dance_group_day_of_week, String dateOfLessonStr,
			Date dateOfLesson, int summ) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.dateOfLessonStr = dateOfLessonStr;
		this.dateOfLesson = dateOfLesson;
		this.summ = summ;
	}
    
    
}
