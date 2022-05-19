package com.dancestudioSpring.ViewModel.DanceGroup;

public class DanceGroupLiteViewModel {

    public int id;
    public String name;
    public String teacherName;
    public int status;
    public int statusOfApp;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatusOfApp() {
		return statusOfApp;
	}
	public void setStatusOfApp(int statusOfApp) {
		this.statusOfApp = statusOfApp;
	}
	public DanceGroupLiteViewModel(int id, String name, String teacherName, int status, int statusOfApp) {
		super();
		this.id = id;
		this.name = name;
		this.teacherName = teacherName;
		this.status = status;
		this.statusOfApp = statusOfApp;
	}
    
    
}
