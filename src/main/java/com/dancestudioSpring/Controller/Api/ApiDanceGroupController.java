package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.DanceGroup.DanceGroupDateDTO;
import com.dancestudioSpring.DTO.DanceGroup.DanceGroupEditByColumnDTO;
import com.dancestudioSpring.DTO.DanceGroup.DanceGroupIdDTO;
import com.dancestudioSpring.DTO.DanceGroup.DanceGroupNewDTO;
import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.Facade.DanceGroupFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/dance_group")
public class ApiDanceGroupController {

	@Autowired
	DanceGroupFacade danceGroupFacade;
	

    @PostMapping("/list_connections_to_user_admin")
    public JsonAnswerStatus listConnectionsToUserAdmin(UserIdDTO userIdDTO)
    {
		if(!userIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setDanceGroupConnectionToUserAdminViewModels(danceGroupFacade.listAllWithConnectectionToUserAdmin(userIdDTO.getId_of_user()));
    	
        return jsonAnswerStatus;
    }

    @PostMapping("/list_by_day_of_week")
    public JsonAnswerStatus listAllByDanceGroupDayOfWeek()
    {
    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setDanceGroupByDanceGroupDayOfWeekLiteViewModels(danceGroupFacade.listAllByDanceGroupDayOfWeek());
    	
        return jsonAnswerStatus;
    }



    @PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(DanceGroupIdDTO danceGroupIdDTO)
    {
		if(!danceGroupIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setDanceGroupEditViewModel(danceGroupFacade.getEdit(danceGroupIdDTO.getId_of_dance_group()));

        return jsonAnswerStatus;
    }

    @PostMapping("/get_schedule")
    public JsonAnswerStatus getSchedule(DanceGroupDateDTO danceGroupDateDTO)
    {
    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setDanceGroupScheduleWithNameOfDayOfWeek(danceGroupFacade.getScheduleByDate(danceGroupDateDTO.getDate_of_day()));
    	
        return jsonAnswerStatus;
    }
    
    /*
    @PostMapping("/get_schedule_by_dates")
    [Authorize(AuthenticationSchemes = "UserJWT")
    [AllowAnonymous]
    public JsonAnswerStatus getScheduleByDates(DanceGroupScheduleDatesDTO danceGroupScheduleDatesDTO)
    {
        if (ModelState.IsValid)
        {
            DanceGroupFacade danceGroupFacade = new DanceGroupFacade(_dbc);
            return Ok(
                new JsonAnswerStatus(
                "success",
                null,
               danceGroupFacade.getScheduleFromDateToDate(HttpContext, danceGroupScheduleDatesDTO.filterDateFromStr, danceGroupScheduleDatesDTO.filterDateToStr, true))
            );
        }
        return jsonAnswerStatus;
    }

    @PostMapping("/app/admin/schedule/get")
    [Authorize(AuthenticationSchemes = "UserJWT")
    [AllowAnonymous]
    public JsonAnswerStatus getScheduleForUserAdmin()
    {
        DanceGroupFacade danceGroupFacade = new DanceGroupFacade(_dbc);
        return Ok(
            new JsonAnswerStatus(
            "success",
            null,
           danceGroupFacade.getScheduleForAppUserAdmin(HttpContext))
        );
    }

    
    @PostMapping("/app/get")
    [Authorize(AuthenticationSchemes = "UserJWT")
    [AllowAnonymous]
    public JsonAnswerStatus appGet(DanceGroupGetDTO danceGroupGetDTO)
    {
        if (ModelState.IsValid)
        {
            DanceGroupFacade danceGroupFacade = new DanceGroupFacade(_dbc);
            return Ok(
               danceGroupFacade.getForApp(
                    HttpContext, 
                    danceGroupGetDTO.id_of_dance_group, 
                    danceGroupGetDTO.id_of_dance_group_day_of_week, 
                    danceGroupGetDTO.date_of_lesson_str,
                    danceGroupGetDTO.id_of_visit
                )
            );
        }
        return jsonAnswerStatus;
    }
    */



    @PostMapping("/add")
    public JsonAnswerStatus add(DanceGroupNewDTO danceGroupNewDTO)
    {
		if(!danceGroupNewDTO.isValid())return JsonAnswerStatus.noData();
		
        return danceGroupFacade.add(danceGroupNewDTO) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/update")
    public JsonAnswerStatus update(DanceGroupEditByColumnDTO danceGroupEditByColumnDTO)
    {
		if(!danceGroupEditByColumnDTO.isValid())return JsonAnswerStatus.noData();
		
        return danceGroupFacade.update(danceGroupEditByColumnDTO);
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(DanceGroupIdDTO danceGroupIdDTO)
    {
		if(!danceGroupIdDTO.isValid())return JsonAnswerStatus.noData();
		
        return danceGroupFacade.delete(danceGroupIdDTO.getId_of_dance_group())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
	
}
