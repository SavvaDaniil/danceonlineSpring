package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionDanceGroupToUserAdmin.ConnectionDanceGroupToUserAdminUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionDanceGroupToUserAdminFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_dance_group_to_user_admin")
public class ApiConnectionDanceGroupToUserAdminController {

	@Autowired
	ConnectionDanceGroupToUserAdminFacade connectionDanceGroupToUserAdminFacade;

	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionDanceGroupToUserAdminUpdateDTO connectionDanceGroupToUserAdminUpdateDTO)
    {
		if(!connectionDanceGroupToUserAdminUpdateDTO.isValid())return JsonAnswerStatus.noData();
		
        return connectionDanceGroupToUserAdminFacade.update(connectionDanceGroupToUserAdminUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
