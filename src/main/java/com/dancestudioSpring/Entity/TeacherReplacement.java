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
@Table(name = "teacher_replacement")
public class TeacherReplacement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;

	@Column(name = "dateOfDay", nullable=true, columnDefinition="DATETIME")
    private Date dateOfDay;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupid", referencedColumnName = "id")
	private DanceGroup danceGroup;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "danceGroupDayOfWeekid", referencedColumnName = "id")
	private DanceGroupDayOfWeek danceGroupDayOfWeek;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherReplaceid", referencedColumnName = "id")
	private Teacher teacherReplace;
    
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

	public Date getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(Date dateOfDay) {
		this.dateOfDay = dateOfDay;
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

	public Teacher getTeacherReplace() {
		return teacherReplace;
	}

	public void setTeacherReplace(Teacher teacherReplace) {
		this.teacherReplace = teacherReplace;
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
	
	
	
}
