package com.dancestudioSpring.ViewModel.PurchaseAbonement;

import java.util.Date;

public class PurchaseAbonementLiteViewModel {

    public int id_of_purchase_abonement;
    public String name;
    public Date dateOfBuy;
    public Date dateOfActivation;
    public Date dateOfMustBeUsedTo;
    public int days;
    public int price;
    public int cashless;
    public int visits;
    public int visitsLeft;
    public String specialStatus;

    public boolean isExpired;

    public int id_of_user;
    public String secondname_of_user;
    public String firstname_of_user;
	public int getId_of_purchase_abonement() {
		return id_of_purchase_abonement;
	}
	public void setId_of_purchase_abonement(int id_of_purchase_abonement) {
		this.id_of_purchase_abonement = id_of_purchase_abonement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBuy() {
		return dateOfBuy;
	}
	public void setDateOfBuy(Date dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
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
	public int getCashless() {
		return cashless;
	}
	public void setCashless(int cashless) {
		this.cashless = cashless;
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
	public String getSpecialStatus() {
		return specialStatus;
	}
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}
	public String getSecondname_of_user() {
		return secondname_of_user;
	}
	public void setSecondname_of_user(String secondname_of_user) {
		this.secondname_of_user = secondname_of_user;
	}
	public String getFirstname_of_user() {
		return firstname_of_user;
	}
	public void setFirstname_of_user(String firstname_of_user) {
		this.firstname_of_user = firstname_of_user;
	}
	public PurchaseAbonementLiteViewModel(int id_of_purchase_abonement, String name, Date dateOfBuy,
			Date dateOfActivation, Date dateOfMustBeUsedTo, int days, int price, int cashless, int visits,
			int visitsLeft, String specialStatus, boolean isExpired) {
		super();
		this.id_of_purchase_abonement = id_of_purchase_abonement;
		this.name = name;
		this.dateOfBuy = dateOfBuy;
		this.dateOfActivation = dateOfActivation;
		this.dateOfMustBeUsedTo = dateOfMustBeUsedTo;
		this.days = days;
		this.price = price;
		this.cashless = cashless;
		this.visits = visits;
		this.visitsLeft = visitsLeft;
		this.specialStatus = specialStatus;
		this.isExpired = isExpired;
	}
	public PurchaseAbonementLiteViewModel(int id_of_purchase_abonement, String name, Date dateOfBuy,
			Date dateOfActivation, Date dateOfMustBeUsedTo, int days, int price, int cashless, int visits,
			int visitsLeft, String specialStatus, boolean isExpired, int id_of_user, String secondname_of_user,
			String firstname_of_user) {
		super();
		this.id_of_purchase_abonement = id_of_purchase_abonement;
		this.name = name;
		this.dateOfBuy = dateOfBuy;
		this.dateOfActivation = dateOfActivation;
		this.dateOfMustBeUsedTo = dateOfMustBeUsedTo;
		this.days = days;
		this.price = price;
		this.cashless = cashless;
		this.visits = visits;
		this.visitsLeft = visitsLeft;
		this.specialStatus = specialStatus;
		this.isExpired = isExpired;
		this.id_of_user = id_of_user;
		this.secondname_of_user = secondname_of_user;
		this.firstname_of_user = firstname_of_user;
	}
    
    
}
