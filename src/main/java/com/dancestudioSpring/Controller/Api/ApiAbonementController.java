package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.Abonement.AbonementEditByColumnDTO;
import com.dancestudioSpring.DTO.Abonement.AbonementIdAndUserIdDTO;
import com.dancestudioSpring.DTO.Abonement.AbonementIdDTO;
import com.dancestudioSpring.DTO.Abonement.AbonementNewDTO;
import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.Facade.AbonementFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/abonement")
public class ApiAbonementController {

	@Autowired
	AbonementFacade abonementFacade;
	

    @PostMapping("/list_private_connections_to_user")
    public JsonAnswerStatus listPrivateConnectionsToUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();
    	
    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setAbonementLiteWithPrivateConnectionToUserViewModels(abonementFacade.listAllPrivateConnectionsToUser(userIdDTO.getId_of_user()));
    	
        return jsonAnswerStatus;
    }



    @PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(AbonementIdDTO abonementIdDTO)
    {
    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setAbonementEditViewModel(abonementFacade.getEdit(abonementIdDTO.getId_of_abonement()));
    	
        return jsonAnswerStatus;
    }

    @PostMapping("/add")
    public JsonAnswerStatus add(AbonementNewDTO abonementNewDTO)
    {
        return 
            abonementFacade.add(abonementNewDTO.getSpecial_status(), abonementNewDTO.getIs_trial()) != null
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/update")
    public JsonAnswerStatus add(AbonementEditByColumnDTO abonementEditByColumnDTO)
    {
        return abonementFacade.update(abonementEditByColumnDTO);
    }


    @PostMapping("/delete")
    public JsonAnswerStatus delete(AbonementIdDTO abonementIdDTO)
    {
        return abonementFacade.delete(abonementIdDTO.getId_of_abonement())
                ? new JsonAnswerStatus("success", null)
                : new JsonAnswerStatus("error", "unknown");
    }

    @PostMapping("/list_all_for_admin_to_user")
    public JsonAnswerStatus listAllForAdminToUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setAbonementsBySpecialStatusViewModel(
    			abonementFacade.listsAllBySpecialStatusForUserByAdmin(userIdDTO.getId_of_user()));
    	
        return jsonAnswerStatus;
    }

    /*
    @PostMapping("/app/list_all_for_user")
    public JsonAnswerStatus listAllForUser()
    {
        if (ModelState.IsValid)
        {
            AbonementFacade abonementFacade = new AbonementFacade(_dbc);
        return new JsonAnswerStatus("success", null, abonementFacade.appListsAllBySpecialStatusForUser(HttpContext)));
        }
    return );
    }
    */



    @PostMapping("/get_for_buy")
    public JsonAnswerStatus getForBuy(AbonementIdAndUserIdDTO abonementIdAndUserIdDTO)
    {
    	if(!abonementIdAndUserIdDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setAbonementForBuyingViewModel(
    			abonementFacade.getForBuy(abonementIdAndUserIdDTO.getId_of_user(), abonementIdAndUserIdDTO.getId_of_abonement()));
        return jsonAnswerStatus;
        
    }
}
