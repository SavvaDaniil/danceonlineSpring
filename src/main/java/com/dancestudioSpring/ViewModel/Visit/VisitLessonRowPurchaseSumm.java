package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;

public class VisitLessonRowPurchaseSumm {

    public ArrayList<VisitLessonPurchaseSumm> visitLessonPurchaseSumms;
    public int summFromAll;
	public ArrayList<VisitLessonPurchaseSumm> getVisitLessonPurchaseSumms() {
		return visitLessonPurchaseSumms;
	}
	public void setVisitLessonPurchaseSumms(ArrayList<VisitLessonPurchaseSumm> visitLessonPurchaseSumms) {
		this.visitLessonPurchaseSumms = visitLessonPurchaseSumms;
	}
	public int getSummFromAll() {
		return summFromAll;
	}
	public void setSummFromAll(int summFromAll) {
		this.summFromAll = summFromAll;
	}
	
	public VisitLessonRowPurchaseSumm() {
		super();
		this.visitLessonPurchaseSumms = new ArrayList<VisitLessonPurchaseSumm>();
	}
	public VisitLessonRowPurchaseSumm(ArrayList<VisitLessonPurchaseSumm> visitLessonPurchaseSumms, int summFromAll) {
		super();
		this.visitLessonPurchaseSumms = visitLessonPurchaseSumms;
		this.summFromAll = summFromAll;
	}
    
    
}
