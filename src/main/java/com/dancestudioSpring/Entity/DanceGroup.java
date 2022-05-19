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
@Table(name = "dance_group")
public class DanceGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	

	@Column(name="name", nullable=true, columnDefinition="varchar(256)")
    private String name;

	@Column(name="status", nullable=false, columnDefinition="int(1) default 0")
    private int status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherid", referencedColumnName = "id")
    private Teacher teacher;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branchid", referencedColumnName = "id")
    private Branch branch;

	@Column(name="description", nullable=true, columnDefinition="varchar(256)")
    private String description;

	@Column(name="status_of_creative", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfCreative;

	@Column(name="status_for_app", nullable=false, columnDefinition="int(1) default 0")
    private int statusForApp;

	@Column(name="is_abonements_allow_all", nullable=false, columnDefinition="int(1) default 0")
    private int isAbonementsAllowAll;

	@Column(name="is_active_reservation", nullable=false, columnDefinition="int(1) default 0")
    private int isActiveReservation;

	@Column(name="is_event", nullable=false, columnDefinition="int(1) default 0")
    private int isEvent;

	@Column(name = "date_of_add", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;
	
	@Column(name = "date_of_update", nullable=true, columnDefinition="DATETIME")
    private Date dateOfUpdate;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusOfCreative() {
		return statusOfCreative;
	}

	public void setStatusOfCreative(int statusOfCreative) {
		this.statusOfCreative = statusOfCreative;
	}



	public int getStatusForApp() {
		return statusForApp;
	}

	public void setStatusForApp(int statusForApp) {
		this.statusForApp = statusForApp;
	}

	public int getIsAbonementsAllowAll() {
		return isAbonementsAllowAll;
	}

	public void setIsAbonementsAllowAll(int isAbonementsAllowAll) {
		this.isAbonementsAllowAll = isAbonementsAllowAll;
	}

	public int getIsActiveReservation() {
		return isActiveReservation;
	}

	public void setIsActiveReservation(int isActiveReservation) {
		this.isActiveReservation = isActiveReservation;
	}

	public int getIsEvent() {
		return isEvent;
	}

	public void setIsEvent(int isEvent) {
		this.isEvent = isEvent;
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

	public DanceGroup() {
		super();
	}

	public DanceGroup(int id, String name, int status, Teacher teacher, Branch branch, String description,
			int statusOfCreative, int statusForApp, int isAbonementsAllowAll, int isActiveReservation, int isEvent,
			Date dateOfAdd, Date dateOfUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.teacher = teacher;
		this.branch = branch;
		this.description = description;
		this.statusOfCreative = statusOfCreative;
		this.statusForApp = statusForApp;
		this.isAbonementsAllowAll = isAbonementsAllowAll;
		this.isActiveReservation = isActiveReservation;
		this.isEvent = isEvent;
		this.dateOfAdd = dateOfAdd;
		this.dateOfUpdate = dateOfUpdate;
	}

	
}
