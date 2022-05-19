package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.Discount.DiscountEditByColumnDTO;
import com.dancestudioSpring.DTO.Discount.DiscountIdDTO;
import com.dancestudioSpring.DTO.Discount.DiscountNewDTO;
import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.Facade.DiscountFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/discount")
public class ApiDiscountController {

	@Autowired
	DiscountFacade discountFacade;
	

    @PostMapping("/add")
    public JsonAnswerStatus add(DiscountNewDTO discountNewDTO)
    {
    	if(!discountNewDTO.isValid())return JsonAnswerStatus.noData();

        return discountFacade.add(discountNewDTO) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/update")
    public JsonAnswerStatus update(DiscountEditByColumnDTO discountEditByColumnDTO)
    {
    	if(!discountEditByColumnDTO.isValid())return JsonAnswerStatus.noData();

        return discountFacade.update(discountEditByColumnDTO);
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(DiscountIdDTO discountIdDTO)
    {
    	if(!discountIdDTO.isValid())return JsonAnswerStatus.noData();
    	
        return discountFacade.delete(discountIdDTO.getId_of_discount())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }



    @PostMapping("/list_by_user")
    public JsonAnswerStatus listOfUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setDiscountWithConnectionToUserLiteViewModels(discountFacade.listAllWithConnectectionToUserLite(userIdDTO.getId_of_user()));
    	
        return jsonAnswerStatus;
    }
}
