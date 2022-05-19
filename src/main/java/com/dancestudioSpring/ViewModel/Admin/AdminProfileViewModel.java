package com.dancestudioSpring.ViewModel.Admin;

public class AdminProfileViewModel {

	private String username;
	private String position;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public AdminProfileViewModel(String username, String position) {
		super();
		this.username = username;
		this.position = position;
	}
	
	
}
