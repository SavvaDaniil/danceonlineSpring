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
@Table(name = "purchase_abonement")
public class PurchaseAbonement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "abonementid", referencedColumnName = "id")
	private Abonement abonement;

	@Column(name = "dateOfBuy", nullable=true, columnDefinition="DATETIME")
    private Date dateOfBuy;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;
	
	@Column(name="days", nullable=false, columnDefinition="int(11) default 0")
    private int days;
	
	@Column(name="visits", nullable=false, columnDefinition="int(11) default 0")
    private int visits;
	
	@Column(name="visits_left", nullable=false, columnDefinition="int(11) default 0")
    private int visitsLeft;

	@Column(name="price", nullable=false, columnDefinition="int(11) default 0")
    private int price;

	@Column(name="cashless", nullable=false, columnDefinition="int(11) default 0")
    private int cashless;
	
	@Column(name = "dateOfActivation", nullable=true, columnDefinition="DATETIME")
    private Date dateOfActivation;
	
	@Column(name = "dateOfMustBeUsedTo", nullable=true, columnDefinition="DATETIME")
    private Date dateOfMustBeUsedTo;

	@Column(name="special_status", nullable=true, columnDefinition="varchar(32)")
    private String specialStatus;

	@Column(name="comment", nullable=true, columnDefinition="TEXT")
    private String comment;

	@Column(name="active", nullable=false, columnDefinition="int(1) default 1")
    private int active;

	@Column(name="is_trial", nullable=false, columnDefinition="int(1) default 0")
    private int isTrial;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Abonement getAbonement() {
		return abonement;
	}

	public void setAbonement(Abonement abonement) {
		this.abonement = abonement;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getVisitsLeft() {
		return visitsLeft;
	}

	public void setVisitsLeft(int visitsLeft) {
		this.visitsLeft = visitsLeft;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCashless() {
		return cashless;
	}

	public void setCashless(int cashless) {
		this.cashless = cashless;
	}

	public Date getDateOfActivation() {
		return dateOfActivation;
	}

	public void setDateOfActivation(Date dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}

	public Date getDateOfMustBeUsedTo() {
		return dateOfMustBeUsedTo;
	}

	public void setDateOfMustBeUsedTo(Date dateOfMustBeUsedTo) {
		this.dateOfMustBeUsedTo = dateOfMustBeUsedTo;
	}

	public String getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(int isTrial) {
		this.isTrial = isTrial;
	}
	
	
	
}
