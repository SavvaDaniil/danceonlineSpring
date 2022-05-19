package com.dancestudioSpring.DTO.Teacher;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherNewDTO implements ValidatedObject {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		return this.name != null;
	}
}
