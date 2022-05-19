package com.dancestudioSpring.ViewModel.Abonement;

import com.dancestudioSpring.ViewModel.User.UserLiteViewModel;

public class AbonementForBuyingViewModel {

    private AbonementLiteViewModel abonementLiteViewModel;
    private UserLiteViewModel userLiteViewModel;
    
	public AbonementLiteViewModel getAbonementLiteViewModel() {
		return abonementLiteViewModel;
	}
	public void setAbonementLiteViewModel(AbonementLiteViewModel abonementLiteViewModel) {
		this.abonementLiteViewModel = abonementLiteViewModel;
	}
	public UserLiteViewModel getUserLiteViewModel() {
		return userLiteViewModel;
	}
	public void setUserLiteViewModel(UserLiteViewModel userLiteViewModel) {
		this.userLiteViewModel = userLiteViewModel;
	}
	
	public AbonementForBuyingViewModel(AbonementLiteViewModel abonementLiteViewModel,
			UserLiteViewModel userLiteViewModel) {
		super();
		this.abonementLiteViewModel = abonementLiteViewModel;
		this.userLiteViewModel = userLiteViewModel;
	}
    
    
}
