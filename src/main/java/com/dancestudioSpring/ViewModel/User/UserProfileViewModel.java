package com.dancestudioSpring.ViewModel.User;

import java.util.Date;

public class UserProfileViewModel {

    private int id;
    private String secondname;
    private String firstname;
    private String phone;
    private int sex;
    private Date dateOfBirthday;
    private String username;
    private String comment;
    private String parentFio;
    private String parentPhone;
    private int statusOfAdmin;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
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
	public int getStatusOfAdmin() {
		return statusOfAdmin;
	}
	public void setStatusOfAdmin(int statusOfAdmin) {
		this.statusOfAdmin = statusOfAdmin;
	}
	
	
	public UserProfileViewModel(int id, String secondname, String firstname, String phone, int sex, Date dateOfBirthday,
			String username, String parentFio, String parentPhone) {
		super();
		this.id = id;
		this.secondname = secondname;
		this.firstname = firstname;
		this.phone = phone;
		this.sex = sex;
		this.dateOfBirthday = dateOfBirthday;
		this.username = username;
		this.parentFio = parentFio;
		this.parentPhone = parentPhone;
	}
	public UserProfileViewModel(int id, String secondname, String firstname, String phone, int sex, Date dateOfBirthday,
			String username, String comment, String parentFio, String parentPhone, int statusOfAdmin) {
		super();
		this.id = id;
		this.secondname = secondname;
		this.firstname = firstname;
		this.phone = phone;
		this.sex = sex;
		this.dateOfBirthday = dateOfBirthday;
		this.username = username;
		this.comment = comment;
		this.parentFio = parentFio;
		this.parentPhone = parentPhone;
		this.statusOfAdmin = statusOfAdmin;
	}

	
	
    
    
}
