package com.dancestudioSpring.ViewModel.DanceGroupDayOfWeek;

import java.sql.Time;
import java.util.Date;

public class DanceGroupDayOfWeekLiteViewModel {

    private int id;
    private int dayOfWeek;
    private String dayOfWeekName;
    private int status;
    private Time timeFrom;
    private Time timeTo;

    private int isEvent;
    private Date dateOfEvent;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getDayOfWeekName() {
		return dayOfWeekName;
	}
	public void setDayOfWeekName(String dayOfWeekName) {
		this.dayOfWeekName = dayOfWeekName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Time getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Time getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}
	public int getIsEvent() {
		return isEvent;
	}
	public void setIsEvent(int isEvent) {
		this.isEvent = isEvent;
	}
	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	public DanceGroupDayOfWeekLiteViewModel(int id, int dayOfWeek, String dayOfWeekName, int status, Time timeFrom,
			Time timeTo, int isEvent, Date dateOfEvent) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.dayOfWeekName = dayOfWeekName;
		this.status = status;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.isEvent = isEvent;
		this.dateOfEvent = dateOfEvent;
	}
    
    
}
