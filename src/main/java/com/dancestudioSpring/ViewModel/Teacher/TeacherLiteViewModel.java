package com.dancestudioSpring.ViewModel.Teacher;

public class TeacherLiteViewModel {

    private int id;
    private String name;
    private String posterSrc;
    private boolean isAnyDanceGroup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosterSrc() {
		return posterSrc;
	}
	public void setPosterSrc(String posterSrc) {
		this.posterSrc = posterSrc;
	}
	public boolean isAnyDanceGroup() {
		return isAnyDanceGroup;
	}
	public void setAnyDanceGroup(boolean isAnyDanceGroup) {
		this.isAnyDanceGroup = isAnyDanceGroup;
	}
	
	
	
	public TeacherLiteViewModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TeacherLiteViewModel(int id, String name, String posterSrc) {
		super();
		this.id = id;
		this.name = name;
		this.posterSrc = posterSrc;
	}
	public TeacherLiteViewModel(int id, String name, String posterSrc, boolean isAnyDanceGroup) {
		super();
		this.id = id;
		this.name = name;
		this.posterSrc = posterSrc;
		this.isAnyDanceGroup = isAnyDanceGroup;
	}
    
    
}
