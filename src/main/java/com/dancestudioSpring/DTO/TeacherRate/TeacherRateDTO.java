package com.dancestudioSpring.DTO.TeacherRate;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherRateDTO implements ValidatedObject {

    private int id_of_teacher_rate;
    private String name;
    private int value;
    
	public int getId_of_teacher_rate() {
		return id_of_teacher_rate;
	}
	public void setId_of_teacher_rate(int id_of_teacher_rate) {
		this.id_of_teacher_rate = id_of_teacher_rate;
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
		return id_of_teacher_rate != 0 && name != null;
	}
    
}
