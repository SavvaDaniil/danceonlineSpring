package com.dancestudioSpring.Model.User;

public class UserQRCode {

    public int id_of_user;
    public String checkQR;
    
	public int getId_of_user() {
		return id_of_user;
	}
	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}
	public String getCheckQR() {
		return checkQR;
	}
	public void setCheckQR(String checkQR) {
		this.checkQR = checkQR;
	}
	
	public UserQRCode(int id_of_user, String checkQR) {
		super();
		this.id_of_user = id_of_user;
		this.checkQR = checkQR;
	}
    
	
}
