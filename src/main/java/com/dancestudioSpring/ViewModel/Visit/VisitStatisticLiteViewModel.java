package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;
import java.util.Date;

import com.dancestudioSpring.ViewModel.TeacherSalary.TeacherSalaryLiteViewModel;

public class VisitStatisticLiteViewModel {

    private Date dateFrom;
    private Date dateTo;
    private int id_of_dance_group;
    private String nameOfDanceGroup;

    private ArrayList<VisitAnalyticsLiteViewModel> visitAnalyticsLiteViewModels;
    private TeacherSalaryLiteViewModel teacherSalaryLiteViewModel;
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
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}
	public String getNameOfDanceGroup() {
		return nameOfDanceGroup;
	}
	public void setNameOfDanceGroup(String nameOfDanceGroup) {
		this.nameOfDanceGroup = nameOfDanceGroup;
	}
	public ArrayList<VisitAnalyticsLiteViewModel> getVisitAnalyticsLiteViewModels() {
		return visitAnalyticsLiteViewModels;
	}
	public void setVisitAnalyticsLiteViewModels(ArrayList<VisitAnalyticsLiteViewModel> visitAnalyticsLiteViewModels) {
		this.visitAnalyticsLiteViewModels = visitAnalyticsLiteViewModels;
	}
	public TeacherSalaryLiteViewModel getTeacherSalaryLiteViewModel() {
		return teacherSalaryLiteViewModel;
	}
	public void setTeacherSalaryLiteViewModel(TeacherSalaryLiteViewModel teacherSalaryLiteViewModel) {
		this.teacherSalaryLiteViewModel = teacherSalaryLiteViewModel;
	}
	public VisitStatisticLiteViewModel(Date dateFrom, Date dateTo, int id_of_dance_group, String nameOfDanceGroup,
			ArrayList<VisitAnalyticsLiteViewModel> visitAnalyticsLiteViewModels,
			TeacherSalaryLiteViewModel teacherSalaryLiteViewModel) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.id_of_dance_group = id_of_dance_group;
		this.nameOfDanceGroup = nameOfDanceGroup;
		this.visitAnalyticsLiteViewModels = visitAnalyticsLiteViewModels;
		this.teacherSalaryLiteViewModel = teacherSalaryLiteViewModel;
	}
    
    
}
