package com.dancestudioSpring.DTO.Teacher;

import com.dancestudioSpring.Interface.ValidatedObject;
import org.springframework.web.multipart.MultipartFile;

public class TeacherByColumnDTO implements ValidatedObject  {
	
    private int id_of_teacher;
    private String name;
    private String value;
    private MultipartFile file;


	public int getId_of_teacher() {
		return id_of_teacher;
	}
	public void setId_of_teacher(int id_of_teacher) {
		this.id_of_teacher = id_of_teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public boolean isValid() {
		return this.id_of_teacher != 0 && this.name != null && this.value != null;
	}
	
}
