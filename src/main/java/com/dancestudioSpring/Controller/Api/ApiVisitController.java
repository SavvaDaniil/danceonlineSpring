package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.DTO.Visit.VisitAnalyticsDTO;
import com.dancestudioSpring.DTO.Visit.VisitIdDTO;
import com.dancestudioSpring.DTO.Visit.VisitLessonFilterDTO;
import com.dancestudioSpring.DTO.Visit.VisitPrepareDTO;
import com.dancestudioSpring.Facade.VisitFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/visit")
public class ApiVisitController {

	@Autowired
	VisitFacade visitFacade;

    @PostMapping("/prepare")
    public JsonAnswerStatus prepare(VisitPrepareDTO visitPrepareDTO)
    {
    	if(!visitPrepareDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setVisitPrepareViewModel(visitFacade.prepareByAdmin(
                visitPrepareDTO.getId_of_user(), 
                visitPrepareDTO.getId_of_dance_group(), 
                visitPrepareDTO.getId_of_dance_group_day_of_week(),
                visitPrepareDTO.getDate_of_day()
            )
		);
        return jsonAnswerStatus;
    }

    /*
    @PostMapping("/app/prepare")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appPrepare(VisitPrepareByUserDTO visitPrepareByUserDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(
                new JsonAnswerStatus(
                    "success", 
                    null, 
                    visitFacade.prepareByUser(
                        HttpContext,
                        visitPrepareByUserDTO.id_of_dance_group,
                        visitPrepareByUserDTO.id_of_dance_group_day_of_week,
                        visitPrepareByUserDTO.date_of_lesson
                    )
                )
            );
        }
        return Ok();
    }
    /*

    @PostMapping("/add")
    [Authorize(AuthenticationSchemes = "AdminCookie")
    public JsonAnswerStatus addByAdmin(VisitNewDTO visitNewDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.addByAdmin(visitNewDTO));
        }
        return Ok();
    }

    /*
    @PostMapping("/app/add")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus addByUser(VisitNewByUserDTO visitNewByUserDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.addByUser(HttpContext, visitNewByUserDTO));
        }
        return Ok();
    }



    @PostMapping("/app/admin/get_with_purchase_abonement")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appUserAdminGetFullInfo(VisitIdDTO visitIdDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.getFullInfoForAdmin(HttpContext, visitIdDTO.id_of_visit));
        }
        return Ok();
    }
    */



    @PostMapping("/delete")
    public JsonAnswerStatus deleteByAdmin(VisitIdDTO visitIdDTO)
    {
    	if(!visitIdDTO.isValid())return JsonAnswerStatus.noData();

        return visitFacade.deleteByAdmin(visitIdDTO.getId_of_visit());
    }

    /*
    @PostMapping("/app/delete")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus deleteByUser(VisitIdDTO visitIdDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok( visitFacade.deleteByUser(HttpContext, visitIdDTO.id_of_visit));
        }
        return Ok();
    }

    @PostMapping("/app/admin/delete")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus deleteByUserAdmin(VisitIdDTO visitIdDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.deleteByUserAdmin(HttpContext, visitIdDTO.id_of_visit));
        }
        return Ok(new JsonAnswerStatus("error", "no_data"));
    }
    */


    @PostMapping("/list_by_user")
    public JsonAnswerStatus listAllByUser(UserIdDTO userIdDTO)
    {
    	if(!userIdDTO.isValid())return JsonAnswerStatus.noData();
    	
    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setVisitLiteViewModels(visitFacade.listAllByUser(userIdDTO.getId_of_user()));
        return jsonAnswerStatus;
    }

    /*
    @PostMapping("/app/list_by_user")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appListAllByUser()
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(new JsonAnswerStatus("success", null, visitFacade.listAllByUser(HttpContext)));
        }
        return Ok();
    }

    @PostMapping("/app/list_by_user_and_purchase_abonement")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appListAllByUser(PurchaseAbonementIdDTO purchaseAbonementIdDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(new JsonAnswerStatus("success", null, visitFacade.listAllByUser(HttpContext, purchaseAbonementIdDTO.id_of_purchase_abonement)));
        }
        return Ok();
    }
    */


    @PostMapping("/list_all_visit_lessons")
    public JsonAnswerStatus listAllAsVisitLessons(VisitLessonFilterDTO visitLessonFilterDTO)
    {
    	if(!visitLessonFilterDTO.isValid())return JsonAnswerStatus.noData();

    	JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
    	jsonAnswerStatus.setVisitLessonsByDateViewModel(visitFacade.listAllAsVisitLessons(visitLessonFilterDTO));

        return jsonAnswerStatus;
    }


    @PostMapping("/list_all_by_date")
    public JsonAnswerStatus listByDateOfBuyForAnalitycs(VisitAnalyticsDTO visitAnalyticsDTO)
    {
    	if(!visitAnalyticsDTO.isValid())return JsonAnswerStatus.noData();
    	
        return visitFacade.listByDateOfBuyForAnalytics(visitAnalyticsDTO);
    }

    /*
    @PostMapping("/app/admin/list_all_for_lesson")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appListByDateOfBuyForAnalitycs(VisitAnalyticsDTO visitAnalyticsDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.listByDateOfBuyAndDanceGroupForUserAdmin(HttpContext, visitAnalyticsDTO));
        }
        return Ok(new JsonAnswerStatus("error", "no_data"));
    }


    @PostMapping("/app/admin/reservation/update")
    [Authorize(AuthenticationSchemes = "UserJWT")
    public JsonAnswerStatus appReservationUpdate(VisitReservationDTO visitReservationDTO)
    {
        if (ModelState.IsValid)
        {
            VisitFacade visitFacade = new VisitFacade(_dbc);
            return Ok(visitFacade.reservationUpdateByAdmin(HttpContext, visitReservationDTO.id_of_visit, visitReservationDTO.action));
        }
        return Ok(new JsonAnswerStatus("error", "no_data"));
    }
    */
    
    
}
