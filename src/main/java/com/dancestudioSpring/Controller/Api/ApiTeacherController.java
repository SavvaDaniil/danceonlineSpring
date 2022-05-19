package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.Teacher.*;
import com.dancestudioSpring.Facade.TeacherFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/teacher")
public class ApiTeacherController {

	@Autowired
	TeacherFacade teacherFacade;
	
	@PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(TeacherIdDTO teacherIdDTO)
    {
		return teacherFacade.getEdit(teacherIdDTO.getId_of_teacher());
    }

	@PostMapping("/add")
    public JsonAnswerStatus add(TeacherNewDTO teacherNewDTO)
    {
		if(!teacherNewDTO.isValid())return JsonAnswerStatus.noData();
		return teacherFacade.add(teacherNewDTO.getName());
    }

	@PostMapping("/update")
    public JsonAnswerStatus add(TeacherByColumnDTO teacherByColumnDTO)
    {
		if(!teacherByColumnDTO.isValid())return JsonAnswerStatus.noData();
		return teacherFacade.update(
				teacherByColumnDTO.getId_of_teacher(), teacherByColumnDTO.getName(), teacherByColumnDTO.getValue(), teacherByColumnDTO.getFile()
				);
    }

	@PostMapping("/delete")
    public JsonAnswerStatus delete(TeacherIdDTO teacherIdDTO)
    {
		if(!teacherIdDTO.isValid())return JsonAnswerStatus.noData();
		
		if(!teacherFacade.delete(teacherIdDTO.getId_of_teacher())) {
			return new JsonAnswerStatus("error");
		}
		return new JsonAnswerStatus("success");
    }
	
}
