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
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@Column(name = "dateOfBuy", nullable=true, columnDefinition="DATETIME")
    private Date dateOfBuy;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupid", referencedColumnName = "id")
	private DanceGroup danceGroup;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupDayOfWeekid", referencedColumnName = "id")
	private DanceGroupDayOfWeek danceGroupDayOfWeek;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "purchaseAbonementid", referencedColumnName = "id")
	private PurchaseAbonement purchaseAbonement;

	@Column(name="special_status_of_abonement", nullable=true, columnDefinition="varchar(32)")
    private String specialStatusOfAbonement;

	@Column(name="is_add_by_app", nullable=false, columnDefinition="int(1) default 0")
    private int isAddByApp;

	@Column(name="is_reservation", nullable=false, columnDefinition="int(1) default 0")
    private int isReservation;

	@Column(name="status_of_reservation_checked", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfReservationChecked;

	@Column(name = "dateOfAcceptReservation", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAcceptReservation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBuy() {
		return dateOfBuy;
	}

	public void setDateOfBuy(Date dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}

	public Date getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DanceGroup getDanceGroup() {
		return danceGroup;
	}

	public void setDanceGroup(DanceGroup danceGroup) {
		this.danceGroup = danceGroup;
	}

	public DanceGroupDayOfWeek getDanceGroupDayOfWeek() {
		return danceGroupDayOfWeek;
	}

	public void setDanceGroupDayOfWeek(DanceGroupDayOfWeek danceGroupDayOfWeek) {
		this.danceGroupDayOfWeek = danceGroupDayOfWeek;
	}

	public PurchaseAbonement getPurchaseAbonement() {
		return purchaseAbonement;
	}

	public void setPurchaseAbonement(PurchaseAbonement purchaseAbonement) {
		this.purchaseAbonement = purchaseAbonement;
	}

	public String getSpecialStatusOfAbonement() {
		return specialStatusOfAbonement;
	}

	public void setSpecialStatusOfAbonement(String specialStatusOfAbonement) {
		this.specialStatusOfAbonement = specialStatusOfAbonement;
	}

	public int getIsAddByApp() {
		return isAddByApp;
	}

	public void setIsAddByApp(int isAddByApp) {
		this.isAddByApp = isAddByApp;
	}

	public int getIsReservation() {
		return isReservation;
	}

	public void setIsReservation(int isReservation) {
		this.isReservation = isReservation;
	}

	public int getStatusOfReservationChecked() {
		return statusOfReservationChecked;
	}

	public void setStatusOfReservationChecked(int statusOfReservationChecked) {
		this.statusOfReservationChecked = statusOfReservationChecked;
	}

	public Date getDateOfAcceptReservation() {
		return dateOfAcceptReservation;
	}

	public void setDateOfAcceptReservation(Date dateOfAcceptReservation) {
		this.dateOfAcceptReservation = dateOfAcceptReservation;
	}
	
	
	
	
	
}
