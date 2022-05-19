package com.dancestudioSpring.ViewModel.PurchaseAbonement;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseAbonementStatistikLiteViewModel {

    public Date date_of_buy;
    public int id_of_dance_group;
    public String nameOfDanceGroup;

    public ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels;
    public int summAll;
    
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
	public ArrayList<PurchaseAbonementLiteViewModel> getPurchaseAbonementLiteViewModels() {
		return purchaseAbonementLiteViewModels;
	}
	public void setPurchaseAbonementLiteViewModels(
			ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels) {
		this.purchaseAbonementLiteViewModels = purchaseAbonementLiteViewModels;
	}
	public int getSummAll() {
		return summAll;
	}
	public void setSummAll(int summAll) {
		this.summAll = summAll;
	}
	
	public PurchaseAbonementStatistikLiteViewModel(Date date_of_buy, int id_of_dance_group, String nameOfDanceGroup,
			ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels, int summAll) {
		super();
		this.date_of_buy = date_of_buy;
		this.id_of_dance_group = id_of_dance_group;
		this.nameOfDanceGroup = nameOfDanceGroup;
		this.purchaseAbonementLiteViewModels = purchaseAbonementLiteViewModels;
		this.summAll = summAll;
	}
    
    
}
