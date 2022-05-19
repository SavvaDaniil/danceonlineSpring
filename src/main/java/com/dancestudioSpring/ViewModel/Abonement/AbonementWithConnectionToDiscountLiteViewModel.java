package com.dancestudioSpring.ViewModel.Abonement;

public class AbonementWithConnectionToDiscountLiteViewModel {

    private int id_of_abonement;
    private int id_of_discount;
    private String name_of_abonement;
    private int status;
    private int value;
    private int price_of_abonement;
    private int price_with_discount;
    
	public int getId_of_abonement() {
		return id_of_abonement;
	}
	public void setId_of_abonement(int id_of_abonement) {
		this.id_of_abonement = id_of_abonement;
	}
	public int getId_of_discount() {
		return id_of_discount;
	}
	public void setId_of_discount(int id_of_discount) {
		this.id_of_discount = id_of_discount;
	}
	public String getName_of_abonement() {
		return name_of_abonement;
	}
	public void setName_of_abonement(String name_of_abonement) {
		this.name_of_abonement = name_of_abonement;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getPrice_of_abonement() {
		return price_of_abonement;
	}
	public void setPrice_of_abonement(int price_of_abonement) {
		this.price_of_abonement = price_of_abonement;
	}
	public int getPrice_with_discount() {
		return price_with_discount;
	}
	public void setPrice_with_discount(int price_with_discount) {
		this.price_with_discount = price_with_discount;
	}
	public AbonementWithConnectionToDiscountLiteViewModel(int id_of_abonement, int id_of_discount,
			String name_of_abonement, int status, int value, int price_of_abonement, int price_with_discount) {
		super();
		this.id_of_abonement = id_of_abonement;
		this.id_of_discount = id_of_discount;
		this.name_of_abonement = name_of_abonement;
		this.status = status;
		this.value = value;
		this.price_of_abonement = price_of_abonement;
		this.price_with_discount = price_with_discount;
	}
    
    
}
