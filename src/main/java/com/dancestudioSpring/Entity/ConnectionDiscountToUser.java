package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "connection_discount_to_user")
public class ConnectionDiscountToUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "discountid", referencedColumnName = "id")
	private Discount discount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;
    
	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}
	
}
