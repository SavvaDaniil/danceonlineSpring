package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.TeacherSalary.TeacherSalaryUpdatePriceDTO;
import com.dancestudioSpring.Facade.TeacherSalaryFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/teacher_salary")
public class ApiTeacherSalaryController {

	@Autowired
	TeacherSalaryFacade teacherSalaryFacade;
	

	@PostMapping("/update_price_fact")
    public JsonAnswerStatus updatePriceFact(TeacherSalaryUpdatePriceDTO teacherSalaryUpdatePriceDTO)
    {
    	if(!teacherSalaryUpdatePriceDTO.isValid())return JsonAnswerStatus.noData();
    	
        return teacherSalaryFacade.updatePriceFact(teacherSalaryUpdatePriceDTO);
    }
	
}
