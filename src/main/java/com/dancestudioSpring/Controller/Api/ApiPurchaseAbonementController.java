package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementAnalyticsDTO;
import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementDTO;
import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementIdDTO;
import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementNewDTO;
import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.Facade.PurchaseAbonementFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/purchase_abonement")
public class ApiPurchaseAbonementController {

	@Autowired
	PurchaseAbonementFacade purchaseAbonementFacade;
	
	

    @PostMapping("/add")
    public JsonAnswerStatus add(PurchaseAbonementNewDTO purchaseAbonementNewDTO)
    {
    	if(!purchaseAbonementNewDTO.isValid())return JsonAnswerStatus.noData();

        return purchaseAbonementFacade.addByAdmin(purchaseAbonementNewDTO);
    }

    /*
    @PostMapping("/app/admin/get")
    public JsonAnswerStatus add(PurchaseAbonementIdDTO purchaseAbonementIdDTO)
    {
    	if(!purchaseAbonementIdDTO.isValid())return JsonAnswerStatus.noData();
    	
        return Ok(purchaseAbonementFacade.getForUserAdmin(HttpContext, purchaseAbonementIdDTO.id_of_purchase_abonement));
    }
    */

    @PostMapping("/delete")
    public JsonAnswerStatus delete(PurchaseAbonementIdDTO purchaseAbonementIdDTO)
    {
    	if(!purchaseAbonementIdDTO.isValid())return JsonAnswerStatus.noData();
    	
        return purchaseAbonementFacade.delete(purchaseAbonementIdDTO.getId_of_purchase_abonement())
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/list_all_active_for_user")
    public JsonAnswerStatus listAllActiveForUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setPurchaseAbonementLiteViewModels(purchaseAbonementFacade.listAllActiveByIdOfUser(userIdDTO.getId_of_user()));
    	
    	return jsonAnswerStatus;
    }

    /*
    @PostMapping("/app/list_all")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appListAll(DanceGroupIdDTO danceGroupIdDTO)
    {
        PurchaseAbonementFacade purchaseAbonementFacade = new PurchaseAbonementFacade(_dbc);
        return Ok(new JsonAnswerStatus("success", null, purchaseAbonementFacade.listAllForUser(HttpContext, danceGroupIdDTO.id_of_dance_group)));
    }
    */


    @PostMapping("/list_all_edit_for_user")
    public JsonAnswerStatus listAllEditForUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setPurchaseAbonementEditViewModels(purchaseAbonementFacade.listAllEditByIdOfUser(userIdDTO.getId_of_user()));

        return jsonAnswerStatus;
    }

    @PostMapping("/list_all_by_date")
    public JsonAnswerStatus listByDateOfBuyForAnalitycs(PurchaseAbonementAnalyticsDTO purchaseAbonementAnalyticsDTO)
    {
    	if(!purchaseAbonementAnalyticsDTO.isValid())return JsonAnswerStatus.noData();

        return purchaseAbonementFacade.listByDateOfBuyForAnalitycs(purchaseAbonementAnalyticsDTO);
    }



    @PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(PurchaseAbonementIdDTO purchaseAbonementIdDTO)
    {
    	if(!purchaseAbonementIdDTO.isValid())return JsonAnswerStatus.noData();
    	
        return purchaseAbonementFacade.getEdit(purchaseAbonementIdDTO.getId_of_purchase_abonement());
    }

    @PostMapping("/update")
    public JsonAnswerStatus update(PurchaseAbonementDTO purchaseAbonementDTO)
    {
    	if(!purchaseAbonementDTO.isValid())return JsonAnswerStatus.noData();

        return purchaseAbonementFacade.update(purchaseAbonementDTO);
    }
}
