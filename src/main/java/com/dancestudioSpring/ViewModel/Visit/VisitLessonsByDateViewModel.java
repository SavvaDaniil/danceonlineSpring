package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;

public class VisitLessonsByDateViewModel {

    public ArrayList<VisitLessonHeaderDate> visitLessonHeaderDates;
    public ArrayList<VisitLessonUserData> visitLessonUserDatas;
    public VisitLessonRowPurchaseSumm visitLessonRowPurchaseSumm;
    public VisitLessonRowUserCount visitLessonRowUserCount;
    public VisitLessonRowTeacherSalary visitLessonRowTeacherSalary;
	public ArrayList<VisitLessonHeaderDate> getVisitLessonHeaderDates() {
		return visitLessonHeaderDates;
	}
	public void setVisitLessonHeaderDates(ArrayList<VisitLessonHeaderDate> visitLessonHeaderDates) {
		this.visitLessonHeaderDates = visitLessonHeaderDates;
	}
	public ArrayList<VisitLessonUserData> getVisitLessonUserDatas() {
		return visitLessonUserDatas;
	}
	public void setVisitLessonUserDatas(ArrayList<VisitLessonUserData> visitLessonUserDatas) {
		this.visitLessonUserDatas = visitLessonUserDatas;
	}
	public VisitLessonRowPurchaseSumm getVisitLessonRowPurchaseSumm() {
		return visitLessonRowPurchaseSumm;
	}
	public void setVisitLessonRowPurchaseSumm(VisitLessonRowPurchaseSumm visitLessonRowPurchaseSumm) {
		this.visitLessonRowPurchaseSumm = visitLessonRowPurchaseSumm;
	}
	public VisitLessonRowUserCount getVisitLessonRowUserCount() {
		return visitLessonRowUserCount;
	}
	public void setVisitLessonRowUserCount(VisitLessonRowUserCount visitLessonRowUserCount) {
		this.visitLessonRowUserCount = visitLessonRowUserCount;
	}
	public VisitLessonRowTeacherSalary getVisitLessonRowTeacherSalary() {
		return visitLessonRowTeacherSalary;
	}
	public void setVisitLessonRowTeacherSalary(VisitLessonRowTeacherSalary visitLessonRowTeacherSalary) {
		this.visitLessonRowTeacherSalary = visitLessonRowTeacherSalary;
	}
	public VisitLessonsByDateViewModel(ArrayList<VisitLessonHeaderDate> visitLessonHeaderDates,
			ArrayList<VisitLessonUserData> visitLessonUserDatas, VisitLessonRowPurchaseSumm visitLessonRowPurchaseSumm,
			VisitLessonRowUserCount visitLessonRowUserCount, VisitLessonRowTeacherSalary visitLessonRowTeacherSalary) {
		super();
		this.visitLessonHeaderDates = visitLessonHeaderDates;
		this.visitLessonUserDatas = visitLessonUserDatas;
		this.visitLessonRowPurchaseSumm = visitLessonRowPurchaseSumm;
		this.visitLessonRowUserCount = visitLessonRowUserCount;
		this.visitLessonRowTeacherSalary = visitLessonRowTeacherSalary;
	}
    
    
}
