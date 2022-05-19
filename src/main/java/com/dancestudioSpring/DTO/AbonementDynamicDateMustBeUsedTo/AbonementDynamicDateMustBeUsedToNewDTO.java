package com.dancestudioSpring.DTO.AbonementDynamicDateMustBeUsedTo;

import com.dancestudioSpring.Interface.ValidatedObject;

public class AbonementDynamicDateMustBeUsedToNewDTO implements ValidatedObject {

	private int id_of_abonement;

	public int getId_of_abonement() {
		return id_of_abonement;
	}

	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
	}

    
	@Override
	public boolean isValid() {
		return id_of_abonement != 0;
	}
	
}
