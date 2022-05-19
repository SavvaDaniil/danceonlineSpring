package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.DanceGroupEventDate.DanceGroupEventDateEditByColumnDTO;
import com.dancestudioSpring.DTO.DanceGroupEventDate.DanceGroupEventDateIdDTO;
import com.dancestudioSpring.DTO.DanceGroupEventDate.DanceGroupEventDateNewDTO;
import com.dancestudioSpring.Facade.DanceGroupEventDateFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/dance_group_event_date")
public class ApiDanceGroupEventDateController {

	@Autowired
	DanceGroupEventDateFacade danceGroupEventDateFacade;

    @PostMapping("/add")
    public JsonAnswerStatus add(DanceGroupEventDateNewDTO danceGroupEventDateNewDTO)
    {
    	if(!danceGroupEventDateNewDTO.isValid())return JsonAnswerStatus.noData();
    	
        return danceGroupEventDateFacade.add(danceGroupEventDateNewDTO.getId_of_dance_group()) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/update")
    public JsonAnswerStatus update(DanceGroupEventDateEditByColumnDTO danceGroupEventDateEditByColumnDTO)
    {
    	if(!danceGroupEventDateEditByColumnDTO.isValid())return JsonAnswerStatus.noData();

        return danceGroupEventDateFacade.update(
            danceGroupEventDateEditByColumnDTO.getId_of_dance_group_event_date(), 
            danceGroupEventDateEditByColumnDTO.getName(),
            danceGroupEventDateEditByColumnDTO.getValue(),
            danceGroupEventDateEditByColumnDTO.getDateData(),
            danceGroupEventDateEditByColumnDTO.getTime()
        );
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(DanceGroupEventDateIdDTO danceGroupEventDateIdDTO)
    {
    	if(!danceGroupEventDateIdDTO.isValid())return JsonAnswerStatus.noData();
    	
        return danceGroupEventDateFacade.delete(danceGroupEventDateIdDTO.getId_of_dance_group_event_date())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
