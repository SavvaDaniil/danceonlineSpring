package com.dancestudioSpring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abonement")
public class Abonement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@Column(name="name", nullable=true, columnDefinition="varchar(256)")
    private String name;

	@Column(name="special_status", nullable=true, columnDefinition="varchar(32)")
    private String specialStatus;

	@Column(name="days", nullable=false, columnDefinition="int(11) default 0")
    private int days;

	@Column(name="price", nullable=false, columnDefinition="int(11) default 0")
    private int price;

	@Column(name="visits", nullable=false, columnDefinition="int(11) default 0")
    private int visits;

	@Column(name="status_of_visible", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfVisible;

	@Column(name="status_of_deleted", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfDeleted;

	@Column(name="status_for_app", nullable=false, columnDefinition="int(1) default 0")
    private int statusForApp;

	@Column(name="is_trial", nullable=false, columnDefinition="int(1) default 0")
    private int isTrial;

	@Column(name="is_private", nullable=false, columnDefinition="int(1) default 0")
    private int isPrivate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getStatusOfVisible() {
		return statusOfVisible;
	}

	public void setStatusOfVisible(int statusOfVisible) {
		this.statusOfVisible = statusOfVisible;
	}

	public int getStatusOfDeleted() {
		return statusOfDeleted;
	}

	public void setStatusOfDeleted(int statusOfDeleted) {
		this.statusOfDeleted = statusOfDeleted;
	}



	public int getStatusForApp() {
		return statusForApp;
	}

	public void setStatusForApp(int statusForApp) {
		this.statusForApp = statusForApp;
	}

	public int getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(int isTrial) {
		this.isTrial = isTrial;
	}

	public int getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(int isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Abonement() {
		super();
	}

	public Abonement(int id, String name, String specialStatus, int days, int price, int visits, int statusOfVisible,
			int statusOfDeleted, int statusForApp, int isTrial, int isPrivate) {
		super();
		this.id = id;
		this.name = name;
		this.specialStatus = specialStatus;
		this.days = days;
		this.price = price;
		this.visits = visits;
		this.statusOfVisible = statusOfVisible;
		this.statusOfDeleted = statusOfDeleted;
		this.statusForApp = statusForApp;
		this.isTrial = isTrial;
		this.isPrivate = isPrivate;
	}
    
    
    
}
