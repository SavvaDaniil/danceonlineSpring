package com.dancestudioSpring.DTO.Discount;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DiscountEditByColumnDTO implements ValidatedObject {

    private int id_of_discount;
    private String name;
    private String value;
    
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_discount != 0;
	}
    
    
}
