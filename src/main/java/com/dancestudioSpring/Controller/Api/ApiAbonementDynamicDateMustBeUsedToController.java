package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.AbonementDynamicDateMustBeUsedTo.*;
import com.dancestudioSpring.Facade.AbonementDynamicDateMustBeUsedToFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
/*
@RestController
@RequestMapping("/api/XXXXXXXXXXXXXXXXXXXXXXXXXX")
 */

@RestController
@RequestMapping("/api/abonement_dynamic_date_must_be_used_to")
public class ApiAbonementDynamicDateMustBeUsedToController {

	@Autowired
	AbonementDynamicDateMustBeUsedToFacade abonementDynamicDateMustBeUsedToFacade;

	@PostMapping("/add")
    public JsonAnswerStatus add(AbonementDynamicDateMustBeUsedToNewDTO abonementDynamicDateMustBeUsedToNewDTO)
    {
		if(!abonementDynamicDateMustBeUsedToNewDTO.isValid())return JsonAnswerStatus.noData();

        return abonementDynamicDateMustBeUsedToFacade.add(abonementDynamicDateMustBeUsedToNewDTO.getId_of_abonement()) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

	@PostMapping("/update")
    public JsonAnswerStatus update(AbonementDynamicDateMustBeUsedToEditByColumnDTO abonementDynamicDateMustBeUsedToEditByColumnDTO)
    {
		if(!abonementDynamicDateMustBeUsedToEditByColumnDTO.isValid())return JsonAnswerStatus.noData();
        return abonementDynamicDateMustBeUsedToFacade.update(
    		abonementDynamicDateMustBeUsedToEditByColumnDTO.getId_of_abonement_dynamic_date_be_must_used_to(),
    		abonementDynamicDateMustBeUsedToEditByColumnDTO.getName(),
    		abonementDynamicDateMustBeUsedToEditByColumnDTO.getValue(),
    		abonementDynamicDateMustBeUsedToEditByColumnDTO.getDateData()
		);
    }


	@PostMapping("/delete")
    public JsonAnswerStatus delete(AbonementDynamicDateMustBeUsedToIdDTO abonementDynamicDateMustBeUsedToIdDTO)
    {
		if(!abonementDynamicDateMustBeUsedToIdDTO.isValid())return JsonAnswerStatus.noData();
        return abonementDynamicDateMustBeUsedToFacade.delete(abonementDynamicDateMustBeUsedToIdDTO.getId_of_abonement_dynamic_date_be_must_used_to())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }
	
	
}
