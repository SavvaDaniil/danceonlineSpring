package com.dancestudioSpring.DTO.User;

import com.dancestudioSpring.Interface.ValidatedObject;

public class UserNewDTO implements ValidatedObject {

    private String secondname;
    private String firstname;
    private String phone;
    private String comment;


	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public boolean isValid() {
		return this.firstname != null;
	}
    
    
}
