package com.dancestudioSpring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	//@GenericGenerator(name = "native", strategy = "native")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	
	@Column(name="username", nullable=true, columnDefinition="varchar(256)")
	private String username;
	
	@Column(name="password", nullable=true, columnDefinition="varchar(256)")
	private String password;
	
	@Column(name="authKey", nullable=true, columnDefinition="varchar(256)")
	private String authKey;
	
	@Column(name="accessToken", nullable=true, columnDefinition="varchar(256)")
	private String accessToken;

	@Column(name="position", nullable=true, columnDefinition="varchar(256)")
	private String position;
	
	@Column(name="active", nullable=false, columnDefinition="int(1) default 0")
	private int active;
	
	@Column(name="level", nullable=false, columnDefinition="int(1) default 0")
	private int level;

	@Column(name = "dateOfAdd", nullable=true, columnDefinition="DATETIME")
	private Date dateOfAdd;
	
	@Column(name = "dateOfUpdate", nullable=true, columnDefinition="DATETIME")
	private Date dateOfUpdate;


	
	
	@Column(name="panelAdmins", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelAdmins;

	@Column(name="panelLessons", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelLessons;

	@Column(name="panelUsers", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelUsers;

	@Column(name="panelDanceGroups", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelDanceGroups;

	@Column(name="panelTeachers", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelTeachers;

	@Column(name="panelAbonements", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelAbonements;

	@Column(name="panelDiscounts", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelDiscounts;

	@Column(name="panelBranches", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelBranches;

	@Column(name="panelCansels", nullable=false, columnDefinition="int(1) default 0")
	@ColumnDefault("0")
    public int panelCansels;

	
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


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
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

	

	
	
	


	public int getPanelAdmins() {
		return panelAdmins;
	}


	public void setPanelAdmins(int panelAdmins) {
		this.panelAdmins = panelAdmins;
	}


	public int getPanelLessons() {
		return panelLessons;
	}


	public void setPanelLessons(int panelLessons) {
		this.panelLessons = panelLessons;
	}


	public int getPanelUsers() {
		return panelUsers;
	}


	public void setPanelUsers(int panelUsers) {
		this.panelUsers = panelUsers;
	}


	public int getPanelDanceGroups() {
		return panelDanceGroups;
	}


	public void setPanelDanceGroups(int panelDanceGroups) {
		this.panelDanceGroups = panelDanceGroups;
	}


	public int getPanelTeachers() {
		return panelTeachers;
	}


	public void setPanelTeachers(int panelTeachers) {
		this.panelTeachers = panelTeachers;
	}


	public int getPanelAbonements() {
		return panelAbonements;
	}


	public void setPanelAbonements(int panelAbonements) {
		this.panelAbonements = panelAbonements;
	}


	public int getPanelDiscounts() {
		return panelDiscounts;
	}


	public void setPanelDiscounts(int panelDiscounts) {
		this.panelDiscounts = panelDiscounts;
	}


	public int getPanelBranches() {
		return panelBranches;
	}


	public void setPanelBranches(int panelBranches) {
		this.panelBranches = panelBranches;
	}


	public int getPanelCansels() {
		return panelCansels;
	}


	public void setPanelCansels(int panelCansels) {
		this.panelCansels = panelCansels;
	}


	public Admin() {
		super();
	}

	public Admin(String username, String password, String authKey, String accessToken, int active, String position,
			int level) {
		super();
		this.username = username;
		this.password = password;
		this.authKey = authKey;
		this.accessToken = accessToken;
		this.active = active;
		this.position = position;
		this.level = level;
	}


	
	
	
	
	

	
}
