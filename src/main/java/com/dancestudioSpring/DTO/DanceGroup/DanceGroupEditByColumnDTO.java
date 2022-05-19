package com.dancestudioSpring.DTO.DanceGroup;

import com.dancestudioSpring.Interface.ValidatedObject;

public class DanceGroupEditByColumnDTO implements ValidatedObject {

	private int id_of_dance_group;
	private String name;
	private String value;
	
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
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
		return this.id_of_dance_group != 0;
	}
	
	
}
