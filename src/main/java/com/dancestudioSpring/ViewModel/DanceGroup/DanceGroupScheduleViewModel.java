package com.dancestudioSpring.ViewModel.DanceGroup;

public class DanceGroupScheduleViewModel {

    public int id_of_dance_group;
    public String name_of_dance_group;
    public int id_of_dance_group_day_of_week;
    public int isEvent;
    public int dayOfWeek;
    public String time_from;
    public String time_to;
    public String date_of_day;
    public int id_of_teacher;
    public String teacher_name;
    public int id_of_branch;
    public String name_of_branch;
    public int statusOfCreative;
    public int isActiveReservation;
    public int isCansel;

    public boolean isReplacementExistForLesson;

    public String description;
    public String coordinates_of_branch;
    public int id_of_teacher_replacement;
    public String name_of_teacher_replacement;
    public String teacherPosterSrc;
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}
	public String getName_of_dance_group() {
		return name_of_dance_group;
	}
	public void setName_of_dance_group(String name_of_dance_group) {
		this.name_of_dance_group = name_of_dance_group;
	}
	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}
	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
	public int getIsEvent() {
		return isEvent;
	}
	public void setIsEvent(int isEvent) {
		this.isEvent = isEvent;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTime_from() {
		return time_from;
	}
	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}
	public String getTime_to() {
		return time_to;
	}
	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}
	public String getDate_of_day() {
		return date_of_day;
	}
	public void setDate_of_day(String date_of_day) {
		this.date_of_day = date_of_day;
	}
	public int getId_of_teacher() {
		return id_of_teacher;
	}
	public void setId_of_teacher(int id_of_teacher) {
		this.id_of_teacher = id_of_teacher;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getId_of_branch() {
		return id_of_branch;
	}
	public void setId_of_branch(int id_of_branch) {
		this.id_of_branch = id_of_branch;
	}
	public String getName_of_branch() {
		return name_of_branch;
	}
	public void setName_of_branch(String name_of_branch) {
		this.name_of_branch = name_of_branch;
	}
	public int getStatusOfCreative() {
		return statusOfCreative;
	}
	public void setStatusOfCreative(int statusOfCreative) {
		this.statusOfCreative = statusOfCreative;
	}
	public int getIsActiveReservation() {
		return isActiveReservation;
	}
	public void setIsActiveReservation(int isActiveReservation) {
		this.isActiveReservation = isActiveReservation;
	}
	public int getIsCansel() {
		return isCansel;
	}
	public void setIsCansel(int isCansel) {
		this.isCansel = isCansel;
	}
	public boolean isReplacementExistForLesson() {
		return isReplacementExistForLesson;
	}
	public void setReplacementExistForLesson(boolean isReplacementExistForLesson) {
		this.isReplacementExistForLesson = isReplacementExistForLesson;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoordinates_of_branch() {
		return coordinates_of_branch;
	}
	public void setCoordinates_of_branch(String coordinates_of_branch) {
		this.coordinates_of_branch = coordinates_of_branch;
	}
	public int getId_of_teacher_replacement() {
		return id_of_teacher_replacement;
	}
	public void setId_of_teacher_replacement(int id_of_teacher_replacement) {
		this.id_of_teacher_replacement = id_of_teacher_replacement;
	}
	public String getName_of_teacher_replacement() {
		return name_of_teacher_replacement;
	}
	public void setName_of_teacher_replacement(String name_of_teacher_replacement) {
		this.name_of_teacher_replacement = name_of_teacher_replacement;
	}
	public String getTeacherPosterSrc() {
		return teacherPosterSrc;
	}
	public void setTeacherPosterSrc(String teacherPosterSrc) {
		this.teacherPosterSrc = teacherPosterSrc;
	}
	
	
	public DanceGroupScheduleViewModel(int id_of_dance_group, String name_of_dance_group,
			int id_of_dance_group_day_of_week, int isEvent, int dayOfWeek, String time_from, String time_to,
			String date_of_day, int id_of_teacher, String teacher_name, int id_of_branch, String name_of_branch,
			int statusOfCreative, int isActiveReservation, int isCansel, boolean isReplacementExistForLesson) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.isEvent = isEvent;
		this.dayOfWeek = dayOfWeek;
		this.time_from = time_from;
		this.time_to = time_to;
		this.date_of_day = date_of_day;
		this.id_of_teacher = id_of_teacher;
		this.teacher_name = teacher_name;
		this.id_of_branch = id_of_branch;
		this.name_of_branch = name_of_branch;
		this.statusOfCreative = statusOfCreative;
		this.isActiveReservation = isActiveReservation;
		this.isCansel = isCansel;
		this.isReplacementExistForLesson = isReplacementExistForLesson;
	}
	public DanceGroupScheduleViewModel(int id_of_dance_group, String name_of_dance_group,
			int id_of_dance_group_day_of_week, int isEvent, int dayOfWeek, String time_from, String time_to,
			String date_of_day, int id_of_teacher, String teacher_name, int id_of_branch, String name_of_branch,
			int statusOfCreative, int isActiveReservation, int isCansel, boolean isReplacementExistForLesson,
			String description, String coordinates_of_branch, int id_of_teacher_replacement,
			String name_of_teacher_replacement, String teacherPosterSrc) {
		super();
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.isEvent = isEvent;
		this.dayOfWeek = dayOfWeek;
		this.time_from = time_from;
		this.time_to = time_to;
		this.date_of_day = date_of_day;
		this.id_of_teacher = id_of_teacher;
		this.teacher_name = teacher_name;
		this.id_of_branch = id_of_branch;
		this.name_of_branch = name_of_branch;
		this.statusOfCreative = statusOfCreative;
		this.isActiveReservation = isActiveReservation;
		this.isCansel = isCansel;
		this.isReplacementExistForLesson = isReplacementExistForLesson;
		this.description = description;
		this.coordinates_of_branch = coordinates_of_branch;
		this.id_of_teacher_replacement = id_of_teacher_replacement;
		this.name_of_teacher_replacement = name_of_teacher_replacement;
		this.teacherPosterSrc = teacherPosterSrc;
	}
    
    
}
