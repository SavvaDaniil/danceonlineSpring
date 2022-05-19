package com.dancestudioSpring.Facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.TeacherSalary.TeacherSalaryUpdatePriceDTO;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherRate;
import com.dancestudioSpring.Entity.TeacherReplacement;
import com.dancestudioSpring.Entity.TeacherSalary;
import com.dancestudioSpring.Entity.Visit;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.TeacherRateService;
import com.dancestudioSpring.Service.TeacherReplacementService;
import com.dancestudioSpring.Service.TeacherSalaryService;
import com.dancestudioSpring.Service.VisitService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@Component
public class TeacherSalaryFacade {

	@Autowired
	TeacherSalaryService teacherSalaryService;
	
	
	public TeacherSalary add(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Teacher teacher, int price) {
		TeacherSalary teacherSalary = new TeacherSalary();

		Date dateOfAdd = new Date();
		teacherSalary.setDateOfAdd(dateOfAdd);
		teacherSalary.setDateOfUpdate(dateOfAdd);
		
		teacherSalary.setDateOfDay(dateOfDay);
		teacherSalary.setDanceGroup(danceGroup);
		teacherSalary.setDanceGroupDayOfWeek(danceGroupDayOfWeek);
		teacherSalary.setTeacher(teacher);
		teacherSalary.setPriceAuto(price);
		teacherSalary.setPriceFact(price);
		teacherSalary.setStatus(1);
		teacherSalary = teacherSalaryService.add(teacherSalary);
		
		return teacherSalary;
	}
	
	
	
	

    public TeacherSalary updateWithCheckReplacement(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        if (danceGroup.getTeacher() == null)
        {
            DanceGroupService danceGroupService = new DanceGroupService();
            danceGroup = danceGroupService.findById(danceGroup.getId());
            if (danceGroup.getTeacher() == null)
            {
                System.out.println("Ошибка: TeacherSalaryFacade danceGroup.teacher == null");
                return null;
            }
        }
        Teacher teacher = danceGroup.getTeacher();
        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        TeacherReplacement teacherReplacement = teacherReplacementService.find(dateOfDay, danceGroup, danceGroupDayOfWeek);
        if(teacherReplacement != null)
        {
            if(teacherReplacement.getTeacherReplace() != null)
            {
                teacher = teacherReplacement.getTeacherReplace();
            }
        }

        return update(dateOfDay, danceGroup, danceGroupDayOfWeek, teacher);
    }
    
    ...


    public JsonAnswerStatus updatePriceFact(TeacherSalaryUpdatePriceDTO teacherSalaryUpdatePriceDTO)
    {
        TeacherSalaryService teacherSalaryService = new TeacherSalaryService();
        TeacherSalary teacherSalary = teacherSalaryService.findById(teacherSalaryUpdatePriceDTO.getId_of_teacher_salary());
        if (teacherSalary == null) return new JsonAnswerStatus("error", "not_found");

        if (teacherSalaryUpdatePriceDTO.getStatus() == 1)
        {
        	teacherSalary = this.updateFact(teacherSalary, teacherSalaryUpdatePriceDTO.getPriceFact());
            return new JsonAnswerStatus("success", null);
        } else if(teacherSalaryUpdatePriceDTO.getStatus() == 0)
        {
            if(!this.setIsChangeByAdmin(teacherSalary, 0))return new JsonAnswerStatus("error", "unknown");
            return new JsonAnswerStatus("success", null); 
        }

        return new JsonAnswerStatus("error", "unknown");
    }
    
    

    public TeacherSalary updateAuto(TeacherSalary teacherSalary, int price)
    {
        teacherSalary.setPriceAuto(price);
        teacherSalary.setDateOfUpdate(new Date());

        if(teacherSalary.getIsChangedByAdmin() == 0) teacherSalary.setPriceFact(price);

        if(!teacherSalaryService.update(teacherSalary))return null;

        return teacherSalary;
    }

    public TeacherSalary updateFact(TeacherSalary teacherSalary, int priceFact)
    {
        teacherSalary.setPriceFact(priceFact);
        teacherSalary.setIsChangedByAdmin(1);
        teacherSalary.setDateOfUpdate(new Date());

        if(!teacherSalaryService.update(teacherSalary))return null;
        
        return teacherSalary;
    }

    public boolean setIsChangeByAdmin(TeacherSalary teacherSalary, int setIsChangeByAdmin)
    {
        if (setIsChangeByAdmin != 0 && setIsChangeByAdmin != 1) return false;
        if(setIsChangeByAdmin == 1)
        {
            teacherSalary.setIsChangedByAdmin(1);
        } else
        {
            teacherSalary.setPriceFact(teacherSalary.getPriceAuto());
            teacherSalary.setIsChangedByAdmin(0);
        }
        teacherSalary.setDateOfUpdate(new Date());

        if(!teacherSalaryService.update(teacherSalary))return false;
        
        return true;
    }
    
    
}
