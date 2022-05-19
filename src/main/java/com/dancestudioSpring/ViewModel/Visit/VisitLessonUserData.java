package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;

import com.dancestudioSpring.Model.DanceGroupLessonUserVisitsData;

public class VisitLessonUserData {

    private int id_of_user;
    private String secondname;
    private String firstname;
    //public Dictionary<DateTime, LinkedList<VisitLessonUserVisitStatus>> userVisitsByDate; 
    private ArrayList<DanceGroupLessonUserVisitsData> danceGroupLessonUserVisitsDatas;

    private boolean isTimeLimitConnectionToDanceGoupExceeded;

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public ArrayList<DanceGroupLessonUserVisitsData> getDanceGroupLessonUserVisitsDatas() {
		return danceGroupLessonUserVisitsDatas;
	}

	public void setDanceGroupLessonUserVisitsDatas(
			ArrayList<DanceGroupLessonUserVisitsData> danceGroupLessonUserVisitsDatas) {
		this.danceGroupLessonUserVisitsDatas = danceGroupLessonUserVisitsDatas;
	}

	public boolean isTimeLimitConnectionToDanceGoupExceeded() {
		return isTimeLimitConnectionToDanceGoupExceeded;
	}

	public void setTimeLimitConnectionToDanceGoupExceeded(boolean isTimeLimitConnectionToDanceGoupExceeded) {
		this.isTimeLimitConnectionToDanceGoupExceeded = isTimeLimitConnectionToDanceGoupExceeded;
	}

	public VisitLessonUserData(int id_of_user, String secondname, String firstname) {
		super();
		this.id_of_user = id_of_user;
		this.secondname = secondname;
		this.firstname = firstname;
	}

	
    
}
