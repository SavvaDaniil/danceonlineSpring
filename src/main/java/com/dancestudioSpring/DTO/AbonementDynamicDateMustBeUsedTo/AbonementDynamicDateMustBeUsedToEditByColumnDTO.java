package com.dancestudioSpring.DTO.AbonementDynamicDateMustBeUsedTo;

import com.dancestudioSpring.Interface.ValidatedObject;

public class AbonementDynamicDateMustBeUsedToEditByColumnDTO implements ValidatedObject {

    private int id_of_abonement_dynamic_date_be_must_used_to;
    private String name;
    private int value;
    private String dateData;
    
	public int getId_of_abonement_dynamic_date_be_must_used_to() {
		return id_of_abonement_dynamic_date_be_must_used_to;
	}
	public void setId_of_abonement_dynamic_date_be_must_used_to(int id_of_abonement_dynamic_date_be_must_used_to) {
		this.id_of_abonement_dynamic_date_be_must_used_to = id_of_abonement_dynamic_date_be_must_used_to;
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
	public String getDateData() {
		return dateData;
	}
	public void setDateData(String dateData) {
		this.dateData = dateData;
	}
    

	@Override
	public boolean isValid() {
		return id_of_abonement_dynamic_date_be_must_used_to != 0 && name != null;
	}
}
