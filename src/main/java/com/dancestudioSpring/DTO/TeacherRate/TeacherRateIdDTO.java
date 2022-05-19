package com.dancestudioSpring.DTO.TeacherRate;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherRateIdDTO implements ValidatedObject {

	private int id_of_teacher_rate;

	public int getId_of_teacher_rate() {
		return id_of_teacher_rate;
	}

	public void setId_of_teacher_rate(int id_of_teacher_rate) {
		this.id_of_teacher_rate = id_of_teacher_rate;
	}

	
	
	@Override
	public boolean isValid() {
		return id_of_teacher_rate != 0;
	}
	
}
