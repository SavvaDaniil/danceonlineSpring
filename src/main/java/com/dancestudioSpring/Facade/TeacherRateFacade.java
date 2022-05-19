package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherRate;
import com.dancestudioSpring.Service.TeacherRateService;
import com.dancestudioSpring.Service.TeacherService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.TeacherRate.TeacherRateLiteViewModel;

@Component
public class TeacherRateFacade {

	@Autowired
	TeacherRateService teacherRateService;
	
	
    public ArrayList<TeacherRateLiteViewModel> listAllLiteByIdOfTeacher(int id_of_teacher)
    {
        List<TeacherRate> teacherRates = teacherRateService.listAllByIdOfTeacher(id_of_teacher);
        ArrayList<TeacherRateLiteViewModel> teacherRateLiteViewModels = new ArrayList<TeacherRateLiteViewModel>();
        for (TeacherRate teacherRate : teacherRates)
        {
            teacherRateLiteViewModels.add(
                new TeacherRateLiteViewModel(
                    teacherRate.getId(),
                    teacherRate.getSpecial(),
                    teacherRate.getStudents(),
                    teacherRate.getHowMuchMoney()
                )    
            );
        }
        return teacherRateLiteViewModels;
    }
    

    public JsonAnswerStatus add(int id_of_teacher)
    {
    	TeacherService teacherService = new TeacherService();
        Teacher teacher = teacherService.findById(id_of_teacher);
        if (teacher == null) return new JsonAnswerStatus("error", "not_found_teacher");

        TeacherRate teacherRate = new TeacherRate();
        teacherRate = teacherRateService.add(teacherRate);
        if (teacherRate == null)return new JsonAnswerStatus("error", "unknown");
        return new JsonAnswerStatus("success", null);
    }

    public JsonAnswerStatus update(int id_of_teacher_rate, String name, int value)
    {
        TeacherRate teacherRate = teacherRateService.findById(id_of_teacher_rate);
        if (teacherRate == null) return new JsonAnswerStatus("error", "not_found_teacher_rate");

        if (value < 0) value = 0;
        if (name == "students")
        {
            teacherRate.setStudents(value);
        } else if (name == "how_much_money")
        {
            teacherRate.setHowMuchMoney(value);
        }
        
        return (
            teacherRateService.update(teacherRate)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown")
        );
    }

    public JsonAnswerStatus deleteById(int id_of_teacher_rate)
    {
        TeacherRate teacherRate = teacherRateService.findById(id_of_teacher_rate);
        if (teacherRate == null) return new JsonAnswerStatus("error", "not_found_teacher_rate");

        if (!teacherRateService.delete(teacherRate))
        {
            return new JsonAnswerStatus("error", "unknown");
        }
        return new JsonAnswerStatus("success", null);
    }
}
