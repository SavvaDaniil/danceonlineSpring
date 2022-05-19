package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;

public class VisitLessonRowUserCount {

    public ArrayList<VisitLessonUserCount> visitLessonUserCounts;
    public int countAll;
    
	public ArrayList<VisitLessonUserCount> getVisitLessonUserCounts() {
		return visitLessonUserCounts;
	}
	public void setVisitLessonUserCounts(ArrayList<VisitLessonUserCount> visitLessonUserCounts) {
		this.visitLessonUserCounts = visitLessonUserCounts;
	}
	public int getCountAll() {
		return countAll;
	}
	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}
	public VisitLessonRowUserCount() {
		super();
		this.visitLessonUserCounts = new ArrayList<VisitLessonUserCount>();
	}
	public VisitLessonRowUserCount(ArrayList<VisitLessonUserCount> visitLessonUserCounts) {
		super();
		this.visitLessonUserCounts = visitLessonUserCounts;
	}
    
	
}
