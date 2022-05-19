package com.dancestudioSpring.ViewModel.User;

import java.util.Date;

public class UserSearchPreviewViewModel {

    private int id;
    private String secondname;
    private String firstname;
    private String phone;
    private Date dateOfAdd;
    private Date dateOfLastVisit;
    
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
	public Date getDateOfAdd() {
		return dateOfAdd;
	}
	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}
	public Date getDateOfLastVisit() {
		return dateOfLastVisit;
	}
	public void setDateOfLastVisit(Date dateOfLastVisit) {
		this.dateOfLastVisit = dateOfLastVisit;
	}
	public UserSearchPreviewViewModel(int id, String secondname, String firstname, String phone, Date dateOfAdd,
			Date dateOfLastVisit) {
		super();
		this.id = id;
		this.secondname = secondname;
		this.firstname = firstname;
		this.phone = phone;
		this.dateOfAdd = dateOfAdd;
		this.dateOfLastVisit = dateOfLastVisit;
	}

	
    
}
