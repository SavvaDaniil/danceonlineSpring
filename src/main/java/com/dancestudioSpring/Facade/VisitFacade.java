package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.Visit.VisitAnalyticsDTO;
import com.dancestudioSpring.DTO.Visit.VisitLessonFilterDTO;
import com.dancestudioSpring.DTO.Visit.VisitNewByUserDTO;
import com.dancestudioSpring.DTO.Visit.VisitNewDTO;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Entity.PurchaseAbonement;
import com.dancestudioSpring.Entity.TeacherReplacement;
import com.dancestudioSpring.Entity.TeacherSalary;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Entity.Visit;
import com.dancestudioSpring.Model.DanceGroupLesson;
import com.dancestudioSpring.Model.DanceGroupLessonUserVisitsData;
import com.dancestudioSpring.Service.DanceGroupDayOfWeekService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.PurchaseAbonementService;
import com.dancestudioSpring.Service.TeacherReplacementService;
import com.dancestudioSpring.Service.TeacherSalaryService;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.Service.VisitService;
import com.dancestudioSpring.ViewModel.DateWithDanceGroupDayOfWeekViewModel;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Abonement.AbonementsBySpecialStatusViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.TeacherSalary.TeacherSalaryLiteViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitAnalyticsLiteViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonHeaderDate;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonPurchaseSumm;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonRowPurchaseSumm;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonRowTeacherSalary;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonRowUserCount;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonTeacherSalary;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonUserCount;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonUserData;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonUserVisitStatus;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonsByDateViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitLiteViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitPrepareViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitStatisticLiteViewModel;

@Component
public class VisitFacade {

	@Autowired
	VisitService visitService;
	
	public Visit add(User user, DanceGroup danceGroup, DanceGroupDayOfWeek danceGroupDayOfWeek, PurchaseAbonement purchaseAbonement, 
			Date dateOfBuy,boolean isAddByApp,boolean isReservation) {
		
		Visit visit = new Visit();
		visit.setUser(user);
		visit.setDanceGroup(danceGroup);
		visit.setDanceGroupDayOfWeek(danceGroupDayOfWeek);
		visit.setPurchaseAbonement(purchaseAbonement);
		
		visit.setDateOfAdd(new Date());
		visit.setDateOfBuy(dateOfBuy);
		visit.setIsAddByApp(isAddByApp ? 1 : 0);
		visit.setIsReservation(isReservation ? 1 : 0);
		
		visit = visitService.add(visit);
		return visit;
	}
	
	
    public VisitPrepareViewModel prepareByUser(
        int id_of_user, int id_of_dance_group, int id_of_dance_group_day_of_week, String date_of_day, int id_of_visit)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        if (id_of_visit != 0)
        {
            Visit visit = visitService.findById(id_of_visit);
            if (visit != null)
            {
                if (visit.getUser() != user) return null;
            }
            return prepare(user, id_of_dance_group, id_of_dance_group_day_of_week, date_of_day, visit, true);
        }

        return prepare(user, id_of_dance_group, id_of_dance_group_day_of_week, date_of_day, null, true);
    }

    public VisitPrepareViewModel prepareByAdmin(
        int id_of_user, int id_of_dance_group, int id_of_dance_group_day_of_week, String date_of_day
    )
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        return prepare(user, id_of_dance_group, id_of_dance_group_day_of_week, date_of_day, null, false);
    }


    ...


    public JsonAnswerStatus getFullInfoForAdmin(int id_of_user, int id_of_visit)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;
        if (user.getStatusOfAdmin() != 1) return new JsonAnswerStatus("error", "no_access");

        VisitService visitService = new VisitService();
        Visit visit = visitService.findById(id_of_visit);
        if (visit == null) return new JsonAnswerStatus("error", "not_found");

        //PurchaseAbonementService purchaseAbonementService = new PurchaseAbonementService();

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        VisitLiteViewModel visitLiteViewModel = new VisitLiteViewModel(
            visit.getId(),
            visit.getDateOfBuy(),
            visit.getDateOfAdd(),
            (visit.getDanceGroup() != null ? visit.getDanceGroup().getId() : 0),
            (visit.getDanceGroup() != null ? visit.getDanceGroup().getName() : null),
            (visit.getDanceGroupDayOfWeek() != null ? visit.getDanceGroupDayOfWeek().getId() : 0),
            (visit.getDanceGroupDayOfWeek() != null ? danceGroupDayOfWeekFacade.getTimeFrom(visit.getDanceGroupDayOfWeek()) : null),
            (visit.getDanceGroupDayOfWeek() != null ? danceGroupDayOfWeekFacade.getTimeTo(visit.getDanceGroupDayOfWeek()) : null),
            (visit.getPurchaseAbonement() != null ? visit.getPurchaseAbonement().getId() : 0),
            (visit.getPurchaseAbonement() != null ? (visit.getPurchaseAbonement().getAbonement() != null 
            ? visit.getPurchaseAbonement().getAbonement().getName() : null) : null),
            visit.getIsAddByApp(),
            visit.getIsReservation(),
            visit.getStatusOfReservationChecked(),
            getStatusForDisableCanselByUser(visit),
            (visit.getUser() != null ? visit.getUser().getId() : 0),
            (visit.getUser() != null ? visit.getUser().getSecondname() : null),
            (visit.getUser() != null ? visit.getUser().getFirstname() : null)
        );
        if(visit.getPurchaseAbonement() != null)
        {
            PurchaseAbonementFacade purchaseAbonementFacade = new PurchaseAbonementFacade();
            //visitLiteViewModel.purchaseAbonementLiteViewModel = purchaseAbonementFacade.getLiteViewModel(visit.purchaseAbonement);
            visitLiteViewModel.setPurchaseAbonementLiteViewModel(purchaseAbonementFacade.getLiteViewModel(visit.getPurchaseAbonement()));
        }

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setVisitLiteViewModel(visitLiteViewModel);
        return jsonAnswerStatus;
    }



    public JsonAnswerStatus reservationUpdateByAdmin(int id_of_user, int id_of_visit, int action)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;
        if (user.getStatusOfAdmin() != 1) return new JsonAnswerStatus("error", "no_access");

        VisitService visitService = new VisitService();
        Visit visit = visitService.findById(id_of_visit);
        if (visit == null) return new JsonAnswerStatus("error", "not_found");

        if (!this.reservationUpdate(visit, action)) return new JsonAnswerStatus("error", "when_try_reservation_update");

        return new JsonAnswerStatus("success", null);
    }

    public boolean reservationActivate(Visit visit)
    {
        return this.reservationUpdate(visit, 1);
    }

    public boolean reservationDeactivate(Visit visit)
    {
        return this.reservationUpdate(visit, 0);
    }

    private boolean reservationUpdate(Visit visit, int action)
    {
        if (action != 0 && action != 1) return false;
        visit.setStatusOfReservationChecked(action);
        return visitService.update(visit);
    }
    



    @SuppressWarnings("deprecation")
	public int getStatusForDisableCanselByUser(Visit visit)
    {
        if (visit.getDateOfBuy() == null || visit.getDanceGroupDayOfWeek() == null) return 0;
        if (visit.getDanceGroupDayOfWeek().getTimeFrom() == null) return 0;
        
        Calendar calDateMaxForCanselVisit = Calendar.getInstance();
        calDateMaxForCanselVisit.setTime(visit.getDateOfBuy());
        calDateMaxForCanselVisit.set(Calendar.HOUR, visit.getDanceGroupDayOfWeek().getTimeFrom().getHours());
        calDateMaxForCanselVisit.set(Calendar.MINUTE, visit.getDanceGroupDayOfWeek().getTimeFrom().getMinutes());
        calDateMaxForCanselVisit.add(Calendar.MINUTE, 15);
        
        
        //Date dateTimeOfVisit = visit.dateOfBuy.Value.AddSeconds(visit.danceGroupDayOfWeek.timeFrom.Value.TotalSeconds);
        
        //System.out.println("dateTimeOfVisit: " + calDateOfVisit.getTime().toString());
        
       // return (dateTimeOfVisit.AddMinutes(15) < DateTime.Now ? 1 : 0);
        
        return calDateMaxForCanselVisit.after(new Date()) ? 1 : 0;
    }


    public JsonAnswerStatus deleteByAdmin(int id_of_visit)
    {
        VisitService visitService = new VisitService();
        Visit visit = visitService.findById(id_of_visit);
        if (visit == null) return new JsonAnswerStatus("error", "not_found");

        return this.delete(visit, true);
    }
    public JsonAnswerStatus deleteByUserAdmin(int id_of_user, int id_of_visit)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return new JsonAnswerStatus("error", "user_not_found");
        if (user.getStatusOfAdmin() != 1) return new JsonAnswerStatus("error", "no_access");

        VisitService visitService = new VisitService();
        Visit visit = visitService.findById(id_of_visit);
        if (visit == null) return new JsonAnswerStatus("error", "not_found");

        return delete(visit, true);
    }
    public JsonAnswerStatus deleteByUser(int id_of_user, int id_of_visit)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return new JsonAnswerStatus("error", "user_not_found");

        VisitService visitService = new VisitService();
        Visit visit = visitService.findById(id_of_visit);
        if (visit == null) return new JsonAnswerStatus("error", "not_found");

        if (visit.getUser() != user) return new JsonAnswerStatus("error", "user_not_match");

        return delete(visit, false);
    }

    public JsonAnswerStatus delete(Visit visit, boolean isDeleteByAdmin)
    {
        //возвращаем занятие купленному абонементу
        if (visit.getPurchaseAbonement() == null) return new JsonAnswerStatus("error","not_found_purchase_abonement_in_visit");
        PurchaseAbonementFacade purchaseAbonementFacade = new PurchaseAbonementFacade();
        if (!purchaseAbonementFacade.returnVisit(visit.getPurchaseAbonement(), isDeleteByAdmin)) 
        	return new JsonAnswerStatus("error", "fail_return_visit_to_purchase_abonement");

        Date dateOfBuy = visit.getDateOfBuy();
        DanceGroup danceGroup = visit.getDanceGroup();
        DanceGroupDayOfWeek danceGroupDayOfWeek = visit.getDanceGroupDayOfWeek();

        VisitService visitService = new VisitService();
        boolean resultOfDeleteVisit = visitService.delete(visit);

        if (visit.getUser() != null)
        {
            UserFacade userFacade = new UserFacade();
            userFacade.updateLastTimeVisit(visit.getUser(), visit.getDateOfBuy());
        }

        TeacherSalaryFacade teacherSalaryFacade = new TeacherSalaryFacade();
        if (teacherSalaryFacade.updateWithCheckReplacement(dateOfBuy, danceGroup, danceGroupDayOfWeek) == null)
        {
            System.out.println("Зарплата не просчитанна");
        }

        return (resultOfDeleteVisit
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "when_try_to_delete_visit")
        );
    }
}
