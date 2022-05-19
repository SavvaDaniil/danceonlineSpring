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

import com.dancestudioSpring.DTO.DanceGroup.DanceGroupEditByColumnDTO;
import com.dancestudioSpring.DTO.DanceGroup.DanceGroupNewDTO;
import com.dancestudioSpring.Entity.Branch;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Entity.TeacherReplacement;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.BranchService;
import com.dancestudioSpring.Service.ConnectionUserToDanceGroupService;
import com.dancestudioSpring.Service.DanceGroupCanselService;
import com.dancestudioSpring.Service.DanceGroupDayOfWeekService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.TeacherReplacementService;
import com.dancestudioSpring.Service.TeacherService;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.Branch.BranchLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupByDanceGroupDayOfWeekLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupConnectionToUserAdminViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupEditViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupScheduleViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupScheduleWithNameOfDayOfWeek;
import com.dancestudioSpring.ViewModel.DanceGroupCansel.DanceGroupCanselLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroupDayOfWeek.DanceGroupDayOfWeekLiteViewModel;
import com.dancestudioSpring.ViewModel.Teacher.TeacherLiteViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitLiteViewModel;

@Component
public class DanceGroupFacade {

	@Autowired
	DanceGroupService danceGroupService;
	
	public DanceGroup add(String name) {
		DanceGroup danceGroup = new DanceGroup();
		danceGroup.setName(name);
		danceGroup.setDateOfAdd(new Date());
		danceGroup.setDateOfUpdate(new Date());
		danceGroup = danceGroupService.add(danceGroup);
		return danceGroup;
	}

    public ArrayList<DanceGroupLiteViewModel> listAllLite()
    {
        List<DanceGroup> danceGroups = danceGroupService.listAll();
        ArrayList<DanceGroupLiteViewModel> danceGroupLiteViewModels = new ArrayList<DanceGroupLiteViewModel>();
        for (DanceGroup danceGroup : danceGroups)
        {
            danceGroupLiteViewModels.add(new DanceGroupLiteViewModel(
                    danceGroup.getId(),
                    danceGroup.getName(),
                    (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getName() : "- преподаватель не установлен -"),
                    danceGroup.getStatus(),
                    danceGroup.getStatusForApp()
                )
            );
        }

        return danceGroupLiteViewModels;
    }


    public ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel> listAllByDanceGroupDayOfWeek()
    {
        List<DanceGroup> danceGroups = danceGroupService.listAllOrderByName();
        ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel> danceGroupByDanceGroupDayOfWeekLiteViewModels = new ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel>();

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAllOrderByTimeFrom();

        for (DanceGroup danceGroup : danceGroups)
        {
            for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
            {
                if(danceGroupDayOfWeek.getDanceGroup() == danceGroup)
                {
                    danceGroupByDanceGroupDayOfWeekLiteViewModels.add(
                        new DanceGroupByDanceGroupDayOfWeekLiteViewModel(
                            danceGroup.getId(),
                            danceGroupDayOfWeek.getId(),
                            danceGroup.getId() + " - " + danceGroup.getName() + " | " 
                            + danceGroupDayOfWeekFacade.getDayOfWeekByDateTimeDayOfWeek(danceGroupDayOfWeek.getDayOfWeek())
                            + " " + danceGroupDayOfWeekFacade.getTimeFromTimeTo(danceGroupDayOfWeek)
                        )    
                    );
                }
            }
        }

        return danceGroupByDanceGroupDayOfWeekLiteViewModels;
    }


    public ArrayList<DanceGroupConnectionToUserAdminViewModel> listAllWithConnectectionToUserAdmin(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        DanceGroupService danceGroupService = new DanceGroupService();
        List<DanceGroup> danceGroups = danceGroupService.listAll();
        ArrayList<DanceGroupConnectionToUserAdminViewModel> danceGroupConnectionToUserAdminViewModels = new ArrayList<DanceGroupConnectionToUserAdminViewModel>();

        ConnectionDanceGroupToUserAdminFacade connectionDanceGroupToUserAdminFacade = new ConnectionDanceGroupToUserAdminFacade();
        List<Integer> listAllConnectedIdOfDanceGroupsByUser = connectionDanceGroupToUserAdminFacade.listAllConnectedIdOfDanceGroupsByUser(user);

        for (DanceGroup danceGroup : danceGroups)
        {
            danceGroupConnectionToUserAdminViewModels.add(
                new DanceGroupConnectionToUserAdminViewModel(
                    danceGroup.getId(),
                    danceGroup.getName(),
                    (listAllConnectedIdOfDanceGroupsByUser.contains(danceGroup.getId()) ? 1 : 0)
                )
            );
        }

        return danceGroupConnectionToUserAdminViewModels;
    }


    public DanceGroupEditViewModel getEdit(int id)
    {
        DanceGroup danceGroup = danceGroupService.findById(id);
        if (danceGroup == null) return null;

        TeacherFacade teacherFacade = new TeacherFacade();
        TeacherLiteViewModel teacherLiteViewModel = null;
        if (danceGroup.getTeacher() != null)
        {
            teacherLiteViewModel = teacherFacade.getLiteById(danceGroup.getTeacher().getId());
        }
        ArrayList<TeacherLiteViewModel> teacherLiteViewModels = (ArrayList<TeacherLiteViewModel>)teacherFacade.listAllLite();

        BranchFacade branchFacade = new BranchFacade();
        BranchLiteViewModel branchLiteViewModel = null;
        if (danceGroup.getBranch() != null)
        {
            branchLiteViewModel = branchFacade.getLiteById(danceGroup.getBranch().getId());
        }
        ArrayList<BranchLiteViewModel> branchLiteViewModels = branchFacade.listAllLite();

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        ArrayList<DanceGroupDayOfWeekLiteViewModel> danceGroupDayOfWeekLiteViewModels = danceGroupDayOfWeekFacade.listAllLiteByDanceGroup(danceGroup);

        AbonementFacade abonementFacade = new AbonementFacade();
        ArrayList<AbonementLiteViewModel> abonementLiteViewModels = abonementFacade.listAllLite(true);

        ConnectionAbonementToDanceGroupFacade connectionAbonementToDanceGroupFacade = new ConnectionAbonementToDanceGroupFacade();
        ArrayList<Integer> listIdOfConnectedAbonementsToDanceGroup = connectionAbonementToDanceGroupFacade.listAllConnectedIdOfAbonementsByDanceGroup(danceGroup);

        //DanceGroupEventDateFacade danceGroupEventDateFacade = new DanceGroupEventDateFacade();
        //List<DanceGroupEventDateLiteViewModel> danceGroupEventDateLiteViewModels = danceGroupEventDateFacade.listAllLiteByDanceGroup(danceGroup);

        DanceGroupEditViewModel danceGroupEditViewModel = new DanceGroupEditViewModel(
            danceGroup.getId(),
            danceGroup.getName(),
            teacherLiteViewModel,
            teacherLiteViewModels,
            danceGroup.getDescription(),
            branchLiteViewModel,
            branchLiteViewModels,
            danceGroup.getStatus(),
            danceGroup.getIsEvent(),
            danceGroup.getStatusForApp(),
            danceGroup.getStatusOfCreative(),
            danceGroup.getIsActiveReservation(),
            danceGroup.getIsAbonementsAllowAll(),
            danceGroupDayOfWeekLiteViewModels,
            abonementLiteViewModels,
            listIdOfConnectedAbonementsToDanceGroup
        );

        return danceGroupEditViewModel;
    }



    public DanceGroupScheduleWithNameOfDayOfWeek getScheduleByDate(String date_of_day)
    {
    	Date dateOfDay = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfDay = formatter.parse(date_of_day);
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    	}

    	
    	Calendar calDateOfDay = Calendar.getInstance();
    	calDateOfDay.setTime(dateOfDay);
        int dayOfWeek = calDateOfDay.get(Calendar.DAY_OF_WEEK);

        DanceGroupService danceGroupService = new DanceGroupService();
        List<DanceGroup> danceGroups = danceGroupService.listAll();

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAllActive();

        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        ArrayList<TeacherReplacement> teacherReplacementsByDates = 
        		(ArrayList<TeacherReplacement>)teacherReplacementService.listAllByDates(dateOfDay, dateOfDay);

        boolean isReplacementExistForLesson = false;

        //DanceGroupEventDateFacade danceGroupEventDateFacade = new DanceGroupEventDateFacade();
        //List<DanceGroupEventDateLiteViewModel> danceGroupEventDateLiteViewModels = danceGroupEventDateFacade.listAllActiveLiteByDates(dateOfDay, dateOfDay);

        DanceGroupCanselFacade danceGroupCanselFacade = new DanceGroupCanselFacade();
        List<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = danceGroupCanselFacade.listAllActiveByDate(dateOfDay, dateOfDay);
        boolean isCansel = false;

        ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels = new ArrayList<DanceGroupScheduleViewModel>();
        final Date dateOfDayFinal = dateOfDay;
        for (DanceGroup danceGroup : danceGroups) {
            for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
            {

                if(danceGroup == danceGroupDayOfWeek.getDanceGroup() && danceGroupDayOfWeek.getStatus() == 1 
                		&& ((danceGroupDayOfWeek.getDayOfWeek() == dayOfWeek && danceGroupDayOfWeek.getIsEvent() == 0) || (
                    danceGroupDayOfWeek.getDateOfEvent() == dateOfDay && danceGroupDayOfWeek.getIsEvent() == 1)))
                {
                	
                    //isReplacementExistForLesson = teacherReplacementsByDates
                    //        .Where(p => p.dateOfDay == dateOfDay && p.danceGroup == danceGroup && p.danceGroupDayOfWeek == danceGroupDayOfWeek)
                    //        .Any();
                    
                    isReplacementExistForLesson = teacherReplacementsByDates.stream()
                    		.anyMatch(p -> p.getDateOfDay().equals(dateOfDayFinal) && p.getDanceGroup().equals(danceGroup) 
                    				&& p.getDanceGroupDayOfWeek().equals(danceGroupDayOfWeek));
                    
                    //isCansel = danceGroupCanselLiteViewModels
                    //    .Where(p => p.id_of_dance_group == danceGroup.id)
                    //    .Any();
                    isCansel = danceGroupCanselLiteViewModels.stream()
                    		.anyMatch(p -> p.getId_of_dance_group() == danceGroup.getId());

                    danceGroupScheduleViewModels.add(
                        new DanceGroupScheduleViewModel(
                            danceGroup.getId(),
                            danceGroup.getName(),
                            danceGroupDayOfWeek.getId(),
                            danceGroupDayOfWeek.getIsEvent(),
                            dayOfWeek,
                            danceGroupDayOfWeekFacade.getTimeFrom(danceGroupDayOfWeek),
                            danceGroupDayOfWeekFacade.getTimeTo(danceGroupDayOfWeek),
                            dateOfDay.toString(),
                            (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getId() : 0),
                            (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getName() : null),
                            (danceGroup.getBranch() != null ? danceGroup.getBranch().getId() : 0),
                            (danceGroup.getBranch() != null ? danceGroup.getBranch().getName() : null),
                            danceGroup.getStatusOfCreative(),
                            danceGroup.getIsActiveReservation(),
                            (isCansel ? 1 : 0),
                            isReplacementExistForLesson
                        )
                    );
                    continue;
                }
            }

        }

        //danceGroupScheduleViewModels.sort((x, y) => x.time_from.CompareTo(y.time_from));
        danceGroupScheduleViewModels = (ArrayList<DanceGroupScheduleViewModel>) danceGroupScheduleViewModels.stream()
        		.sorted((o1, o2) -> o1.getTime_from().compareTo(o2.getTime_from()))
        		.collect(Collectors.toList());
        

        return new DanceGroupScheduleWithNameOfDayOfWeek(
            danceGroupDayOfWeekFacade.getDayOfWeekByDateTimeDayOfWeek(dayOfWeek),
            danceGroupScheduleViewModels
        );
    }


	@SuppressWarnings("deprecation")
	public ArrayList<DanceGroupScheduleWithNameOfDayOfWeek> getScheduleFromDateToDate(int id_of_user, 
    		String filterDateFromStr, String filterDateToStr, boolean isForApp)
    {
        ArrayList<Integer> idsOfAllConnectedDanceGropusToUser = new ArrayList<Integer>();
    	if(id_of_user != 0) {
	        //это перехват пользователя насчет творческих групп
	    	UserService userService = new UserService();
	        User user = userService.findById(id_of_user);
	        if (user != null) {
	            ConnectionUserToDanceGroupFacade connectionUserToDanceGroupFacade = new ConnectionUserToDanceGroupFacade();
	            idsOfAllConnectedDanceGropusToUser = connectionUserToDanceGroupFacade.listAllConnectedIdOfDanceGroupsByUser(user);
	        }
    	}

    	Date filterDateFrom = new Date();
    	Date filterDateTo = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            filterDateFrom = formatter.parse(filterDateFromStr);
            filterDateTo = formatter.parse(filterDateToStr);
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    	}

        DanceGroupService danceGroupService = new DanceGroupService();
        List<DanceGroup> danceGroups = (isForApp ? danceGroupService.listAllActiveForApp() : danceGroupService.listAll());

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAll();

        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        List<TeacherReplacement> teacherReplacementsByDates = teacherReplacementService.listAllByDates(filterDateFrom, filterDateTo);


        ArrayList<DanceGroupScheduleWithNameOfDayOfWeek> danceGroupScheduleWithNameOfDayOfWeeks = new ArrayList<DanceGroupScheduleWithNameOfDayOfWeek>();
        Date dateOfLessons = filterDateFrom;
        Calendar calDateOfDay = Calendar.getInstance();
        calDateOfDay.setTime(dateOfLessons);
        String nameOfDayInSchedule = null;
        ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels = new ArrayList<DanceGroupScheduleViewModel>();
        boolean isReplacementExistForLesson = false;

        DanceGroupCanselFacade danceGroupCanselFacade = new DanceGroupCanselFacade();
        List<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = danceGroupCanselFacade.listAllActiveByDate(filterDateFrom, filterDateTo);
        boolean isCansel = false;

        while (dateOfLessons.before(filterDateTo) || dateOfLessons.equals(filterDateTo))
        {
            //System.Diagnostics.Debug.WriteLine("dateOfLessons: "+ dateOfLessons.ToString("dd.MM.yyyy"));
            nameOfDayInSchedule = danceGroupDayOfWeekFacade.getDayOfWeekByDateTimeDayOfWeek(calDateOfDay.get(Calendar.DAY_OF_WEEK))
                + " / " + new SimpleDateFormat("MMM").format(dateOfLessons)
                + " " + dateOfLessons.getDay();
            danceGroupScheduleViewModels = new ArrayList<DanceGroupScheduleViewModel>();

            for (DanceGroup danceGroup : danceGroups)
            {
                //проверка на творческую или закрытую
                if(danceGroup.getStatusOfCreative() == 1)
                {
                    if (!idsOfAllConnectedDanceGropusToUser.contains(danceGroup.getId())) continue;
                }

                for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
                {
                    //if (danceGroupDayOfWeek.danceGroup != danceGroup) continue;
                    //isReplacementExistForLesson = false;
                    //if (danceGroupDayOfWeek.dayOfWeek == (int)dateOfLessons.DayOfWeek)
                    if (danceGroup == danceGroupDayOfWeek.getDanceGroup() && danceGroupDayOfWeek.getStatus() == 1 
                        && ((danceGroupDayOfWeek.getDayOfWeek() == calDateOfDay.get(Calendar.DAY_OF_WEEK) && danceGroupDayOfWeek.getIsEvent() == 0) || (
                        danceGroupDayOfWeek.getDateOfEvent() == dateOfLessons && danceGroupDayOfWeek.getIsEvent() == 1)))
                    {

                    	/*
                        isReplacementExistForLesson = teacherReplacementsByDates
                            .Where(p => p.dateOfDay == dateOfLessons && p.danceGroup == danceGroup && p.danceGroupDayOfWeek == danceGroupDayOfWeek)
                            .Any();
                        isCansel = danceGroupCanselLiteViewModels
                            .Where(p => p.id_of_dance_group == danceGroup.id)
                            .Any();
                            */
                        isReplacementExistForLesson = teacherReplacementsByDates.stream()
                        		.anyMatch(p -> p.getDateOfDay().equals(dateOfLessons) && p.getDanceGroup().equals(danceGroup) 
                        				&& p.getDanceGroupDayOfWeek().equals(danceGroupDayOfWeek));
                        isCansel = danceGroupCanselLiteViewModels.stream()
                        		.anyMatch(p -> p.getId_of_dance_group() == danceGroup.getId());
                        
                        danceGroupScheduleViewModels.add(
                            new DanceGroupScheduleViewModel(
                                danceGroup.getId(),
                                danceGroup.getName(),
                                danceGroupDayOfWeek.getId(),
                                danceGroupDayOfWeek.getIsEvent(),
                                danceGroupDayOfWeek.getDayOfWeek(),
                                danceGroupDayOfWeekFacade.getTimeFrom(danceGroupDayOfWeek),
                                danceGroupDayOfWeekFacade.getTimeFromTimeTo(danceGroupDayOfWeek),
                                dateOfLessons.toString(),
                                (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getId() : 0),
                                (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getName() : null),
                                (danceGroup.getBranch() != null ? danceGroup.getBranch().getId() : 0),
                                (danceGroup.getBranch() != null ? danceGroup.getBranch().getName() : null),
                                danceGroup.getStatusOfCreative(),
                                danceGroup.getIsActiveReservation(),
                                (isCansel ? 1 : 0),
                                isReplacementExistForLesson
                            )
                        );
                    }
                }
            }
            danceGroupScheduleWithNameOfDayOfWeeks.add(
                new DanceGroupScheduleWithNameOfDayOfWeek(
                    nameOfDayInSchedule,
                    danceGroupScheduleViewModels
                )
            );

            //dateOfLessons = dateOfLessons.AddDays(1);
            calDateOfDay.add(Calendar.DAY_OF_MONTH, 1);
        }

        return danceGroupScheduleWithNameOfDayOfWeeks;
    }

    public ArrayList<DanceGroupScheduleViewModel> getCurrentScheduleForAppUserAdmin(int id_of_user)
    {
    	UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;
        if (user.getStatusOfAdmin() != 1) return null;

        DanceGroupService danceGroupService = new DanceGroupService();
        List<DanceGroup> danceGroups = danceGroupService.listAll();
        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAll();

        Date dateNow = new Date();
        Calendar calDateFilter = Calendar.getInstance();
        calDateFilter.setTime(dateNow);
        
        calDateFilter.add(Calendar.DAY_OF_MONTH, -3);
        //Date dateOfLesson = calDateFilter.getTime();
        Calendar calendarDateOfLesson = calDateFilter;
        
        calDateFilter.add(Calendar.DAY_OF_MONTH, 6);
        //Date filterDateTo = calDateFilter.getTime();
        Calendar calendarFilterDateTo = calDateFilter;
        
        ConnectionDanceGroupToUserAdminFacade connectionDanceGroupToUserAdminFacade = new ConnectionDanceGroupToUserAdminFacade();
        HashSet<Integer> hashOfAllConnectedIdOfDanceGroupToUserAdmin = connectionDanceGroupToUserAdminFacade.hashOfAllConnectedIdOfDanceGroupsByUser(user);

        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        List<TeacherReplacement> teacherReplacementsByDates = 
        		teacherReplacementService.listAllByDates(calendarDateOfLesson.getTime(), calendarFilterDateTo.getTime());

        //очищаем от неподключенных групп
        //danceGroups = danceGroups.Where(p => hashOfAllConnectedIdOfDanceGroupToUserAdmin.Contains(p.id)).ToList();
        danceGroups = danceGroups.stream().filter(p -> hashOfAllConnectedIdOfDanceGroupToUserAdmin.contains(p.getId())).collect(Collectors.toList());
        
        if (danceGroups.size() == 0) return null;

        boolean isReplacementExistForLesson = false;

        DanceGroupCanselFacade danceGroupCanselFacade = new DanceGroupCanselFacade();
        List<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = 
        		danceGroupCanselFacade.listAllActiveByDate(calendarDateOfLesson.getTime(), calendarDateOfLesson.getTime());
        boolean isCansel = false;

        ArrayList<DanceGroupScheduleViewModel> danceGroupScheduleViewModels = new ArrayList<DanceGroupScheduleViewModel>();
        while (calendarDateOfLesson.before(calendarFilterDateTo) || calendarDateOfLesson.equals(calendarFilterDateTo))
        {
            for (DanceGroup danceGroup : danceGroups)
            {
                for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
                {
                    //if (danceGroupDayOfWeek.danceGroup != danceGroup) continue;
                    //isReplacementExistForLesson = false;
                    //if (danceGroupDayOfWeek.dayOfWeek == (int)dateOfLesson.DayOfWeek)
                    if (danceGroup == danceGroupDayOfWeek.getDanceGroup() && danceGroupDayOfWeek.getStatus() == 1 
                    		&& ((danceGroupDayOfWeek.getDayOfWeek() == calendarDateOfLesson.get(Calendar.DAY_OF_WEEK) 
                    		&& danceGroupDayOfWeek.getIsEvent() == 0) || (
                    danceGroupDayOfWeek.getDateOfEvent() == calendarDateOfLesson.getTime() && danceGroupDayOfWeek.getIsEvent() == 1)))
                    {
                    	/*
                        isReplacementExistForLesson = teacherReplacementsByDates
                            .Where(p => p.dateOfDay == dateOfLesson && p.danceGroup == danceGroup && p.danceGroupDayOfWeek == danceGroupDayOfWeek)
                            .Any();
                        isCansel = danceGroupCanselLiteViewModels
                            .Where(p => p.id_of_dance_group == danceGroup.id)
                            .Any();
                            */
                        isReplacementExistForLesson = teacherReplacementsByDates.stream()
                        		.anyMatch(p -> p.getDateOfDay().equals(calendarDateOfLesson) && p.getDanceGroup().equals(danceGroup) 
                        				&& p.getDanceGroupDayOfWeek().equals(danceGroupDayOfWeek));
                        isCansel = danceGroupCanselLiteViewModels.stream()
                        		.anyMatch(p -> p.getId_of_dance_group() == danceGroup.getId());
                        
                        danceGroupScheduleViewModels.add(
                            new DanceGroupScheduleViewModel(
                                danceGroup.getId(),
                                danceGroup.getName(),
                                danceGroupDayOfWeek.getId(),
                                danceGroupDayOfWeek.getIsEvent(),
                                danceGroupDayOfWeek.getDayOfWeek(),
                                danceGroupDayOfWeekFacade.getTimeFrom(danceGroupDayOfWeek),
                                danceGroupDayOfWeekFacade.getTimeFromTimeTo(danceGroupDayOfWeek),
                                calendarDateOfLesson.getTime().toString(),
                                (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getId() : 0),
                                (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getName() : null),
                                (danceGroup.getBranch() != null ? danceGroup.getBranch().getId() : 0),
                                (danceGroup.getBranch() != null ? danceGroup.getBranch().getName() : null),
                                danceGroup.getStatusOfCreative(),
                                danceGroup.getIsActiveReservation(),
                                (isCansel ? 1 : 0),
                                isReplacementExistForLesson
                            )
                        );
                    }
                }
            }
            //dateOfLesson = dateOfLesson.AddDays(1);
            calendarDateOfLesson.add(Calendar.DAY_OF_MONTH, 1);
        }
        return danceGroupScheduleViewModels;
    }



    public JsonAnswerStatus getForApp(int id_of_user, int id_of_dance_group, int id_of_dance_group_day_of_week, 
    		String date_of_lesson_str, int id_of_visit)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return new JsonAnswerStatus("error", "not_found_dance_group");

        Date dateOfLesson = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfLesson = formatter.parse(date_of_lesson_str);
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    	}
    	Calendar calDateOfLesson = Calendar.getInstance();
    	calDateOfLesson.setTime(dateOfLesson);

        DanceGroupDayOfWeekFacade danceGroupDayOfWeekFacade = new DanceGroupDayOfWeekFacade();
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        DanceGroupDayOfWeek danceGroupDayOfWeek = danceGroupDayOfWeekService.findByIdActive(id_of_dance_group_day_of_week);
        if (danceGroupDayOfWeek == null) return new JsonAnswerStatus("error", "not_found_dance_group_day_of_week");
        if (danceGroupDayOfWeek.getDanceGroup() == null) return new JsonAnswerStatus("error", "not_dance_group_in_dance_group_day_of_week");
        if (danceGroupDayOfWeek.getDanceGroup() != danceGroup) return new JsonAnswerStatus("error", "not_found_dance_group_day_of_week");
        if (danceGroupDayOfWeek.getDayOfWeek() != calDateOfLesson.get(Calendar.DAY_OF_WEEK)) return new JsonAnswerStatus("error", "not_match_day_of_week");


        TeacherReplacementService teacherReplacementService = new TeacherReplacementService();
        TeacherReplacement teacherReplacement = teacherReplacementService.find(dateOfLesson, danceGroup, danceGroupDayOfWeek);
        boolean isReplacementExistForLesson = (teacherReplacement != null);

        TeacherFacade teacherFacade = new TeacherFacade();
        String teacherPosterSrc = null;
        if(teacherReplacement != null)
        {
            teacherPosterSrc = teacherFacade.getPosterSrc(teacherReplacement.getId());
        } else if(danceGroup.getTeacher() != null)
        {
            teacherPosterSrc = teacherFacade.getPosterSrc(danceGroup.getTeacher().getId());
        }

        ArrayList<VisitLiteViewModel> visitLiteViewModels = new ArrayList<VisitLiteViewModel>();

        if(id_of_user != 0)
        {
            UserService userService = new UserService();
            User user = userService.findById(id_of_user);
            if(user != null)
            {
                VisitFacade visitFacade = new VisitFacade();
                if (id_of_visit != 0)
                {
                    VisitLiteViewModel visitLiteViewModel = visitFacade.getLiteById(id_of_visit);
                    if(visitLiteViewModel != null)
                    {
                        visitLiteViewModels.add(visitLiteViewModel);
                    } else
                    {
                        visitLiteViewModels = visitFacade.listAllByUserDanceGroupAndDate(user, danceGroup, danceGroupDayOfWeek, dateOfLesson);
                    }
                }
                else
                {
                    visitLiteViewModels = visitFacade.listAllByUserDanceGroupAndDate(user, danceGroup, danceGroupDayOfWeek, dateOfLesson);
                }
            }
        }

        DanceGroupCanselService danceGroupCanselService = new DanceGroupCanselService();
        boolean isCansel = danceGroupCanselService.isExist(danceGroup, dateOfLesson);

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setVisitLiteViewModels(visitLiteViewModels);
        
        jsonAnswerStatus.setDanceGroupScheduleWithNameOfDayOfWeek(
            new DanceGroupScheduleWithNameOfDayOfWeek(
            		danceGroupDayOfWeekFacade.getDayOfWeekByDateTimeDayOfWeek(calDateOfLesson.get(Calendar.DAY_OF_WEEK))
                    + " / " + new SimpleDateFormat("MMM").format(dateOfLesson)
                    + " " + dateOfLesson.getDay()
                    ,
                new DanceGroupScheduleViewModel(
                    danceGroup.getId(),
                    danceGroup.getName(),
                    danceGroupDayOfWeek.getId(),
                    danceGroupDayOfWeek.getIsEvent(),
                    danceGroupDayOfWeek.getDayOfWeek(),
                    danceGroupDayOfWeekFacade.getTimeFrom(danceGroupDayOfWeek),
                    danceGroupDayOfWeekFacade.getTimeFromTimeTo(danceGroupDayOfWeek),
                    dateOfLesson.toString(),
                    (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getId() : 0),
                    (danceGroup.getTeacher() != null ? danceGroup.getTeacher().getName() : null),
                    (danceGroup.getBranch() != null ? danceGroup.getBranch().getId() : 0),
                    (danceGroup.getBranch() != null ? danceGroup.getBranch().getName() : null),
                    danceGroup.getStatusOfCreative(),
                    danceGroup.getIsActiveReservation(),
                    (isCansel ? 1 : 0),
                    isReplacementExistForLesson,
                    danceGroup.getDescription(),
                    (danceGroup.getBranch() != null ? danceGroup.getBranch().getCoordinates() : null),
                    (teacherReplacement != null ? teacherReplacement.getTeacherReplace() != null 
                    ? teacherReplacement.getTeacherReplace().getId() : 0 : 0),
                    (teacherReplacement != null ? teacherReplacement.getTeacherReplace() != null 
                    ? teacherReplacement.getTeacherReplace().getName() : null : null),
                    teacherPosterSrc
                )
            )
        );
        
        return jsonAnswerStatus;
    }




    public DanceGroup add(DanceGroupNewDTO danceGroupNewDTO)
    {
        if (danceGroupNewDTO.getName() == null) return null;
        DanceGroup danceGroup = this.add(danceGroupNewDTO.getName());
        return danceGroup;
    }

    public boolean delete(int id)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id);
        if (danceGroup == null) return false;

        return danceGroupService.delete(danceGroup);
    }

    public ArrayList<DanceGroup> listAllForUser(User user, boolean isForApp)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        List<DanceGroup> danceGroups = (isForApp ? danceGroupService.listAllActiveForApp() : danceGroupService.listAllActive());
        ConnectionUserToDanceGroupService connectionUserToDanceGroupService = new ConnectionUserToDanceGroupService();
        ArrayList<DanceGroup> danceGroupsAnswer = new ArrayList<DanceGroup>();
        for (DanceGroup danceGroup : danceGroups)
        {
            if(danceGroup.getStatusOfCreative() == 1)
            {
                if(connectionUserToDanceGroupService.isAnyByUserAndDanceGroup(user, danceGroup)) 
                	if (!danceGroupsAnswer.contains(danceGroup)) danceGroupsAnswer.add(danceGroup);
            } else
            {
                if (!danceGroupsAnswer.contains(danceGroup)) danceGroupsAnswer.add(danceGroup);
            }
        }
        return danceGroupsAnswer;
    }


    public JsonAnswerStatus update(DanceGroupEditByColumnDTO danceGroupEditByColumnDTO)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(danceGroupEditByColumnDTO.getId_of_dance_group());
        if (danceGroup == null) return new JsonAnswerStatus("error", "not_found");

        Teacher teacher = null;
        if (danceGroupEditByColumnDTO.getName() == "teacher")
        {
            TeacherService teacherService = new TeacherService();
            teacher = teacherService.findById(Integer.parseInt(danceGroupEditByColumnDTO.getValue()));
        }
        Branch branch = null;
        if (danceGroupEditByColumnDTO.getName() == "branch")
        {
            BranchService branchService = new BranchService();
            branch = branchService.findById(Integer.parseInt(danceGroupEditByColumnDTO.getValue()));
        }

        if(!this.updateByColumn(danceGroup, danceGroupEditByColumnDTO.getName(), danceGroupEditByColumnDTO.getValue(), teacher, branch))
        	return new JsonAnswerStatus("error", "try_update");

        return new JsonAnswerStatus("success");
    }
    

    public boolean updateByColumn(DanceGroup danceGroup, String name, String value, Teacher teacher, Branch branch)
    {
        switch (name)
        {
            case "name":
            	danceGroup.setName(value);
                break;
            case "description":
            	danceGroup.setDescription(value);
                break;
            case "status":
            	danceGroup.setStatus(Integer.parseInt(value));
                break;
            case "isCreative":
            	danceGroup.setStatusOfCreative(Integer.parseInt(value));
                break;
            case "statusOfApp":
                danceGroup.setStatusForApp(Integer.parseInt(value));
                break;
            case "isAbonementsAllowAll":
                danceGroup.setIsAbonementsAllowAll(Integer.parseInt(value));
                break;
            case "isActiveReservation":
                danceGroup.setIsActiveReservation(Integer.parseInt(value));
                break;
            case "isEvent":
                danceGroup.setIsEvent(Integer.parseInt(value));
                break;
            case "teacher":
                danceGroup.setTeacher(teacher);
                break;
            case "branch":
                danceGroup.setBranch(branch);
                break;
            default:
                break;
        }

        return danceGroupService.update(danceGroup);
    }
}
