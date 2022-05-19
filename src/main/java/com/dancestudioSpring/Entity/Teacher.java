package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	
	@Column(name="name", nullable=true, columnDefinition="varchar(256)")
	private String name;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
	private Date dateOfAdd;
	
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
	private Date dateOfUpdate;

	@Column(name="stavka", nullable=false, columnDefinition="int(1) default 0")
    private int stavka;

	@Column(name="min_students", nullable=false, columnDefinition="int(11) default 0")
    private int minStudents;

	@Column(name="raz", nullable=false, columnDefinition="int(11) default 0")
    private int raz;

	@Column(name="usual", nullable=false, columnDefinition="int(11) default 0")
    private int usual;

	@Column(name="unlim", nullable=false, columnDefinition="int(11) default 0")
    private int unlim;

	@Column(name="stavka_plus", nullable=false, columnDefinition="int(1) default 0")
    private int stavkaPlus;

	@Column(name="plus_after_students", nullable=false, columnDefinition="int(5) default 0")
    private int plusAfterStudents;

	@Column(name="plus_after_summa", nullable=false, columnDefinition="int(11) default 0")
    private int plusAfterSumma;

	@Column(name="procent", nullable=false, columnDefinition="int(3) default 0")
    private int procent;

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

	public int getStavka() {
		return stavka;
	}

	public void setStavka(int stavka) {
		this.stavka = stavka;
	}

	public int getMinStudents() {
		return minStudents;
	}

	public void setMinStudents(int minStudents) {
		this.minStudents = minStudents;
	}

	public int getRaz() {
		return raz;
	}

	public void setRaz(int raz) {
		this.raz = raz;
	}

	public int getUsual() {
		return usual;
	}

	public void setUsual(int usual) {
		this.usual = usual;
	}

	public int getUnlim() {
		return unlim;
	}

	public void setUnlim(int unlim) {
		this.unlim = unlim;
	}

	public int getStavkaPlus() {
		return stavkaPlus;
	}

	public void setStavkaPlus(int stavkaPlus) {
		this.stavkaPlus = stavkaPlus;
	}

	public int getPlusAfterStudents() {
		return plusAfterStudents;
	}

	public void setPlusAfterStudents(int plusAfterStudents) {
		this.plusAfterStudents = plusAfterStudents;
	}

	public int getPlusAfterSumma() {
		return plusAfterSumma;
	}

	public void setPlusAfterSumma(int plusAfterSumma) {
		this.plusAfterSumma = plusAfterSumma;
	}

	public int getProcent() {
		return procent;
	}

	public void setProcent(int procent) {
		this.procent = procent;
	}

	public Teacher() {
		super();
	}

	public Teacher(int id, String name, Date dateOfAdd, Date dateOfUpdate, int stavka, int minStudents, int raz,
			int usual, int unlim, int stavkaPlus, int plusAfterStudents, int plusAfterSumma, int procent) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfAdd = dateOfAdd;
		this.dateOfUpdate = dateOfUpdate;
		this.stavka = stavka;
		this.minStudents = minStudents;
		this.raz = raz;
		this.usual = usual;
		this.unlim = unlim;
		this.stavkaPlus = stavkaPlus;
		this.plusAfterStudents = plusAfterStudents;
		this.plusAfterSumma = plusAfterSumma;
		this.procent = procent;
	}
	
	
}
