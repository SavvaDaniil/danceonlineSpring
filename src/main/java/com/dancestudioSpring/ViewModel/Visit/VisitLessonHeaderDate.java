package com.dancestudioSpring.ViewModel.Visit;

import java.util.Date;

public class VisitLessonHeaderDate {

    private String dateDayMonth;
    private String dateYearMonthDay;
    private Date dateOfLesson;

    private int id_of_dance_group_day_of_week;
    private String timeFrom;
    private String timeTo;
    //public String timeFromTimeTo;
    private boolean isReplacementExistForLesson;
	public String getDateDayMonth() {
		return dateDayMonth;
	}
	public void setDateDayMonth(String dateDayMonth) {
		this.dateDayMonth = dateDayMonth;
	}
	public String getDateYearMonthDay() {
		return dateYearMonthDay;
	}
	public void setDateYearMonthDay(String dateYearMonthDay) {
		this.dateYearMonthDay = dateYearMonthDay;
	}
	public Date getDateOfLesson() {
		return dateOfLesson;
	}
	public void setDateOfLesson(Date dateOfLesson) {
		this.dateOfLesson = dateOfLesson;
	}
	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}
	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
	public String getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	public String getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
	public boolean isReplacementExistForLesson() {
		return isReplacementExistForLesson;
	}
	public void setReplacementExistForLesson(boolean isReplacementExistForLesson) {
		this.isReplacementExistForLesson = isReplacementExistForLesson;
	}
	public VisitLessonHeaderDate(String dateDayMonth, String dateYearMonthDay, Date dateOfLesson,
			int id_of_dance_group_day_of_week, String timeFrom, String timeTo, boolean isReplacementExistForLesson) {
		super();
		this.dateDayMonth = dateDayMonth;
		this.dateYearMonthDay = dateYearMonthDay;
		this.dateOfLesson = dateOfLesson;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.isReplacementExistForLesson = isReplacementExistForLesson;
	}
    
    
}
