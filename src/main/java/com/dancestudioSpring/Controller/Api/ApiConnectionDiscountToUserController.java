package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionDiscountToUser.ConnectionDiscountToUserUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionDiscountToUserFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_discount_to_user")
public class ApiConnectionDiscountToUserController {

	@Autowired
	ConnectionDiscountToUserFacade connectionDiscountToUserFacade;

	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionDiscountToUserUpdateDTO connectionDiscountToUserUpdateDTO)
    {
		if(!connectionDiscountToUserUpdateDTO.isValid())return JsonAnswerStatus.noData();

        return connectionDiscountToUserFacade.update(connectionDiscountToUserUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

}
