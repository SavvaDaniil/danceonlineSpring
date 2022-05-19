package com.dancestudioSpring.DTO.User;

public class UserRegistrationDTO {

    private String username;
    private String password;
    private String passwordAgain;
    private String secondname;
    private String firstname;
    private String phone;
    private int sex;
    private String dateOfBirthdayStr;
    private String parentFio;
    private String parentPhone;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
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
	public String getDateOfBirthdayStr() {
		return dateOfBirthdayStr;
	}
	public void setDateOfBirthdayStr(String dateOfBirthdayStr) {
		this.dateOfBirthdayStr = dateOfBirthdayStr;
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
    
    
}
