package com.dancestudioSpring.DTO.ConnectionDiscountToUser;

import com.dancestudioSpring.Interface.ValidatedObject;

public class ConnectionDiscountToUserUpdateDTO implements ValidatedObject {

    private int id_of_discount;

    private int id_of_user;

    private int status;

	public int getId_of_discount() {
		return id_of_discount;
	}

	public void setId_of_discount(int id_of_discount) {
		this.id_of_discount = id_of_discount;
	}

	public int getId_of_user() {
		return id_of_user;
	}

	public void setId_of_user(int id_of_user) {
		this.id_of_user = id_of_user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.id_of_discount != 0 && this.id_of_user != 0;
	}
    
    
}
