package com.dancestudioSpring.DTO.Visit;

import com.dancestudioSpring.Interface.ValidatedObject;

public class VisitAnalyticsDTO implements ValidatedObject {

    private String filterDateFrom;

    private String filterDateTo;

    private int id_of_dance_group;

    private int id_of_dance_group_day_of_week;

	public String getFilterDateFrom() {
		return filterDateFrom;
	}

	public void setFilterDateFrom(String filterDateFrom) {
		this.filterDateFrom = filterDateFrom;
	}

	public String getFilterDateTo() {
		return filterDateTo;
	}

	public void setFilterDateTo(String filterDateTo) {
		this.filterDateTo = filterDateTo;
	}

	public int getId_of_dance_group() {
		return id_of_dance_group;
	}

	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}

	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}

	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_dance_group != 0;
	}
    
    
}
