package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.DanceGroupCansel.DanceGroupCanselEditByColumnDTO;
import com.dancestudioSpring.DTO.DanceGroupCansel.DanceGroupCanselIdDTO;
import com.dancestudioSpring.Facade.DanceGroupCanselFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/dance_group_cansel")
public class ApiDanceGroupCanselController {

	@Autowired
	DanceGroupCanselFacade danceGroupCanselFacade;
	
	@PostMapping("/add")
    public JsonAnswerStatus add()
    {
        return danceGroupCanselFacade.add() != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
    
    @PostMapping("/update")
    public JsonAnswerStatus update(DanceGroupCanselEditByColumnDTO danceGroupCanselEditByColumnDTO)
    {
		if(!danceGroupCanselEditByColumnDTO.isValid())return JsonAnswerStatus.noData();

        return danceGroupCanselFacade.update(
            danceGroupCanselEditByColumnDTO.id_of_dance_group_cansel, 
            danceGroupCanselEditByColumnDTO.name,
            danceGroupCanselEditByColumnDTO.value,
            danceGroupCanselEditByColumnDTO.dateData);
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(DanceGroupCanselIdDTO danceGroupCanselIdDTO)
    {
        return (
            danceGroupCanselFacade.delete(danceGroupCanselIdDTO.getId_of_dance_group_cansel())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown")
        );
    }
}
