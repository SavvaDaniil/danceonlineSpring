package com.dancestudioSpring.DTO.DanceGroup;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupNewDTO implements ValidatedObject {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.name != null;
	}
	
}
