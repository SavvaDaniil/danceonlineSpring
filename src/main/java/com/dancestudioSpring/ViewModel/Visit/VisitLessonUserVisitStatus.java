package com.dancestudioSpring.ViewModel.Visit;

public class VisitLessonUserVisitStatus {

    private int id_of_visit;
    private int visitLeft;

    private int isReservation;
    private int statusOfReservation;
	public int getId_of_visit() {
		return id_of_visit;
	}
	public void setId_of_visit(int id_of_visit) {
		this.id_of_visit = id_of_visit;
	}
	public int getVisitLeft() {
		return visitLeft;
	}
	public void setVisitLeft(int visitLeft) {
		this.visitLeft = visitLeft;
	}
	public int getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(int isReservation) {
		this.isReservation = isReservation;
	}
	public int getStatusOfReservation() {
		return statusOfReservation;
	}
	public void setStatusOfReservation(int statusOfReservation) {
		this.statusOfReservation = statusOfReservation;
	}
	public VisitLessonUserVisitStatus(int id_of_visit, int visitLeft, int isReservation, int statusOfReservation) {
		super();
		this.id_of_visit = id_of_visit;
		this.visitLeft = visitLeft;
		this.isReservation = isReservation;
		this.statusOfReservation = statusOfReservation;
	}
    
    
}
