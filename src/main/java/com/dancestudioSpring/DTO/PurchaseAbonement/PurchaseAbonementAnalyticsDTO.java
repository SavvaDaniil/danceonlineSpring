package com.dancestudioSpring.DTO.PurchaseAbonement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class PurchaseAbonementAnalyticsDTO implements ValidatedObject {

    private String dateOfBuy;

    private int id_of_dance_group;

	public String getDateOfBuy() {
		return dateOfBuy;
	}

	public void setDateOfBuy(String dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0;
	}
    
    
}
