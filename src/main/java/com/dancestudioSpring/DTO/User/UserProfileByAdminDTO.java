package com.dancestudioSpring.DTO.User;

public class UserProfileByAdminDTO {

    private int id_of_user;

    private String secondname;
    private String firstname;
    private String phone;
    private int sex;
    private String username;
    private String comment;
    private String parentFio;
    private String parentPhone;
    private String passwordNew;
    
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
    
    
}
