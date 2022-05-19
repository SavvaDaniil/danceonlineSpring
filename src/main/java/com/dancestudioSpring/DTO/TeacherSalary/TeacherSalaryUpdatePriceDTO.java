package com.dancestudioSpring.DTO.TeacherSalary;

import com.dancestudioSpring.Interface.ValidatedObject;

public class TeacherSalaryUpdatePriceDTO implements ValidatedObject {

    private int id_of_teacher_salary;

    private int priceFact;

    private int status;

	public int getId_of_teacher_salary() {
		return id_of_teacher_salary;
	}

	public void setId_of_teacher_salary(int id_of_teacher_salary) {
		this.id_of_teacher_salary = id_of_teacher_salary;
	}

	public int getPriceFact() {
		return priceFact;
	}

	public void setPriceFact(int priceFact) {
		this.priceFact = priceFact;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_teacher_salary != 0;
	}
    
    
}
