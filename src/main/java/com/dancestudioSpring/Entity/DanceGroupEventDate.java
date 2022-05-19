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
@Table(name = "dance_group_event_date")
public class DanceGroupEventDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupid", referencedColumnName = "id")
	private DanceGroup danceGroup;
	
	@Column(name="active", nullable=false, columnDefinition="int(1) default 0")
	private int active;

	@Column(name = "dateOfEvent", nullable=true, columnDefinition="DATETIME")
    private Date dateOfEvent;

	private java.sql.Time timeFrom;
	private java.sql.Time timeTo;
	
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getDateOfEvent() {
		return dateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
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
