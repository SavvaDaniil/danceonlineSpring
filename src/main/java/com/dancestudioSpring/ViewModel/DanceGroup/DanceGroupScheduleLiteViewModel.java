package com.dancestudioSpring.ViewModel.DanceGroup;

public class DanceGroupScheduleLiteViewModel {

    public int id;
    public String name;
    public String teacherName;
    public int status;
    public String timeFrom;
    public String timeTo;
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
	public String getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	public String getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
	public DanceGroupScheduleLiteViewModel(int id, String name, String teacherName, int status, String timeFrom,
			String timeTo) {
		super();
		this.id = id;
		this.name = name;
		this.teacherName = teacherName;
		this.status = status;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}
    
    
}
