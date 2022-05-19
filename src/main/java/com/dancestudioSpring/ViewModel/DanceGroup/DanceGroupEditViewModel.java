package com.dancestudioSpring.ViewModel.DanceGroup;

import java.util.ArrayList;


import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.Branch.BranchLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroupDayOfWeek.DanceGroupDayOfWeekLiteViewModel;
import com.dancestudioSpring.ViewModel.Teacher.TeacherLiteViewModel;

public class DanceGroupEditViewModel {

    public int id;
    public String name;
    
    public TeacherLiteViewModel teacherLiteViewModel;
    public ArrayList<TeacherLiteViewModel> teacherLiteViewModels;
    public String description;

    public BranchLiteViewModel branchLiteViewModel;
    public ArrayList<BranchLiteViewModel> branchLiteViewModels;

    public int status;
    public int isEvent;
    public int statusForApp;
    public int isCreative;
    public int isActiveReservation;
    public int isAbonementsAllowAll;

    public ArrayList<DanceGroupDayOfWeekLiteViewModel> danceGroupDayOfWeekLiteViewModels;
    public ArrayList<AbonementLiteViewModel> abonementLiteViewModels;
    public ArrayList<Integer> listIdOfConnectedAbonementsToDanceGroup;
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
	public TeacherLiteViewModel getTeacherLiteViewModel() {
		return teacherLiteViewModel;
	}
	public void setTeacherLiteViewModel(TeacherLiteViewModel teacherLiteViewModel) {
		this.teacherLiteViewModel = teacherLiteViewModel;
	}
	public ArrayList<TeacherLiteViewModel> getTeacherLiteViewModels() {
		return teacherLiteViewModels;
	}
	public void setTeacherLiteViewModels(ArrayList<TeacherLiteViewModel> teacherLiteViewModels) {
		this.teacherLiteViewModels = teacherLiteViewModels;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BranchLiteViewModel getBranchLiteViewModel() {
		return branchLiteViewModel;
	}
	public void setBranchLiteViewModel(BranchLiteViewModel branchLiteViewModel) {
		this.branchLiteViewModel = branchLiteViewModel;
	}
	public ArrayList<BranchLiteViewModel> getBranchLiteViewModels() {
		return branchLiteViewModels;
	}
	public void setBranchLiteViewModels(ArrayList<BranchLiteViewModel> branchLiteViewModels) {
		this.branchLiteViewModels = branchLiteViewModels;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsEvent() {
		return isEvent;
	}
	public void setIsEvent(int isEvent) {
		this.isEvent = isEvent;
	}

	public int getStatusForApp() {
		return statusForApp;
	}
	public void setStatusForApp(int statusForApp) {
		this.statusForApp = statusForApp;
	}
	public int getIsCreative() {
		return isCreative;
	}
	public void setIsCreative(int isCreative) {
		this.isCreative = isCreative;
	}
	public int getIsActiveReservation() {
		return isActiveReservation;
	}
	public void setIsActiveReservation(int isActiveReservation) {
		this.isActiveReservation = isActiveReservation;
	}
	public int getIsAbonementsAllowAll() {
		return isAbonementsAllowAll;
	}
	public void setIsAbonementsAllowAll(int isAbonementsAllowAll) {
		this.isAbonementsAllowAll = isAbonementsAllowAll;
	}
	public ArrayList<DanceGroupDayOfWeekLiteViewModel> getDanceGroupDayOfWeekLiteViewModels() {
		return danceGroupDayOfWeekLiteViewModels;
	}
	public void setDanceGroupDayOfWeekLiteViewModels(
			ArrayList<DanceGroupDayOfWeekLiteViewModel> danceGroupDayOfWeekLiteViewModels) {
		this.danceGroupDayOfWeekLiteViewModels = danceGroupDayOfWeekLiteViewModels;
	}
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModels() {
		return abonementLiteViewModels;
	}
	public void setAbonementLiteViewModels(ArrayList<AbonementLiteViewModel> abonementLiteViewModels) {
		this.abonementLiteViewModels = abonementLiteViewModels;
	}
	public ArrayList<Integer> getListIdOfConnectedAbonementsToDanceGroup() {
		return listIdOfConnectedAbonementsToDanceGroup;
	}
	public void setListIdOfConnectedAbonementsToDanceGroup(ArrayList<Integer> listIdOfConnectedAbonementsToDanceGroup) {
		this.listIdOfConnectedAbonementsToDanceGroup = listIdOfConnectedAbonementsToDanceGroup;
	}
	public DanceGroupEditViewModel(int id, String name, TeacherLiteViewModel teacherLiteViewModel,
			ArrayList<TeacherLiteViewModel> teacherLiteViewModels, String description,
			BranchLiteViewModel branchLiteViewModel, ArrayList<BranchLiteViewModel> branchLiteViewModels, int status,
			int isEvent, int statusForApp, int isCreative, int isActiveReservation, int isAbonementsAllowAll,
			ArrayList<DanceGroupDayOfWeekLiteViewModel> danceGroupDayOfWeekLiteViewModels,
			ArrayList<AbonementLiteViewModel> abonementLiteViewModels,
			ArrayList<Integer> listIdOfConnectedAbonementsToDanceGroup) {
		super();
		this.id = id;
		this.name = name;
		this.teacherLiteViewModel = teacherLiteViewModel;
		this.teacherLiteViewModels = teacherLiteViewModels;
		this.description = description;
		this.branchLiteViewModel = branchLiteViewModel;
		this.branchLiteViewModels = branchLiteViewModels;
		this.status = status;
		this.isEvent = isEvent;
		this.statusForApp = statusForApp;
		this.isCreative = isCreative;
		this.isActiveReservation = isActiveReservation;
		this.isAbonementsAllowAll = isAbonementsAllowAll;
		this.danceGroupDayOfWeekLiteViewModels = danceGroupDayOfWeekLiteViewModels;
		this.abonementLiteViewModels = abonementLiteViewModels;
		this.listIdOfConnectedAbonementsToDanceGroup = listIdOfConnectedAbonementsToDanceGroup;

        /*
        daysOfWeek = new ArrayList<Pair<Integer, String>>();

        MutablePair<Integer, String> mon = new MutablePair<>(1, "Понедельник");
        
        
        Pair<Integer, String> mon = new Pair<Integer, String>
        
        daysOfWeek.add(new Pair<Integer, String>(1, "Понедельник"));
        daysOfWeek.add((2, "Вторник"));
        daysOfWeek.add((3, "Среда"));
        daysOfWeek.add((4, "Четверг"));
        daysOfWeek.add((5, "Пятница"));
        daysOfWeek.add((6, "Суббота"));
        daysOfWeek.add((0, "Воскресенье"));
        */
	}
    
}
