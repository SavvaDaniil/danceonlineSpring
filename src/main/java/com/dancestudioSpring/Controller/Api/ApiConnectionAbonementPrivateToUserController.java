package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionAbonementPrivateToUser.ConnectionAbonementPrivateToUserUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionAbonementPrivateToUserFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_abonement_private_to_user")
public class ApiConnectionAbonementPrivateToUserController {

	@Autowired
	ConnectionAbonementPrivateToUserFacade connectionAbonementPrivateToUserFacade;


	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionAbonementPrivateToUserUpdateDTO connectionAbonementPrivateToUserUpdateDTO)
    {
		if(!connectionAbonementPrivateToUserUpdateDTO.isValid())return JsonAnswerStatus.noData();

        return connectionAbonementPrivateToUserFacade.update(connectionAbonementPrivateToUserUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
