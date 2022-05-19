package com.dancestudioSpring.ViewModel.TeacherSalary;

import java.util.Date;

public class TeacherSalaryLiteViewModel {

    private int id;
    private Date dateOfUpdate;

    private int id_of_teacher;
    private String name_of_teacher;

    private int id_of_dance_group;
    private String name_of_dance_group;

    private int status;
    private int priceAuto;
    private int isChangedByAdmin;
    private int priceFact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfUpdate() {
		return dateOfUpdate;
	}
	public void setDateOfUpdate(Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}
	public int getId_of_teacher() {
		return id_of_teacher;
	}
	public void setId_of_teacher(int id_of_teacher) {
		this.id_of_teacher = id_of_teacher;
	}
	public String getName_of_teacher() {
		return name_of_teacher;
	}
	public void setName_of_teacher(String name_of_teacher) {
		this.name_of_teacher = name_of_teacher;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPriceAuto() {
		return priceAuto;
	}
	public void setPriceAuto(int priceAuto) {
		this.priceAuto = priceAuto;
	}
	public int getIsChangedByAdmin() {
		return isChangedByAdmin;
	}
	public void setIsChangedByAdmin(int isChangedByAdmin) {
		this.isChangedByAdmin = isChangedByAdmin;
	}
	public int getPriceFact() {
		return priceFact;
	}
	public void setPriceFact(int priceFact) {
		this.priceFact = priceFact;
	}
	public TeacherSalaryLiteViewModel(int id, Date dateOfUpdate, int id_of_teacher, String name_of_teacher,
			int id_of_dance_group, String name_of_dance_group, int status, int priceAuto, int isChangedByAdmin,
			int priceFact) {
		super();
		this.id = id;
		this.dateOfUpdate = dateOfUpdate;
		this.id_of_teacher = id_of_teacher;
		this.name_of_teacher = name_of_teacher;
		this.id_of_dance_group = id_of_dance_group;
		this.name_of_dance_group = name_of_dance_group;
		this.status = status;
		this.priceAuto = priceAuto;
		this.isChangedByAdmin = isChangedByAdmin;
		this.priceFact = priceFact;
	}
    
    
}
