package com.dancestudioSpring.ViewModel.TeacherRate;

public class TeacherRateLiteViewModel {

    private int id;
    private String special;
    private int students;
    private int how_much_money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public int getStudents() {
		return students;
	}
	public void setStudents(int students) {
		this.students = students;
	}
	public int getHow_much_money() {
		return how_much_money;
	}
	public void setHow_much_money(int how_much_money) {
		this.how_much_money = how_much_money;
	}
	
	public TeacherRateLiteViewModel(int id, String special, int students, int how_much_money) {
		super();
		this.id = id;
		this.special = special;
		this.students = students;
		this.how_much_money = how_much_money;
	}
    
    
}
