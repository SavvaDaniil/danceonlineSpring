package com.dancestudioSpring.ViewModel.Visit;

import java.util.ArrayList;
import java.util.Date;

import com.dancestudioSpring.ViewModel.Abonement.AbonementsBySpecialStatusViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;

public class VisitPrepareViewModel {

    private String nameOfUser;
    private Date date_of_buy;
    private int id_of_dance_group;
    private String nameOfDanceGroup;
    private int id_of_dance_group_day_of_week;
    private AbonementsBySpecialStatusViewModel abonementsBySpecialStatusViewModel;
    private ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels;
    private VisitLiteViewModel visitLiteViewModel;
    private ArrayList<VisitLiteViewModel> visitLiteViewModels;
	public String getNameOfUser() {
		return nameOfUser;
	}
	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}
	public Date getDate_of_buy() {
		return date_of_buy;
	}
	public void setDate_of_buy(Date date_of_buy) {
		this.date_of_buy = date_of_buy;
	}
	public int getId_of_dance_group() {
		return id_of_dance_group;
	}
	public void setId_of_dance_group(int id_of_dance_group) {
		this.id_of_dance_group = id_of_dance_group;
	}
	public String getNameOfDanceGroup() {
		return nameOfDanceGroup;
	}
	public void setNameOfDanceGroup(String nameOfDanceGroup) {
		this.nameOfDanceGroup = nameOfDanceGroup;
	}
	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}
	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
	}
	public AbonementsBySpecialStatusViewModel getAbonementsBySpecialStatusViewModel() {
		return abonementsBySpecialStatusViewModel;
	}
	public void setAbonementsBySpecialStatusViewModel(
			AbonementsBySpecialStatusViewModel abonementsBySpecialStatusViewModel) {
		this.abonementsBySpecialStatusViewModel = abonementsBySpecialStatusViewModel;
	}
	public ArrayList<PurchaseAbonementLiteViewModel> getPurchaseAbonementLiteViewModels() {
		return purchaseAbonementLiteViewModels;
	}
	public void setPurchaseAbonementLiteViewModels(
			ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels) {
		this.purchaseAbonementLiteViewModels = purchaseAbonementLiteViewModels;
	}
	public VisitLiteViewModel getVisitLiteViewModel() {
		return visitLiteViewModel;
	}
	public void setVisitLiteViewModel(VisitLiteViewModel visitLiteViewModel) {
		this.visitLiteViewModel = visitLiteViewModel;
	}
	public ArrayList<VisitLiteViewModel> getVisitLiteViewModels() {
		return visitLiteViewModels;
	}
	public void setVisitLiteViewModels(ArrayList<VisitLiteViewModel> visitLiteViewModels) {
		this.visitLiteViewModels = visitLiteViewModels;
	}
	public VisitPrepareViewModel(String nameOfUser, Date date_of_buy, int id_of_dance_group, String nameOfDanceGroup,
			int id_of_dance_group_day_of_week, AbonementsBySpecialStatusViewModel abonementsBySpecialStatusViewModel,
			ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels,
			VisitLiteViewModel visitLiteViewModel, ArrayList<VisitLiteViewModel> visitLiteViewModels) {
		super();
		this.nameOfUser = nameOfUser;
		this.date_of_buy = date_of_buy;
		this.id_of_dance_group = id_of_dance_group;
		this.nameOfDanceGroup = nameOfDanceGroup;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.abonementsBySpecialStatusViewModel = abonementsBySpecialStatusViewModel;
		this.purchaseAbonementLiteViewModels = purchaseAbonementLiteViewModels;
		this.visitLiteViewModel = visitLiteViewModel;
		this.visitLiteViewModels = visitLiteViewModels;
	}
    
    
}
