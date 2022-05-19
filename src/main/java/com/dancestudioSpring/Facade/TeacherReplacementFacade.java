package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.TeacherReplacement.TeacherReplacementEditDTO;
import com.dancestudioSpring.DTO.TeacherReplacement.TeacherReplacementUpdateDTO;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherReplacement;
import com.dancestudioSpring.Service.DanceGroupDayOfWeekService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.TeacherReplacementService;
import com.dancestudioSpring.Service.TeacherService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Teacher.TeacherLiteViewModel;
import com.dancestudioSpring.ViewModel.TeacherReplacement.TeacherReplacementStatusViewModel;

@Component
public class TeacherReplacementFacade {

	@Autowired
	TeacherReplacementService teacherReplacementService;
	
	public TeacherReplacement add(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Teacher newTeacherReplace) {
		TeacherReplacement teacherReplacement = new TeacherReplacement();
		Date dateOfAdd = new Date();
		teacherReplacement.setDanceGroup(danceGroup);
		teacherReplacement.setDanceGroupDayOfWeek(danceGroupDayOfWeek);
		teacherReplacement.setTeacherReplace(newTeacherReplace);
		teacherReplacement.setDateOfDay(dateOfDay);
		teacherReplacement.setDateOfAdd(dateOfAdd);
		teacherReplacement.setDateOfUpdate(dateOfAdd);
		teacherReplacement = teacherReplacementService.add(teacherReplacement);
		return teacherReplacement;
	}
	
	

    public JsonAnswerStatus getEdit(TeacherReplacementEditDTO teacherReplacementEditDTO)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(teacherReplacementEditDTO.getId_of_dance_group());
        if (danceGroup == null) return new JsonAnswerStatus("error", "not_found_dance_group");

        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        DanceGroupDayOfWeek danceGroupDayOfWeek = danceGroupDayOfWeekService.findById(teacherReplacementEditDTO.getId_of_dance_group_day_of_week());
        if (danceGroupDayOfWeek == null) return new JsonAnswerStatus("error", "not_found_dance_group_day_of_week");

        Date dateOfDay = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfDay = formatter.parse(teacherReplacementEditDTO.getDateOfDay());
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    		return new JsonAnswerStatus("error", "not_date_of_lesson");
    	}
        

        Teacher teacherOfDanceGroup = (danceGroup.getTeacher() != null ? danceGroup.getTeacher() : null);

        Teacher teacherReplace = null;
        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        TeacherReplacement teacherReplacement = teacherReplacementService.find(dateOfDay, danceGroup, danceGroupDayOfWeek);
        if(teacherReplacement != null)
        {
            if (teacherReplacement.getTeacherReplace() != null) teacherReplace = teacherReplacement.getTeacherReplace();
        }

        //TeacherReplacementStatusViewModel
        TeacherService teacherService = new TeacherService();
        List<Teacher> teachers = teacherService.listAll();
        if(teacherOfDanceGroup != null) teachers.remove(teacherOfDanceGroup);

        ArrayList<TeacherLiteViewModel> teacherLiteViewModels = new ArrayList<TeacherLiteViewModel>();
        for (Teacher teacher : teachers)
        {
            System.out.println("teacher: " + teacher.getId());
            teacherLiteViewModels.add(new TeacherLiteViewModel(teacher.getId(), teacher.getName()));
        }

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setTeacherReplacementStatusViewModel(
    		new TeacherReplacementStatusViewModel(
                    (teacherReplace != null ? teacherReplace.getId() : 0),
                    teacherLiteViewModels,
                    dateOfDay,
                    danceGroup.getName(),
                    danceGroupDayOfWeekFacade.getDayOfWeekByDateTimeDayOfWeek(danceGroupDayOfWeek.getDayOfWeek()) 
                    + " " + danceGroupDayOfWeekFacade.getTimeFromTimeTo(danceGroupDayOfWeek)
                )
		);
        
        return jsonAnswerStatus;
    }

    public boolean update(TeacherReplacementUpdateDTO teacherReplacementUpdateDTO)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(teacherReplacementUpdateDTO.getId_of_dance_group());
        if (danceGroup == null) return false;

        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        DanceGroupDayOfWeek danceGroupDayOfWeek = danceGroupDayOfWeekService.findById(teacherReplacementUpdateDTO.getId_of_dance_group_day_of_week());
        if (danceGroupDayOfWeek == null) return false;

        Teacher teacherReplace = null;
        int status = 0;
        if(teacherReplacementUpdateDTO.getId_of_teacher_replace() != 0)
        {
            status = 1;
            TeacherService teacherService = new TeacherService();
            teacherReplace = teacherService.findById(teacherReplacementUpdateDTO.getId_of_teacher_replace());
            if (teacherReplace == null) return false;
        }
        //if (teacherReplace == null) return false;

        Date dateOfDay = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfDay = formatter.parse(teacherReplacementUpdateDTO.getDateOfDay());
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    	}

        return update(dateOfDay, danceGroup, danceGroupDayOfWeek, teacherReplace, status);
    }

    public boolean update(Date dateOfDay, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, Teacher teacherReplace, int status)
    {
        if (status == 1)
        {
            if (teacherReplace == null) return false;
            TeacherReplacement teacherReplacement = teacherReplacementService.find(dateOfDay, danceGroup, danceGroupDayOfWeek);
            if (teacherReplacement == null)
            {
                teacherReplacement = this.add(dateOfDay, danceGroup, danceGroupDayOfWeek, teacherReplace);
                if (teacherReplacement != null)
                {
                    //нужен перерасчет ззарплаты

                    return true;
                }
            }
            else
            {
            	teacherReplacement.setTeacherReplace(teacherReplace);
                if (teacherReplacementService.update(teacherReplacement))
                {
                    //нужен перерасчет ззарплаты

                    return true;
                }
            }
        }
        else if (status == 0)
        {
            if (teacherReplacementService.delete(dateOfDay, danceGroup, danceGroupDayOfWeek))
            {
                //нужен перерасчет ззарплаты

                return true;
            }
        }

        return false;
    }


    public boolean delete(int id)
    {
        TeacherReplacementService TeacherReplacementService = new TeacherReplacementService();
        TeacherReplacement TeacherReplacement = TeacherReplacementService.findById(id);
        if (TeacherReplacement == null) return false;

        return TeacherReplacementService.delete(TeacherReplacement);
    }
	
	
}
