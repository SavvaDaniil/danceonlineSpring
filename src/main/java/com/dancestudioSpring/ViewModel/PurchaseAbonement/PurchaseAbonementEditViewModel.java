package com.dancestudioSpring.ViewModel.PurchaseAbonement;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseAbonementEditViewModel {

    public int id;
    public Date dateOfBuy;
    public String specialStatus;
    public int idOfAbonement;
    public String nameOfAbonement;
    public int days;
    public Date dateOfActivation;
    public Date dateMustBeUsedTo;
    public int visits;
    public int visitsLeft;
    public int visitsUsed;
    public int price;
    public int cashless;
    public String comment;

    public ArrayList<Integer> dateDays;
    public ArrayList<Integer> dateMonth;
    public ArrayList<Integer> dateYears;
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
	public String getSpecialStatus() {
		return specialStatus;
	}
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}
	public int getIdOfAbonement() {
		return idOfAbonement;
	}
	public void setIdOfAbonement(int idOfAbonement) {
		this.idOfAbonement = idOfAbonement;
	}
	public String getNameOfAbonement() {
		return nameOfAbonement;
	}
	public void setNameOfAbonement(String nameOfAbonement) {
		this.nameOfAbonement = nameOfAbonement;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getDateOfActivation() {
		return dateOfActivation;
	}
	public void setDateOfActivation(Date dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}
	public Date getDateMustBeUsedTo() {
		return dateMustBeUsedTo;
	}
	public void setDateMustBeUsedTo(Date dateMustBeUsedTo) {
		this.dateMustBeUsedTo = dateMustBeUsedTo;
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
	public int getVisitsUsed() {
		return visitsUsed;
	}
	public void setVisitsUsed(int visitsUsed) {
		this.visitsUsed = visitsUsed;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ArrayList<Integer> getDateDays() {
		return dateDays;
	}
	public void setDateDays(ArrayList<Integer> dateDays) {
		this.dateDays = dateDays;
	}
	public ArrayList<Integer> getDateMonth() {
		return dateMonth;
	}
	public void setDateMonth(ArrayList<Integer> dateMonth) {
		this.dateMonth = dateMonth;
	}
	public ArrayList<Integer> getDateYears() {
		return dateYears;
	}
	public void setDateYears(ArrayList<Integer> dateYears) {
		this.dateYears = dateYears;
	}
	public PurchaseAbonementEditViewModel(int id, Date dateOfBuy, String specialStatus, int idOfAbonement,
			String nameOfAbonement, int days, Date dateOfActivation, Date dateMustBeUsedTo, int visits, int visitsLeft,
			int visitsUsed, int price, int cashless, String comment) {
		super();
		this.id = id;
		this.dateOfBuy = dateOfBuy;
		this.specialStatus = specialStatus;
		this.idOfAbonement = idOfAbonement;
		this.nameOfAbonement = nameOfAbonement;
		this.days = days;
		this.dateOfActivation = dateOfActivation;
		this.dateMustBeUsedTo = dateMustBeUsedTo;
		this.visits = visits;
		this.visitsLeft = visitsLeft;
		this.visitsUsed = visitsUsed;
		this.price = price;
		this.cashless = cashless;
		this.comment = comment;
		

        dateDays = new ArrayList<Integer>();
        for (int i = 1; i <= 31; i++)
        {
            dateDays.add(i);
        }
        dateMonth = new ArrayList<Integer>();
        for (int i = 1; i <= 12; i++)
        {
            dateMonth.add(i);
        }
        dateYears = new ArrayList<Integer>();
        Date dateNow = new Date();
        for (@SuppressWarnings("deprecation")
		int i = dateNow.getYear() + 1; i > 2000; i--)
        {
            dateYears.add(i);
        }
	}
    
    
}
