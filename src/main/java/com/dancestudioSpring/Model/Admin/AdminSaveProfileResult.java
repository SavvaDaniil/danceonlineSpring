package com.dancestudioSpring.Model.Admin;

import com.dancestudioSpring.Entity.Admin;

public class AdminSaveProfileResult {

    private String status;
    private String errors;
    private Admin admin;
    private boolean isNeedRelogin;
    
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public boolean isNeedRelogin() {
		return isNeedRelogin;
	}
	public void setNeedRelogin(boolean isNeedRelogin) {
		this.isNeedRelogin = isNeedRelogin;
	}
	public AdminSaveProfileResult(Admin admin) {
		super();
		this.admin = admin;
		this.isNeedRelogin = false;
	}
	public AdminSaveProfileResult(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
		this.isNeedRelogin = false;
	}
	

    
	
}
