package com.dancestudioSpring.ViewModel.Abonement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import com.dancestudioSpring.ViewModel.AbonementDynamicDateMustBeUsedTo.AbonementDynamicDateMustBeUsedToLiteViewModel;

public class AbonementEditViewModel {

    private int id;
    private String name;
    private String specialStatus;
    private int days;
    private int price;
    private int visits;
    private int status_of_visible;
    private int status_of_deleted;
    private int status_for_app;
    private int is_trial;
    private int is_private;
    private ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> abonementDynamicDatesMustBeUsedToLiteViewModel;

    private LinkedList<Integer> dateDays;
    private LinkedList<Integer> dateMonth;
    private LinkedList<Integer> dateYears;
    
    
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
	public String getSpecialStatus() {
		return specialStatus;
	}
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
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
	public int getStatus_of_deleted() {
		return status_of_deleted;
	}
	public void setStatus_of_deleted(int status_of_deleted) {
		this.status_of_deleted = status_of_deleted;
	}
	public int getStatus_for_app() {
		return status_for_app;
	}
	public void setStatus_for_app(int status_for_app) {
		this.status_for_app = status_for_app;
	}
	public int getIs_trial() {
		return is_trial;
	}
	public void setIs_trial(int is_trial) {
		this.is_trial = is_trial;
	}
	public int getIs_private() {
		return is_private;
	}
	public void setIs_private(int is_private) {
		this.is_private = is_private;
	}
	public ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> getAbonementDynamicDatesMustBeUsedToLiteViewModel() {
		return abonementDynamicDatesMustBeUsedToLiteViewModel;
	}
	public void setAbonementDynamicDatesMustBeUsedToLiteViewModel(
			ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> abonementDynamicDatesMustBeUsedToLiteViewModel) {
		this.abonementDynamicDatesMustBeUsedToLiteViewModel = abonementDynamicDatesMustBeUsedToLiteViewModel;
	}
	public AbonementEditViewModel(int id, String name, String specialStatus, int days, int price, int visits,
			int status_of_visible, int status_of_deleted, int status_for_app, int is_trial, int is_private,
			ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> abonementDynamicDatesMustBeUsedToLiteViewModel) {
		super();
		this.id = id;
		this.name = name;
		this.specialStatus = specialStatus;
		this.days = days;
		this.price = price;
		this.visits = visits;
		this.status_of_visible = status_of_visible;
		this.status_of_deleted = status_of_deleted;
		this.status_for_app = status_for_app;
		this.is_trial = is_trial;
		this.is_private = is_private;
		this.abonementDynamicDatesMustBeUsedToLiteViewModel = abonementDynamicDatesMustBeUsedToLiteViewModel;

		this.dateDays = new LinkedList<Integer>();
        //String value;
        for (int i = 1; i <= 31; i++)
        {
            //value = (i < 10 ? "0" + i.ToString() : i.ToString());
        	this.dateDays.add(i);
        }
        this.dateMonth = new LinkedList<Integer>();
        for (int i = 1; i <= 12; i++)
        {
            //value = (i < 10 ? "0" + i.ToString() : i.ToString());
        	this.dateMonth.add(i);
        }
        this.dateYears = new LinkedList<Integer>();
        for (int i = Calendar.getInstance().get(Calendar.YEAR) + 1; i > 2000; i--)
        {
        	this.dateYears.add(i);
        }
	}
	
    
    
}
