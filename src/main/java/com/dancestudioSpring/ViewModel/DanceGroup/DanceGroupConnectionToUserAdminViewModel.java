package com.dancestudioSpring.ViewModel.DanceGroup;

public class DanceGroupConnectionToUserAdminViewModel {

    public int id;
    public String name;
    public int status;
    
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public DanceGroupConnectionToUserAdminViewModel(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
    
    
}
