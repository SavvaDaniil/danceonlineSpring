package com.dancestudioSpring.ViewModel.DanceGroup;

public class DanceGroupByDanceGroupDayOfWeekLiteViewModel {

    public int id_of_dance_group;
    public int id_of_dance_group_day_of_week;
    public String name;
    
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DanceGroupByDanceGroupDayOfWeekLiteViewModel(int id_of_dance_group, int id_of_dance_group_day_of_week,
			String name) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.name = name;
	}
    
    
}
