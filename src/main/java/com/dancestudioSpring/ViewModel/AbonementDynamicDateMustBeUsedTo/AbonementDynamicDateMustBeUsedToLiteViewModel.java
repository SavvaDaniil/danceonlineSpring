package com.dancestudioSpring.ViewModel.AbonementDynamicDateMustBeUsedTo;

import java.util.Date;

public class AbonementDynamicDateMustBeUsedToLiteViewModel {

    private int id;

    private int status;

    private Date dateFrom;
    private Date dateTo;
    private Date dateUsedTo;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Date getDateUsedTo() {
		return dateUsedTo;
	}
	public void setDateUsedTo(Date dateUsedTo) {
		this.dateUsedTo = dateUsedTo;
	}
	public AbonementDynamicDateMustBeUsedToLiteViewModel(int id, int status, Date dateFrom, Date dateTo,
			Date dateUsedTo) {
		super();
		this.id = id;
		this.status = status;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.dateUsedTo = dateUsedTo;
	}

	
    
}
