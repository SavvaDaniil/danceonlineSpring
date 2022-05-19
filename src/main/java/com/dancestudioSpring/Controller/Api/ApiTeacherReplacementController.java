package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.TeacherReplacement.TeacherReplacementEditDTO;
import com.dancestudioSpring.DTO.TeacherReplacement.TeacherReplacementUpdateDTO;
import com.dancestudioSpring.Facade.TeacherReplacementFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/teacher_replacement")
public class ApiTeacherReplacementController {

	@Autowired
	TeacherReplacementFacade teacherReplacementFacade;


    @PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(TeacherReplacementEditDTO teacherReplacementEditDTO)
    {
    	if(!teacherReplacementEditDTO.isValid())return JsonAnswerStatus.noData();
    	
        return teacherReplacementFacade.getEdit(teacherReplacementEditDTO);
    }


    @PostMapping("/update")
    public JsonAnswerStatus update(TeacherReplacementUpdateDTO teacherReplacementUpdateDTO)
    {
    	if(!teacherReplacementUpdateDTO.isValid())return JsonAnswerStatus.noData();
    	
        return teacherReplacementFacade.update(teacherReplacementUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
	
}
