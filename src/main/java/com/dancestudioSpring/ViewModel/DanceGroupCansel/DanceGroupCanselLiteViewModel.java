package com.dancestudioSpring.ViewModel.DanceGroupCansel;

import java.util.Date;

public class DanceGroupCanselLiteViewModel {

    public int id_of_dance_group_cansel;
    public int id_of_dance_group;
    public int status;
    public Date dateFrom;
    public Date dateTo;
    
	public int getId_of_dance_group_cansel() {
		return id_of_dance_group_cansel;
	}
	public void setId_of_dance_group_cansel(int id_of_dance_group_cansel) {
		this.id_of_dance_group_cansel = id_of_dance_group_cansel;
	}
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
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
	public DanceGroupCanselLiteViewModel(int id_of_dance_group_cansel, int id_of_dance_group, int status, Date dateFrom,
			Date dateTo) {
		super();
		this.id_of_dance_group_cansel = id_of_dance_group_cansel;
		this.id_of_dance_group = id_of_dance_group;
		this.status = status;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}
    
    
}
