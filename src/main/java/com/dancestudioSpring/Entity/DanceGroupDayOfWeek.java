package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dance_group_day_of_week")
public class DanceGroupDayOfWeek {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupid", referencedColumnName = "id")
	private DanceGroup danceGroup;

	@Column(name="day_of_week", nullable=false, columnDefinition="int(1) default 0")
	private int dayOfWeek;

	@Column(name="status", nullable=false, columnDefinition="int(1) default 0")
	private int status;

	private java.sql.Time timeFrom;
	private java.sql.Time timeTo;

	@Column(name="is_event", nullable=false, columnDefinition="int(1) default 0")
	private int isEvent;

	@Column(name = "dateOfEvent", nullable=true, columnDefinition="DATETIME")
    private Date dateOfEvent;
    
	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;
    
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
    private Date dateOfUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DanceGroup getDanceGroup() {
		return danceGroup;
	}

	public void setDanceGroup(DanceGroup danceGroup) {
		this.danceGroup = danceGroup;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public java.sql.Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(java.sql.Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public java.sql.Time getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(java.sql.Time timeTo) {
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

	public Date getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

	public Date getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate(Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}
	
	
}
