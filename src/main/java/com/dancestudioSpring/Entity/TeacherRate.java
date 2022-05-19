package com.dancestudioSpring.Entity;

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
@Table(name = "teacher_rate")
public class TeacherRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacherid", referencedColumnName = "id")
	private Teacher teacher;
	
	@Column(name="special", nullable=true, columnDefinition="varchar(10)")
    private String special;

	@Column(name="students", nullable=false, columnDefinition="int(11) default 0")
    private int students;

	@Column(name="how_much_money", nullable=false, columnDefinition="int(11) default 0")
	private int howMuchMoney;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

	public int getHowMuchMoney() {
		return howMuchMoney;
	}

	public void setHowMuchMoney(int howMuchMoney) {
		this.howMuchMoney = howMuchMoney;
	}

	
	
	public TeacherRate() {
		super();
	}

	public TeacherRate(int id, Teacher teacher, String special, int students, int howMuchMoney) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.special = special;
		this.students = students;
		this.howMuchMoney = howMuchMoney;
	}
	
	
}
