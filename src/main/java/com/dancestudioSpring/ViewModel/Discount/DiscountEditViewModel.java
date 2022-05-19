package com.dancestudioSpring.ViewModel.Discount;

import java.util.ArrayList;

import com.dancestudioSpring.ViewModel.Abonement.AbonementWithConnectionToDiscountLiteViewModel;

public class DiscountEditViewModel {

    public int id;
    public String name;
    public ArrayList<AbonementWithConnectionToDiscountLiteViewModel> abonementWithConnectionToDiscountLiteViewModels;
    
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
	public ArrayList<AbonementWithConnectionToDiscountLiteViewModel> getAbonementWithConnectionToDiscountLiteViewModels() {
		return abonementWithConnectionToDiscountLiteViewModels;
	}
	public void setAbonementWithConnectionToDiscountLiteViewModels(
			ArrayList<AbonementWithConnectionToDiscountLiteViewModel> abonementWithConnectionToDiscountLiteViewModels) {
		this.abonementWithConnectionToDiscountLiteViewModels = abonementWithConnectionToDiscountLiteViewModels;
	}
	public DiscountEditViewModel(int id, String name,
			ArrayList<AbonementWithConnectionToDiscountLiteViewModel> abonementWithConnectionToDiscountLiteViewModels) {
		super();
		this.id = id;
		this.name = name;
		this.abonementWithConnectionToDiscountLiteViewModels = abonementWithConnectionToDiscountLiteViewModels;
	}
    
    
}
