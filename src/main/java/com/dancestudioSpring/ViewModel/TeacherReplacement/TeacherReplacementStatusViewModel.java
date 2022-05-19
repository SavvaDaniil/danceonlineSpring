package com.dancestudioSpring.ViewModel.TeacherReplacement;

import java.util.ArrayList;
import java.util.Date;

import com.dancestudioSpring.ViewModel.Teacher.TeacherLiteViewModel;

public class TeacherReplacementStatusViewModel {

    public int id_of_teacher_replace;
    public ArrayList<TeacherLiteViewModel> teacherLiteViewModels;

    public Date dateOfDay;
    public String name_of_dance_group;
    public String name_of_dance_group_day_of_week;
    
	public int getId_of_teacher_replace() {
		return id_of_teacher_replace;
	}
	public void setId_of_teacher_replace(int id_of_teacher_replace) {
		this.id_of_teacher_replace = id_of_teacher_replace;
	}
	public ArrayList<TeacherLiteViewModel> getTeacherLiteViewModels() {
		return teacherLiteViewModels;
	}
	public void setTeacherLiteViewModels(ArrayList<TeacherLiteViewModel> teacherLiteViewModels) {
		this.teacherLiteViewModels = teacherLiteViewModels;
	}
	public Date getDateOfDay() {
		return dateOfDay;
	}
	public void setDateOfDay(Date dateOfDay) {
		this.dateOfDay = dateOfDay;
	}
	public String getName_of_dance_group() {
		return name_of_dance_group;
	}
	public void setName_of_dance_group(String name_of_dance_group) {
		this.name_of_dance_group = name_of_dance_group;
	}
	public String getName_of_dance_group_day_of_week() {
		return name_of_dance_group_day_of_week;
	}
	public void setName_of_dance_group_day_of_week(String name_of_dance_group_day_of_week) {
		this.name_of_dance_group_day_of_week = name_of_dance_group_day_of_week;
	}
	public TeacherReplacementStatusViewModel(int id_of_teacher_replace,
			ArrayList<TeacherLiteViewModel> teacherLiteViewModels, Date dateOfDay, String name_of_dance_group,
			String name_of_dance_group_day_of_week) {
		super();
		this.id_of_teacher_replace = id_of_teacher_replace;
		this.teacherLiteViewModels = teacherLiteViewModels;
		this.dateOfDay = dateOfDay;
		this.name_of_dance_group = name_of_dance_group;
		this.name_of_dance_group_day_of_week = name_of_dance_group_day_of_week;
	}
    
    
}
