package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionUserToDanceGroup.ConnectionUserToDanceGroupUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionUserToDanceGroupFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_user_to_dance_group")
public class ApiConnectionUserToDanceGroupController {

	@Autowired
	ConnectionUserToDanceGroupFacade connectionUserToDanceGroupFacade;

	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionUserToDanceGroupUpdateDTO connectionUserToDanceGroupUpdateDTO)
    {
		if(!connectionUserToDanceGroupUpdateDTO.isValid())return JsonAnswerStatus.noData();

        return connectionUserToDanceGroupFacade.update(connectionUserToDanceGroupUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
