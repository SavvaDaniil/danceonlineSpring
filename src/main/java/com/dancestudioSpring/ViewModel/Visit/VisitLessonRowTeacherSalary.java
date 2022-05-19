package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;

public class VisitLessonRowTeacherSalary {

    private ArrayList<VisitLessonTeacherSalary> visitLessonTeacherSalaries;
    private int summAll;
    
	public ArrayList<VisitLessonTeacherSalary> getVisitLessonTeacherSalaries() {
		return visitLessonTeacherSalaries;
	}
	public void setVisitLessonTeacherSalaries(ArrayList<VisitLessonTeacherSalary> visitLessonTeacherSalaries) {
		this.visitLessonTeacherSalaries = visitLessonTeacherSalaries;
	}
	public int getSummAll() {
		return summAll;
	}
	public void setSummAll(int summAll) {
		this.summAll = summAll;
	}
	public VisitLessonRowTeacherSalary() {
		super();
		this.visitLessonTeacherSalaries = new ArrayList<VisitLessonTeacherSalary>();
	}
    
    
}
