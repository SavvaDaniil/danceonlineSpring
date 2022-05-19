package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;


	@Column(name="username", nullable=true, columnDefinition="varchar(256)")
    private String username;

	@Column(name="password", nullable=true, columnDefinition="varchar(256)")
    private String password;

	@Column(name="auth_key", nullable=true, columnDefinition="varchar(256)")
    private String authKey;

	@Column(name="access_token", nullable=true, columnDefinition="varchar(256)")
    private String accessToken;

	@Column(name="active", nullable=false, columnDefinition="int(1) default 0")
    private int active;

	//@Column(name="fio", nullable=true, columnDefinition="varchar(256)")
    //private String fio;
	
	@Column(name="secondname", nullable=true, columnDefinition="varchar(256)")
    private String secondname;

	@Column(name="firstname", nullable=true, columnDefinition="varchar(256)")
    private String firstname;


	@Column(name="phone", nullable=true, columnDefinition="varchar(256)")
    private String phone;

	@Column(name="sex", nullable=false, columnDefinition="int(1) default 0")
    private int sex;

	@Column(name="parentFio", nullable=true, columnDefinition="varchar(256)")
    private String parentFio;

	@Column(name="parentPhone", nullable=true, columnDefinition="varchar(256)")
    private String parentPhone;

	@Column(name="comment", nullable=true, columnDefinition="TEXT")
    private String comment;

	@Column(name="dateOfBirthday", nullable=true, columnDefinition="DATETIME")
    private Date dateOfBirthday;

	@Column(name="statusOfTeacher", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfTeacher;

	@Column(name="statusOfAdmin", nullable=false, columnDefinition="int(1) default 0")
    private int statusOfAdmin;

	@Column(name="checkQr", nullable=true, columnDefinition="varchar(256)")
    private String checkQr;

	@Column(name="authAdmin0App1", nullable=false, columnDefinition="int(1) default 0")
    private int authAdmin0App1;
	

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
	//@Column(name = "dateOfAdd", nullable=true)
    private Date dateOfAdd;
	
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
    private Date dateOfUpdate;
	
	@Column(name = "dateOfLastVisit", nullable=true, columnDefinition="DATETIME")
    private Date dateOfLastVisit;

	@Column(name="forget_count", nullable=false, columnDefinition="int(1) default 0")
    private int forgetCount;

	@Column(name="forget_code", nullable=true, columnDefinition="varchar(6)")
    private String forgetCode;

	@Column(name = "date_of_last_try", nullable=true, columnDefinition="DATETIME")
    private Date forgetDateOfLastTry;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getParentFio() {
		return parentFio;
	}

	public void setParentFio(String parentFio) {
		this.parentFio = parentFio;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public int getStatusOfTeacher() {
		return statusOfTeacher;
	}

	public void setStatusOfTeacher(int statusOfTeacher) {
		this.statusOfTeacher = statusOfTeacher;
	}

	public int getStatusOfAdmin() {
		return statusOfAdmin;
	}

	public void setStatusOfAdmin(int statusOfAdmin) {
		this.statusOfAdmin = statusOfAdmin;
	}

	public String getCheckQr() {
		return checkQr;
	}

	public void setCheckQr(String checkQr) {
		this.checkQr = checkQr;
	}

	public int getAuthAdmin0App1() {
		return authAdmin0App1;
	}

	public void setAuthAdmin0App1(int authAdmin0App1) {
		this.authAdmin0App1 = authAdmin0App1;
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

	public Date getDateOfLastVisit() {
		return dateOfLastVisit;
	}

	public void setDateOfLastVisit(Date dateOfLastVisit) {
		this.dateOfLastVisit = dateOfLastVisit;
	}

	public int getForgetCount() {
		return forgetCount;
	}

	public void setForgetCount(int forgetCount) {
		this.forgetCount = forgetCount;
	}

	public String getForgetCode() {
		return forgetCode;
	}

	public void setForgetCode(String forgetCode) {
		this.forgetCode = forgetCode;
	}

	public Date getForgetDateOfLastTry() {
		return forgetDateOfLastTry;
	}

	public void setForgetDateOfLastTry(Date forgetDateOfLastTry) {
		this.forgetDateOfLastTry = forgetDateOfLastTry;
	}

	public User() {
		super();
	}

	public User(int id, String username, String password, String authKey, String accessToken, int active,
			String secondname, String firstname, String phone, int sex, String parentFio, String parentPhone,
			String comment, Date dateOfBirthday, int statusOfTeacher, int statusOfAdmin, String checkQr,
			int authAdmin0App1, Date dateOfAdd, Date dateOfUpdate, Date dateOfLastVisit, int forgetCount,
			String forgetCode, Date forgetDateOfLastTry) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authKey = authKey;
		this.accessToken = accessToken;
		this.active = active;
		this.secondname = secondname;
		this.firstname = firstname;
		this.phone = phone;
		this.sex = sex;
		this.parentFio = parentFio;
		this.parentPhone = parentPhone;
		this.comment = comment;
		this.dateOfBirthday = dateOfBirthday;
		this.statusOfTeacher = statusOfTeacher;
		this.statusOfAdmin = statusOfAdmin;
		this.checkQr = checkQr;
		this.authAdmin0App1 = authAdmin0App1;
		this.dateOfAdd = dateOfAdd;
		this.dateOfUpdate = dateOfUpdate;
		this.dateOfLastVisit = dateOfLastVisit;
		this.forgetCount = forgetCount;
		this.forgetCode = forgetCode;
		this.forgetDateOfLastTry = forgetDateOfLastTry;
	}

	
	
	
	
}
