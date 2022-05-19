package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionAbonementToDanceGroup.ConnectionAbonementToDanceGroupUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionAbonementToDanceGroupFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_abonement_to_dance_group")
public class ApiConnectionAbonementToDanceGroupController {

	@Autowired
	ConnectionAbonementToDanceGroupFacade connectionAbonementToDanceGroupFacade;
	
	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionAbonementToDanceGroupUpdateDTO connectionAbonementToDanceGroupUpdateDTO)
    {
		if(!connectionAbonementToDanceGroupUpdateDTO.isValid())return JsonAnswerStatus.noData();
		
	    return connectionAbonementToDanceGroupFacade.update(connectionAbonementToDanceGroupUpdateDTO)
	        ? new JsonAnswerStatus("success", null)
	        : new JsonAnswerStatus("error", "unknown");
    }
}
