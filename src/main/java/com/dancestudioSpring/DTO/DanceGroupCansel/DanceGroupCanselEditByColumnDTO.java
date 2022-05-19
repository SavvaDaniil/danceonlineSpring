package com.dancestudioSpring.DTO.DanceGroupCansel;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupCanselEditByColumnDTO implements ValidatedObject {

    public int id_of_dance_group_cansel;

    public String name;

    public int value;

    public String dateData;

	public int getId_of_dance_group_cansel() {
		return id_of_dance_group_cansel;
	}

	public void setId_of_dance_group_cansel(int id_of_dance_group_cansel) {
		this.id_of_dance_group_cansel = id_of_dance_group_cansel;
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
		// TODO Auto-generated method stub
		return this.id_of_dance_group_cansel != 0;
	}
    
    
}
