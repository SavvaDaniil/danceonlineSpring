package com.dancestudioSpring.ViewModel.Abonement;

public class AbonementLiteWithPrivateConnectionToUserViewModel {

    private int id;
    private String name;
    private int isPrivate;
    private int status;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(int isPrivate) {
		this.isPrivate = isPrivate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public AbonementLiteWithPrivateConnectionToUserViewModel(int id, String name, int isPrivate, int status) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.status = status;
	}
    
    
}
