package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	
	@Column(name="name", nullable=true, columnDefinition="varchar(256)")
	private String name;
	
	@Column(name="description", nullable=true, columnDefinition="varchar(256)")
	private String description;
	
	@Column(name="coordinates", nullable=true, columnDefinition="varchar(256)")
	private String coordinates;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
	private Date dateOfAdd;
	
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
	private Date dateOfUpdate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Date getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

	public Date getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate(Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}

	public Branch() {
		super();
	}

	public Branch(int id, String name, String description, String coordinates, Date dateOfAdd, Date dateOfUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coordinates = coordinates;
		this.dateOfAdd = dateOfAdd;
		this.dateOfUpdate = dateOfUpdate;
	}
	
	
}
