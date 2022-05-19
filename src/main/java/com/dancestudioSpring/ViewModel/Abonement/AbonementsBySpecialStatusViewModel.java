package com.dancestudioSpring.ViewModel.Abonement;

import java.util.ArrayList;

public class AbonementsBySpecialStatusViewModel {

    private ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRaz;
    private ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUsual;
    private ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUnlim;
    private ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRazTrial;
    
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModelsRaz() {
		return abonementLiteViewModelsRaz;
	}
	public void setAbonementLiteViewModelsRaz(ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRaz) {
		this.abonementLiteViewModelsRaz = abonementLiteViewModelsRaz;
	}
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModelsUsual() {
		return abonementLiteViewModelsUsual;
	}
	public void setAbonementLiteViewModelsUsual(ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUsual) {
		this.abonementLiteViewModelsUsual = abonementLiteViewModelsUsual;
	}
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModelsUnlim() {
		return abonementLiteViewModelsUnlim;
	}
	public void setAbonementLiteViewModelsUnlim(ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUnlim) {
		this.abonementLiteViewModelsUnlim = abonementLiteViewModelsUnlim;
	}
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModelsRazTrial() {
		return abonementLiteViewModelsRazTrial;
	}
	public void setAbonementLiteViewModelsRazTrial(ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRazTrial) {
		this.abonementLiteViewModelsRazTrial = abonementLiteViewModelsRazTrial;
	}
	public AbonementsBySpecialStatusViewModel(ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRaz,
			ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUsual,
			ArrayList<AbonementLiteViewModel> abonementLiteViewModelsUnlim,
			ArrayList<AbonementLiteViewModel> abonementLiteViewModelsRazTrial) {
		super();
		this.abonementLiteViewModelsRaz = abonementLiteViewModelsRaz;
		this.abonementLiteViewModelsUsual = abonementLiteViewModelsUsual;
		this.abonementLiteViewModelsUnlim = abonementLiteViewModelsUnlim;
		this.abonementLiteViewModelsRazTrial = abonementLiteViewModelsRazTrial;
	}
    
    
}
