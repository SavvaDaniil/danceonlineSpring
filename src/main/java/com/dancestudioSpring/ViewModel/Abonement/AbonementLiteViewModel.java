package com.dancestudioSpring.ViewModel.Abonement;

public class AbonementLiteViewModel {

    private int id;
    private String name;
    private String special_status;
    private int days;
    private int price;
    private int visits;
    private int status_of_visible;
    private int status_for_app;
    private int is_private;
    private int is_trial;
    
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
	public String getSpecial_status() {
		return special_status;
	}
	public void setSpecial_status(String special_status) {
		this.special_status = special_status;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getStatus_of_visible() {
		return status_of_visible;
	}
	public void setStatus_of_visible(int status_of_visible) {
		this.status_of_visible = status_of_visible;
	}
	public int getStatus_for_app() {
		return status_for_app;
	}
	public void setStatus_for_app(int status_for_app) {
		this.status_for_app = status_for_app;
	}
	public int getIs_private() {
		return is_private;
	}
	public void setIs_private(int is_private) {
		this.is_private = is_private;
	}
	public int getIs_trial() {
		return is_trial;
	}
	public void setIs_trial(int is_trial) {
		this.is_trial = is_trial;
	}
	
	public AbonementLiteViewModel(int id, String name, String special_status, int days, int price, int visits,
			int status_of_visible, int status_for_app, int is_private, int is_trial) {
		super();
		this.id = id;
		this.name = name;
		this.special_status = special_status;
		this.days = days;
		this.price = price;
		this.visits = visits;
		this.status_of_visible = status_of_visible;
		this.status_for_app = status_for_app;
		this.is_private = is_private;
		this.is_trial = is_trial;
	}
    
    
}
