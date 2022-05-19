package com.dancestudioSpring.Model.User;

import com.dancestudioSpring.Entity.User;

public class UserSaveProfileResult {

    public User user;
    public String status;
    public String errors;
    public boolean isNeedRelogin;
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public boolean isNeedRelogin() {
		return isNeedRelogin;
	}
	public void setNeedRelogin(boolean isNeedRelogin) {
		this.isNeedRelogin = isNeedRelogin;
	}
	
	
	public UserSaveProfileResult() {
		super();
	}
	public UserSaveProfileResult(User user) {
		super();
		this.user = user;
	}
	public UserSaveProfileResult(User user, boolean isNeedRelogin) {
		super();
		this.user = user;
		this.isNeedRelogin = isNeedRelogin;
	}
	public UserSaveProfileResult(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
    
	
}
