package com.dancestudioSpring.ViewModel.DanceGroup;

import java.util.ArrayList;

public class DanceGroupScheduleWithNameOfDayOfWeek {

    public String name_of_day_of_week;
    public ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels;

    public DanceGroupScheduleViewModel danceGroupScheduleViewModel;

	public String getName_of_day_of_week() {
		return name_of_day_of_week;
	}

	public void setName_of_day_of_week(String name_of_day_of_week) {
		this.name_of_day_of_week = name_of_day_of_week;
	}

	public ArrayList<DanceGroupScheduleViewModel> getDanceGroupScheduleViewModels() {
		return danceGroupScheduleViewModels;
	}

	public void setDanceGroupScheduleViewModels(ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels) {
		this.danceGroupScheduleViewModels = danceGroupScheduleViewModels;
	}

	public DanceGroupScheduleViewModel getDanceGroupScheduleViewModel() {
		return danceGroupScheduleViewModel;
	}

	public void setDanceGroupScheduleViewModel(DanceGroupScheduleViewModel danceGroupScheduleViewModel) {
		this.danceGroupScheduleViewModel = danceGroupScheduleViewModel;
	}

	public DanceGroupScheduleWithNameOfDayOfWeek(String name_of_day_of_week,
			ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels) {
		super();
		this.name_of_day_of_week = name_of_day_of_week;
		this.danceGroupScheduleViewModels = danceGroupScheduleViewModels;
	}

	public DanceGroupScheduleWithNameOfDayOfWeek(String name_of_day_of_week,
			DanceGroupScheduleViewModel danceGroupScheduleViewModel) {
		super();
		this.name_of_day_of_week = name_of_day_of_week;
		this.danceGroupScheduleViewModel = danceGroupScheduleViewModel;
	}


    
    
}
