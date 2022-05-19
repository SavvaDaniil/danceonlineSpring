package com.dancestudioSpring.DTO.AbonementDynamicDateMustBeUsedTo;

import com.dancestudioSpring.Interface.ValidatedObject;

public class AbonementDynamicDateMustBeUsedToIdDTO implements ValidatedObject {

	private int id_of_abonement_dynamic_date_be_must_used_to;

	public int getId_of_abonement_dynamic_date_be_must_used_to() {
		return id_of_abonement_dynamic_date_be_must_used_to;
	}

	public void setId_of_abonement_dynamic_date_be_must_used_to(int id_of_abonement_dynamic_date_be_must_used_to) {
		this.id_of_abonement_dynamic_date_be_must_used_to = id_of_abonement_dynamic_date_be_must_used_to;
	}

    
	@Override
	public boolean isValid() {
		return id_of_abonement_dynamic_date_be_must_used_to != 0;
	}
	
}
