package com.dancestudioSpring.DTO.PurchaseAbonement;

import com.dancestudioSpring.Interface.ValidatedObject;

public class PurchaseAbonementIdDTO implements ValidatedObject {

    private int id_of_purchase_abonement;

	public int getId_of_purchase_abonement() {
		return id_of_purchase_abonement;
	}

	public void setId_of_purchase_abonement(int id_of_purchase_abonement) {
		this.id_of_purchase_abonement = id_of_purchase_abonement;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_purchase_abonement != 0;
	}
    
    
}
