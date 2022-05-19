package com.dancestudioSpring.DTO.PurchaseAbonement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class PurchaseAbonementDTO implements ValidatedObject {

    private int id_of_purchase_abonement;
    private int days;
    private int id_of_abonement;
    private int price;
    private int cashless;
    private int visits;
    private int visitsLeft;
    private String comment;
    private String dateOfBuy;
    private String dateOfActivation;
    private String dateMustBeUsedTo;
    
	public int getId_of_purchase_abonement() {
		return id_of_purchase_abonement;
	}
	public void setId_of_purchase_abonement(int id_of_purchase_abonement) {
		this.id_of_purchase_abonement = id_of_purchase_abonement;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getId_of_abonement() {
		return id_of_abonement;
	}
	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDateOfBuy() {
		return dateOfBuy;
	}
	public void setDateOfBuy(String dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}
	public String getDateOfActivation() {
		return dateOfActivation;
	}
	public void setDateOfActivation(String dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}
	public String getDateMustBeUsedTo() {
		return dateMustBeUsedTo;
	}
	public void setDateMustBeUsedTo(String dateMustBeUsedTo) {
		this.dateMustBeUsedTo = dateMustBeUsedTo;
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_purchase_abonement != 0 && this.id_of_abonement != 0;
	}
    
    
}
