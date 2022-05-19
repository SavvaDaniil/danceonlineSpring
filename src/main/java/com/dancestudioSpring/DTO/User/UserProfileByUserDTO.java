package com.dancestudioSpring.DTO.User;

public class UserProfileByUserDTO {

    private String username;

    private String secondname;
    private String firstname;
    private String phone;
    private int sex;
    private String parentFio;
    private String parentPhone;
    private String dateOfBirthday;

    private String passwordCurrent;
    private String passwordNew;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getParentFio() {
		return parentFio;
	}
	public void setParentFio(String parentFio) {
		this.parentFio = parentFio;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	public String getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setDateOfBirthday(String dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}
	public String getPasswordCurrent() {
		return passwordCurrent;
	}
	public void setPasswordCurrent(String passwordCurrent) {
		this.passwordCurrent = passwordCurrent;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
    
    
    
}
