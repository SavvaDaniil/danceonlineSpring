package com.dancestudioSpring.Model.User;

import com.dancestudioSpring.Entity.User;

public class UserLoginResult {

    public String status;
    public String errors;
    public User user;
    public int id_of_user;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}
	
	public UserLoginResult(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	public UserLoginResult(String status, String errors, User user) {
		super();
		this.status = status;
		this.errors = errors;
		this.user = user;
	}
	public UserLoginResult(String status, String errors, int id_of_user) {
		super();
		this.status = status;
		this.errors = errors;
		this.id_of_user = id_of_user;
	}
    
	
}
