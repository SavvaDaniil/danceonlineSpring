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
@Table(name = "abonement_dynamic_date_must_be_used_to")
public class AbonementDynamicDateMustBeUsedTo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "abonementid", referencedColumnName = "id")
	private Abonement abonement;

	@Column(name="status", nullable=false, columnDefinition="int(1) default 0")
	private int status;

    
	@Column(name = "dateFrom", nullable=true, columnDefinition="DATETIME")
    private Date dateFrom;
    
	@Column(name = "dateTo", nullable=true, columnDefinition="DATETIME")
    private Date dateTo;
    
	@Column(name = "dateUsedTo", nullable=true, columnDefinition="DATETIME")
    private Date dateUsedTo;
    
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

	public Abonement getAbonement() {
		return abonement;
	}

	public void setAbonement(Abonement abonement) {
		this.abonement = abonement;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateUsedTo() {
		return dateUsedTo;
	}

	public void setDateUsedTo(Date dateUsedTo) {
		this.dateUsedTo = dateUsedTo;
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

	public AbonementDynamicDateMustBeUsedTo() {
		super();
	}

	public AbonementDynamicDateMustBeUsedTo(int id, Abonement abonement, int status, Date dateFrom, Date dateTo,
			Date dateUsedTo, Date dateOfAdd, Date dateOfUpdate) {
		super();
		this.id = id;
		this.abonement = abonement;
		this.status = status;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.dateUsedTo = dateUsedTo;
		this.dateOfAdd = dateOfAdd;
		this.dateOfUpdate = dateOfUpdate;
	}
	
	
}
