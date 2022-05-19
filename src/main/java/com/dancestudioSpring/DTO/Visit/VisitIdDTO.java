package com.dancestudioSpring.DTO.Visit;

import com.dancestudioSpring.Interface.ValidatedObject;

public class VisitIdDTO implements ValidatedObject {

    private int id_of_visit;

	public int getId_of_visit() {
		return id_of_visit;
	}

	public void setId_of_visit(int id_of_visit) {
		this.id_of_visit = id_of_visit;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_visit != 0;
	}
    
    
}
