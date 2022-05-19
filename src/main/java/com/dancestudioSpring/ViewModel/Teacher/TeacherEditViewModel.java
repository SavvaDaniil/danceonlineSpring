package com.dancestudioSpring.ViewModel.Teacher;

import java.util.ArrayList;

import com.dancestudioSpring.ViewModel.TeacherRate.TeacherRateLiteViewModel;

public class TeacherEditViewModel {

    private int id;
    private String name;
    private String posterSrc;
    private int stavka;
    private int stavka_plus;
    private ArrayList<TeacherRateLiteViewModel> teacherRateLiteViewModels;
    private int min_students;
    private int raz;
    private int usual;
    private int unlim;
    private int procent;
    private int plus_after_students;
    private int plus_after_summa;
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
	public String getPosterSrc() {
		return posterSrc;
	}
	public void setPosterSrc(String posterSrc) {
		this.posterSrc = posterSrc;
	}
	public int getStavka() {
		return stavka;
	}
	public void setStavka(int stavka) {
		this.stavka = stavka;
	}
	public int getStavka_plus() {
		return stavka_plus;
	}
	public void setStavka_plus(int stavka_plus) {
		this.stavka_plus = stavka_plus;
	}
	public ArrayList<TeacherRateLiteViewModel> getTeacherRateLiteViewModels() {
		return teacherRateLiteViewModels;
	}
	public void setTeacherRateLiteViewModels(ArrayList<TeacherRateLiteViewModel> teacherRateLiteViewModels) {
		this.teacherRateLiteViewModels = teacherRateLiteViewModels;
	}
	public int getMin_students() {
		return min_students;
	}
	public void setMin_students(int min_students) {
		this.min_students = min_students;
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
	public int getProcent() {
		return procent;
	}
	public void setProcent(int procent) {
		this.procent = procent;
	}
	public int getPlus_after_students() {
		return plus_after_students;
	}
	public void setPlus_after_students(int plus_after_students) {
		this.plus_after_students = plus_after_students;
	}
	public int getPlus_after_summa() {
		return plus_after_summa;
	}
	public void setPlus_after_summa(int plus_after_summa) {
		this.plus_after_summa = plus_after_summa;
	}
	public TeacherEditViewModel(int id, String name, String posterSrc, int stavka, int stavka_plus,
			ArrayList<TeacherRateLiteViewModel> teacherRateLiteViewModels, int min_students, int raz, int usual,
			int unlim, int procent, int plus_after_students, int plus_after_summa) {
		super();
		this.id = id;
		this.name = name;
		this.posterSrc = posterSrc;
		this.stavka = stavka;
		this.stavka_plus = stavka_plus;
		this.teacherRateLiteViewModels = teacherRateLiteViewModels;
		this.min_students = min_students;
		this.raz = raz;
		this.usual = usual;
		this.unlim = unlim;
		this.procent = procent;
		this.plus_after_students = plus_after_students;
		this.plus_after_summa = plus_after_summa;
	}
    
    
}
