package com.dancestudioSpring.Model;

import java.util.ArrayList;

import com.dancestudioSpring.ViewModel.Visit.VisitLessonUserVisitStatus;

public class DanceGroupLessonUserVisitsData {

    private DanceGroupLesson danceGroupLesson;
    private ArrayList<VisitLessonUserVisitStatus> visitLessonUserVisitStatuses;
    
	public DanceGroupLesson getDanceGroupLesson() {
		return danceGroupLesson;
	}
	public void setDanceGroupLesson(DanceGroupLesson danceGroupLesson) {
		this.danceGroupLesson = danceGroupLesson;
	}
	public ArrayList<VisitLessonUserVisitStatus> getVisitLessonUserVisitStatuses() {
		return visitLessonUserVisitStatuses;
	}
	public void setVisitLessonUserVisitStatuses(ArrayList<VisitLessonUserVisitStatus> visitLessonUserVisitStatuses) {
		this.visitLessonUserVisitStatuses = visitLessonUserVisitStatuses;
	}
	public DanceGroupLessonUserVisitsData(DanceGroupLesson danceGroupLesson,
			ArrayList<VisitLessonUserVisitStatus> visitLessonUserVisitStatuses) {
		super();
		this.danceGroupLesson = danceGroupLesson;
		this.visitLessonUserVisitStatuses = visitLessonUserVisitStatuses;
	}
    
    
}
