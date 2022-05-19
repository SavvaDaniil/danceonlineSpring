package com.dancestudioSpring.Facade;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;
import com.dancestudioSpring.Service.DanceGroupDayOfWeekService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.DanceGroupDayOfWeek.DanceGroupDayOfWeekLiteViewModel;

@Component
public class DanceGroupDayOfWeekFacade {

	@Autowired
	DanceGroupDayOfWeekService danceGroupDayOfWeekService;
	
	public DanceGroupDayOfWeek add(DanceGroup danceGroup, boolean isEvent) {
		Date dateOfAdd = new Date();
		DanceGroupDayOfWeek danceGroupDayOfWeek = new DanceGroupDayOfWeek();
		danceGroupDayOfWeek.setDanceGroup(danceGroup);
		danceGroupDayOfWeek.setDateOfAdd(dateOfAdd);
		danceGroupDayOfWeek.setDateOfUpdate(dateOfAdd);
		danceGroupDayOfWeek.setIsEvent(isEvent ? 1 : 0);
		
		if(isEvent) {
			danceGroupDayOfWeek.setDateOfEvent(dateOfAdd);
			Calendar cal = Calendar.getInstance();
		    cal.setTime(dateOfAdd);
			danceGroupDayOfWeek.setDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
		}
		
		danceGroupDayOfWeek = danceGroupDayOfWeekService.add(danceGroupDayOfWeek);
		return danceGroupDayOfWeek;
	}
	

    public ArrayList<DanceGroupDayOfWeekLiteViewModel> listAllLiteByIdOfDanceGroup(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;

        return listAllLiteByDanceGroup(danceGroup);
    }

    public ArrayList<DanceGroupDayOfWeekLiteViewModel> listAllLiteByDanceGroup(DanceGroup danceGroup)
    {
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAllByDanceGroup(danceGroup);
        ArrayList<DanceGroupDayOfWeekLiteViewModel> danceGroupDayOfWeekLiteViewModels = new ArrayList<DanceGroupDayOfWeekLiteViewModel>();
        for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
        {
            danceGroupDayOfWeekLiteViewModels.add(
                new DanceGroupDayOfWeekLiteViewModel(
                    danceGroupDayOfWeek.getId(),
                    danceGroupDayOfWeek.getDayOfWeek(),
                    getDayOfWeekByDateTimeDayOfWeek(danceGroupDayOfWeek.getDayOfWeek()),
                    danceGroupDayOfWeek.getStatus(),
                    danceGroupDayOfWeek.getTimeFrom(),
                    danceGroupDayOfWeek.getTimeTo(),
                    danceGroupDayOfWeek.getIsEvent(),
                    danceGroupDayOfWeek.getDateOfEvent()
                )
            );
        }

        return danceGroupDayOfWeekLiteViewModels;
    }

    public ArrayList<Integer> listAllDaysOfWeekOfDanceGroup(DanceGroup danceGroup)
    {
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        List<DanceGroupDayOfWeek> danceGroupDayOfWeeks = danceGroupDayOfWeekService.listAllByDanceGroup(danceGroup);
        ArrayList<Integer> daysOfWeekOfDanceGroup = new ArrayList<Integer>();
        for (DanceGroupDayOfWeek danceGroupDayOfWeek : danceGroupDayOfWeeks)
        {
            if (!daysOfWeekOfDanceGroup.contains(danceGroupDayOfWeek.getDayOfWeek())) daysOfWeekOfDanceGroup.add(danceGroupDayOfWeek.getDayOfWeek());
        }
        return daysOfWeekOfDanceGroup;
    }

    public String getDayOfWeekByDateTimeDayOfWeek(int dayOfWeek)
    {
        if (dayOfWeek > 6) return null;
        String[] daysOfWeek = new String[] { "Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота" };
        return daysOfWeek[dayOfWeek];
    }



    public DanceGroupDayOfWeek add(int id_of_dance_group, int isEvent)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;
        DanceGroupDayOfWeek danceGroupDayOfWeek = this.add(danceGroup, (isEvent == 1));
        return danceGroupDayOfWeek;
    }

    public boolean delete(int id)
    {
        DanceGroupDayOfWeekService danceGroupDayOfWeekService = new DanceGroupDayOfWeekService();
        DanceGroupDayOfWeek danceGroupDayOfWeek = danceGroupDayOfWeekService.findById(id);
        if (danceGroupDayOfWeek == null) return false;

        return danceGroupDayOfWeekService.delete(danceGroupDayOfWeek);
    }

    public JsonAnswerStatus update(int id_of_dance_group_day_of_week, String name, int value, String dateData, Time time)
    {
        DanceGroupDayOfWeek danceGroupDayOfWeek = danceGroupDayOfWeekService.findById(id_of_dance_group_day_of_week);
        if (danceGroupDayOfWeek == null) return new JsonAnswerStatus("error", "not_found");

        switch (name)
        {
            case "status":
                danceGroupDayOfWeek.setStatus(value);
                break;
            case "dayOfWeek":

            	try {
    	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	            Date dateOfEventNew = formatter.parse(dateData);
    	            Calendar cal = Calendar.getInstance();
    	            cal.setTime(dateOfEventNew);
    	            danceGroupDayOfWeek.setDayOfWeek(cal.get((Calendar.DAY_OF_WEEK)));
    	            
            	} catch(ParseException ex) {
            		ex.printStackTrace();
            		return new JsonAnswerStatus("error", "wrong_date");
            	}
            	
                break;
            case "dateOfEvent":

            	try {
    	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	            Date dateOfEventNew = formatter.parse(dateData);
    	            danceGroupDayOfWeek.setDateOfEvent(dateOfEventNew);
    	            
            	} catch(ParseException ex) {
            		ex.printStackTrace();
            		return new JsonAnswerStatus("error", "wrong_date");
            	}
            	
                break;
            case "timeFrom":
                danceGroupDayOfWeek.setTimeFrom(time);
                break;
            case "timeTo":
                danceGroupDayOfWeek.setTimeTo(time);
                break;
            default:
                break;
        }
        
        
       if(!danceGroupDayOfWeekService.update(danceGroupDayOfWeek))return new JsonAnswerStatus("error", "try_save");

        return new JsonAnswerStatus("success", null);
    }


    @SuppressWarnings("deprecation")
	public String getTimeFromTimeTo(DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        if (danceGroupDayOfWeek.getTimeFrom() == null || danceGroupDayOfWeek.getTimeTo() == null) return null;
        return danceGroupDayOfWeek.getTimeFrom().getHours()
        		+ ":" + danceGroupDayOfWeek.getTimeFrom().getMinutes() 
        		+" - " + danceGroupDayOfWeek.getTimeTo().getHours()
        		+ ":" + danceGroupDayOfWeek.getTimeTo().getMinutes();
    }

    @SuppressWarnings("deprecation")
	public String getTimeFrom(DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        if (danceGroupDayOfWeek.getTimeFrom() == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append(danceGroupDayOfWeek.getTimeFrom().getHours());
        sb.append(":");
        sb.append(danceGroupDayOfWeek.getTimeFrom().getMinutes());
		return sb.toString();
    }

    @SuppressWarnings("deprecation")
    public String getTimeTo(DanceGroupDayOfWeek danceGroupDayOfWeek)
    {
        if (danceGroupDayOfWeek.getTimeTo() == null) return null;
        if (danceGroupDayOfWeek.getTimeTo() == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append(danceGroupDayOfWeek.getTimeTo().getHours());
        sb.append(":");
        sb.append(danceGroupDayOfWeek.getTimeTo().getMinutes());
		return sb.toString();
    }
	
}
