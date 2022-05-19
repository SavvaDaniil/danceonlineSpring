package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.DanceGroupDayOfWeek.DanceGroupDayOfWeekEditByColumnDTO;
import com.dancestudioSpring.DTO.DanceGroupDayOfWeek.DanceGroupDayOfWeekIdDTO;
import com.dancestudioSpring.DTO.DanceGroupDayOfWeek.DanceGroupDayOfWeekNewDTO;
import com.dancestudioSpring.Facade.DanceGroupDayOfWeekFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/dance_group_day_of_week")
public class ApiDanceGroupDayOfWeekController {


	@Autowired
	DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade;
	
	

    @PostMapping("/add")
    public JsonAnswerStatus add(DanceGroupDayOfWeekNewDTO danceGroupDayOfWeekNewDTO)
    {
    	if(!danceGroupDayOfWeekNewDTO.isValid())return JsonAnswerStatus.noData();
    	
        return danceGroupDayOfWeekFacade.add(danceGroupDayOfWeekNewDTO.getId_of_dance_group(), danceGroupDayOfWeekNewDTO.getIsEvent()) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/update")
    public JsonAnswerStatus update(DanceGroupDayOfWeekEditByColumnDTO danceGroupDayOfWeekEditByColumnDTO)
    {
    	if(!danceGroupDayOfWeekEditByColumnDTO.isValid())return JsonAnswerStatus.noData();

        return danceGroupDayOfWeekFacade.update(
                danceGroupDayOfWeekEditByColumnDTO.getId_of_dance_group_day_of_week(),
                danceGroupDayOfWeekEditByColumnDTO.getName(),
                danceGroupDayOfWeekEditByColumnDTO.getValue(),
                danceGroupDayOfWeekEditByColumnDTO.getDateData(),
                danceGroupDayOfWeekEditByColumnDTO.getTime()
        );
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(DanceGroupDayOfWeekIdDTO danceGroupDayOfWeekIdDTO)
    {
    	if(!danceGroupDayOfWeekIdDTO.isValid())return JsonAnswerStatus.noData();

        return danceGroupDayOfWeekFacade.delete(danceGroupDayOfWeekIdDTO.getId_of_dance_group_day_of_week())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
