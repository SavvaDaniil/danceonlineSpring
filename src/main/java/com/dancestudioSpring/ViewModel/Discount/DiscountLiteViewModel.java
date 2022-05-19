package com.dancestudioSpring.ViewModel.Discount;

import java.util.Date;

public class DiscountLiteViewModel {

    public int schetchik;
    public int id;
    public String name;
    public Date dateOfAdd;
    
	public int getSchetchik() {
		return schetchik;
	}
	public void setSchetchik(int schetchik) {
		this.schetchik = schetchik;
	}
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
	public Date getDateOfAdd() {
		return dateOfAdd;
	}
	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}
	
	
	public DiscountLiteViewModel(int id, String name, Date dateOfAdd) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfAdd = dateOfAdd;
	}
	public DiscountLiteViewModel(int schetchik, int id, String name, Date dateOfAdd) {
		super();
		this.schetchik = schetchik;
		this.id = id;
		this.name = name;
		this.dateOfAdd = dateOfAdd;
	}
    
	
}
