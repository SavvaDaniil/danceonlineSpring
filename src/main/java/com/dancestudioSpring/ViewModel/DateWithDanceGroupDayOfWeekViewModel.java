package com.dancestudioSpring.ViewModel;

import java.util.Date;

import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;

public class DateWithDanceGroupDayOfWeekViewModel {

	private Date date;
	private DanceGroupDayOfWeek danceGroupDayOfWeek;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DanceGroupDayOfWeek getDanceGroupDayOfWeek() {
		return danceGroupDayOfWeek;
	}
	public void setDanceGroupDayOfWeek(DanceGroupDayOfWeek danceGroupDayOfWeek) {
		this.danceGroupDayOfWeek = danceGroupDayOfWeek;
	}
	public DateWithDanceGroupDayOfWeekViewModel(Date date, DanceGroupDayOfWeek danceGroupDayOfWeek) {
		super();
		this.date = date;
		this.danceGroupDayOfWeek = danceGroupDayOfWeek;
	}
	
	
}
