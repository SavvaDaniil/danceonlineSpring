package com.dancestudioSpring.ViewModel.Visit;

import java.util.Date;

import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;

public class VisitLiteViewModel {

    private int id_of_visit;
    private Date date_of_buy;
    private Date date_of_add;

    private int id_of_dance_group;
    private String name_of_dance_group;

    private int id_of_dance_group_day_of_week;
    private String time_from;
    private String time_to;

    private int id_of_purchase_abonement;
    private String name_of_abonement;

    private int isAddByApp;
    private int isReservation;
    private int statusOfReservation;

    private int statusForDisableCanselByUser;

    private int id_of_user;
    private String secondname;
    private String firstnamename;

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

	public int getId_of_dance_group_day_of_week() {
		return id_of_dance_group_day_of_week;
	}

	public void setId_of_dance_group_day_of_week(int id_of_dance_group_day_of_week) {
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
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

	public int getId_of_purchase_abonement() {
		return id_of_purchase_abonement;
	}

	public void setId_of_purchase_abonement(int id_of_purchase_abonement) {
		this.id_of_purchase_abonement = id_of_purchase_abonement;
	}

	public String getName_of_abonement() {
		return name_of_abonement;
	}

	public void setName_of_abonement(String name_of_abonement) {
		this.name_of_abonement = name_of_abonement;
	}

	public int getIsAddByApp() {
		return isAddByApp;
	}

	public void setIsAddByApp(int isAddByApp) {
		this.isAddByApp = isAddByApp;
	}

	public int getIsReservation() {
		return isReservation;
	}

	public void setIsReservation(int isReservation) {
		this.isReservation = isReservation;
	}

	public int getStatusOfReservation() {
		return statusOfReservation;
	}

	public void setStatusOfReservation(int statusOfReservation) {
		this.statusOfReservation = statusOfReservation;
	}

	public int getStatusForDisableCanselByUser() {
		return statusForDisableCanselByUser;
	}

	public void setStatusForDisableCanselByUser(int statusForDisableCanselByUser) {
		this.statusForDisableCanselByUser = statusForDisableCanselByUser;
	}

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}


	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getFirstnamename() {
		return firstnamename;
	}

	public void setFirstnamename(String firstnamename) {
		this.firstnamename = firstnamename;
	}

	public PurchaseAbonementLiteViewModel getPurchaseAbonementLiteViewModel() {
		return purchaseAbonementLiteViewModel;
	}

	public void setPurchaseAbonementLiteViewModel(PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel) {
		this.purchaseAbonementLiteViewModel = purchaseAbonementLiteViewModel;
	}

	public VisitLiteViewModel(int id_of_visit, Date date_of_buy, Date date_of_add, int id_of_dance_group,
			String name_of_dance_group, int id_of_dance_group_day_of_week, String time_from, String time_to,
			int id_of_purchase_abonement, String name_of_abonement, int isAddByApp, int isReservation,
			int statusOfReservation, int statusForDisableCanselByUser) {
		super();
		this.id_of_visit = id_of_visit;
		this.date_of_buy = date_of_buy;
		this.date_of_add = date_of_add;
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.time_from = time_from;
		this.time_to = time_to;
		this.id_of_purchase_abonement = id_of_purchase_abonement;
		this.name_of_abonement = name_of_abonement;
		this.isAddByApp = isAddByApp;
		this.isReservation = isReservation;
		this.statusOfReservation = statusOfReservation;
		this.statusForDisableCanselByUser = statusForDisableCanselByUser;
	}

	public VisitLiteViewModel(int id_of_visit, Date date_of_buy, Date date_of_add, int id_of_dance_group,
			String name_of_dance_group, int id_of_dance_group_day_of_week, String time_from, String time_to,
			int id_of_purchase_abonement, String name_of_abonement, int isAddByApp, int isReservation,
			int statusOfReservation, int statusForDisableCanselByUser, int id_of_user, String secondname,
			String firstnamename) {
		super();
		this.id_of_visit = id_of_visit;
		this.date_of_buy = date_of_buy;
		this.date_of_add = date_of_add;
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.id_of_dance_group_day_of_week = id_of_dance_group_day_of_week;
		this.time_from = time_from;
		this.time_to = time_to;
		this.id_of_purchase_abonement = id_of_purchase_abonement;
		this.name_of_abonement = name_of_abonement;
		this.isAddByApp = isAddByApp;
		this.isReservation = isReservation;
		this.statusOfReservation = statusOfReservation;
		this.statusForDisableCanselByUser = statusForDisableCanselByUser;
		this.id_of_user = id_of_user;
		this.secondname = secondname;
		this.firstnamename = firstnamename;
	}


    
    
}
