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
@Table(name = "teacher_salary")
public class TeacherSalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@Column(name = "dateOfDay", nullable=true, columnDefinition="DATETIME")
    private Date dateOfDay;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
    private Date dateOfAdd;
    
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
    private Date dateOfUpdate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupid", referencedColumnName = "id")
	private DanceGroup danceGroup;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupDayOfWeekid", referencedColumnName = "id")
	private DanceGroupDayOfWeek danceGroupDayOfWeek;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherid", referencedColumnName = "id")
	private Teacher teacher;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherReplacementid", referencedColumnName = "id")
	private Teacher teacherReplacement;

	@Column(name="status", nullable=false, columnDefinition="int(1) default 0")
    private int status;

	@Column(name="price_auto", nullable=false, columnDefinition="int(11) default 0")
    private int priceAuto;

	@Column(name="is_changed_by_admin", nullable=false, columnDefinition="int(1) default 0")
    private int isChangedByAdmin;

	@Column(name="price_fact", nullable=false, columnDefinition="int(1) default 0")
    private int priceFact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(Date dateOfDay) {
		this.dateOfDay = dateOfDay;
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

	public DanceGroup getDanceGroup() {
		return danceGroup;
	}

	public void setDanceGroup(DanceGroup danceGroup) {
		this.danceGroup = danceGroup;
	}

	public DanceGroupDayOfWeek getDanceGroupDayOfWeek() {
		return danceGroupDayOfWeek;
	}

	public void setDanceGroupDayOfWeek(DanceGroupDayOfWeek danceGroupDayOfWeek) {
		this.danceGroupDayOfWeek = danceGroupDayOfWeek;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacherReplacement() {
		return teacherReplacement;
	}

	public void setTeacherReplacement(Teacher teacherReplacement) {
		this.teacherReplacement = teacherReplacement;
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
	
	
	
	
}
