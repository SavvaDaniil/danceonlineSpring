package com.dancestudioSpring.DTO.TeacherRate;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherRateNewDTO implements ValidatedObject {

    private int id_of_teacher;

	public int getId_of_teacher() {
		return id_of_teacher;
	}

	public void setId_of_teacher(int id_of_teacher) {
		this.id_of_teacher = id_of_teacher;
	}
	
	
	@Override
	public boolean isValid() {
		return id_of_teacher != 0;
	}
    
}
