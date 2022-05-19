package com.dancestudioSpring.DTO.ConnectionAbonementToDiscount;

import com.dancestudioSpring.Interface.ValidatedObject;

public class ConnectionAbonementToDiscountUpdateDTO implements ValidatedObject {

    private int id_of_abonement;

    private int id_of_discount;

    private String name;

    private int value;

	public int getId_of_abonement() {
		return id_of_abonement;
	}

	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
	}

	public int getId_of_discount() {
		return id_of_discount;
	}

	public void setId_of_discount(int id_of_discount) {
		this.id_of_discount = id_of_discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_abonement != 0 && this.id_of_discount != 0;
	}
    
    
}
