package com.dancestudioSpring.DTO.PurchaseAbonement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class PurchaseAbonementNewDTO implements ValidatedObject {

    private int id_of_user;

    private int id_of_abonement;
    private int price;
    private int cashless;
    private int visits;
    private int days;
    private String comment;
    private String date_of_buy;

    private int id_of_dance_group;
    private int id_of_dance_group_day_of_week;
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
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
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate_of_buy() {
		return date_of_buy;
	}
	public void setDate_of_buy(String date_of_buy) {
		this.date_of_buy = date_of_buy;
	}
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}
	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}
	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_user != 0 && this.id_of_abonement != 0;
	}
    
    
}
