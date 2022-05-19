package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.ConnectionAbonementToDiscount.ConnectionAbonementToDiscountUpdateDTO;
import com.dancestudioSpring.Facade.ConnectionAbonementToDiscountFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/connection_abonement_to_discount")
public class ApiConnectionAbonementToDiscountController {

	@Autowired
	ConnectionAbonementToDiscountFacade connectionAbonementToDiscountFacade;

	@PostMapping("/update")
    public JsonAnswerStatus update(ConnectionAbonementToDiscountUpdateDTO connectionAbonementToDiscountUpdateDTO)
    {
		if(!connectionAbonementToDiscountUpdateDTO.isValid())return JsonAnswerStatus.noData();
        
        return connectionAbonementToDiscountFacade.update(connectionAbonementToDiscountUpdateDTO)
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
}
