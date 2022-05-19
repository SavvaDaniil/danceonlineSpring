package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.TeacherRate.*;
import com.dancestudioSpring.Facade.TeacherRateFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/teacher_rate")
public class ApiTeacherRateController {

	@Autowired
	TeacherRateFacade teacherRateFacade;

	@PostMapping("/add")
	public JsonAnswerStatus add(TeacherRateNewDTO teacherRateNewDTO) {
		if(!teacherRateNewDTO.isValid())return JsonAnswerStatus.noData();
		return teacherRateFacade.add(teacherRateNewDTO.getId_of_teacher());
	}

	@PostMapping("/update")
	public JsonAnswerStatus update(TeacherRateDTO teacherRateDTO) {
		if(!teacherRateDTO.isValid())return JsonAnswerStatus.noData();
		return teacherRateFacade.update(teacherRateDTO.getId_of_teacher_rate(), teacherRateDTO.getName(), teacherRateDTO.getValue());
	}

	@PostMapping("/delete")
	public JsonAnswerStatus delete(TeacherRateIdDTO teacherRateIdDTO) {
		if(!teacherRateIdDTO.isValid())return JsonAnswerStatus.noData();
		return teacherRateFacade.deleteById(teacherRateIdDTO.getId_of_teacher_rate());
	}
	
}
