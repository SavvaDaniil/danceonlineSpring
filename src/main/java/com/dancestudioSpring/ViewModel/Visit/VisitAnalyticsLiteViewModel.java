package com.dancestudioSpring.ViewModel.Visit;

import java.util.Date;

import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;

public class VisitAnalyticsLiteViewModel {

    private int id_of_visit;
    private Date date_of_buy;
    private Date date_of_add;

    private int id_of_dance_group;
    private String name_of_dance_group;

    private int id_of_user;
    private String secondname_of_user;
    private String firstname_of_user;

    private int visitsLeftOnVisit;

    private PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel;

	public int getId_of_visit() {
		return id_of_visit;
	}

	public void setId_of_visit(int id_of_visit) {
		this.id_of_visit = id_of_visit;
	}

	public Date getDate_of_buy() {
		return date_of_buy;
	}

	public void setDate_of_buy(Date date_of_buy) {
		this.date_of_buy = date_of_buy;
	}

	public Date getDate_of_add() {
		return date_of_add;
	}

	public void setDate_of_add(Date date_of_add) {
		this.date_of_add = date_of_add;
	}

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

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}



	public String getSecondname_of_user() {
		return secondname_of_user;
	}

	public void setSecondname_of_user(String secondname_of_user) {
		this.secondname_of_user = secondname_of_user;
	}

	public String getFirstname_of_user() {
		return firstname_of_user;
	}

	public void setFirstname_of_user(String firstname_of_user) {
		this.firstname_of_user = firstname_of_user;
	}

	public int getVisitsLeftOnVisit() {
		return visitsLeftOnVisit;
	}

	public void setVisitsLeftOnVisit(int visitsLeftOnVisit) {
		this.visitsLeftOnVisit = visitsLeftOnVisit;
	}

	public PurchaseAbonementLiteViewModel getPurchaseAbonementLiteViewModel() {
		return purchaseAbonementLiteViewModel;
	}

	public void setPurchaseAbonementLiteViewModel(PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel) {
		this.purchaseAbonementLiteViewModel = purchaseAbonementLiteViewModel;
	}

	public VisitAnalyticsLiteViewModel(int id_of_visit, Date date_of_buy, Date date_of_add, int id_of_dance_group,
			String name_of_dance_group, int id_of_user, String secondname_of_user, String firstname_of_user,
			int visitsLeftOnVisit, PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel) {
		super();
		this.id_of_visit = id_of_visit;
		this.date_of_buy = date_of_buy;
		this.date_of_add = date_of_add;
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.id_of_user = id_of_user;
		this.secondname_of_user = secondname_of_user;
		this.firstname_of_user = firstname_of_user;
		this.visitsLeftOnVisit = visitsLeftOnVisit;
		this.purchaseAbonementLiteViewModel = purchaseAbonementLiteViewModel;
	}




    
    
}
