package com.dancestudioSpring.ViewModel.Branch;

public class BranchLiteViewModel {

    private int id;
    private String name;
    private String coordinates;
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
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
	public BranchLiteViewModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BranchLiteViewModel(int id, String name, String coordinates) {
		super();
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
	}
    
    
}
