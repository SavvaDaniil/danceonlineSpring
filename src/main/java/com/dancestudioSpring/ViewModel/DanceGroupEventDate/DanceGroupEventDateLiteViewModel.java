package com.dancestudioSpring.ViewModel.DanceGroupEventDate;

import java.sql.Time;
import java.util.Date;

public class DanceGroupEventDateLiteViewModel {

    private int id;
    private int id_of_dance_group;
    private int active;

    private Time timeFrom;
    private Time timeTo;
    private Date dateOfEvent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	public DanceGroupEventDateLiteViewModel(int id, int id_of_dance_group, int active, Time timeFrom, Time timeTo,
			Date dateOfEvent) {
		super();
		this.id = id;
		this.id_of_dance_group = id_of_dance_group;
		this.active = active;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.dateOfEvent = dateOfEvent;
	}
    
}
