package com.dancestudioSpring.DTO.Discount;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DiscountIdDTO implements ValidatedObject {
	
    private int id_of_discount;

	public int getId_of_discount() {
		return id_of_discount;
	}

	public void setId_of_discount(int id_of_discount) {
		this.id_of_discount = id_of_discount;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_discount != 0;
	}
    
    
}
