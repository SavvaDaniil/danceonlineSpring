package com.dancestudioSpring.Facade;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupEventDate;
import com.dancestudioSpring.Service.DanceGroupEventDateService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.DanceGroupEventDate.DanceGroupEventDateLiteViewModel;

@Component
public class DanceGroupEventDateFacade {

	@Autowired
	DanceGroupEventDateService danceGroupEventDateService;

	
    public DanceGroupEventDate add(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;
        return this.add(danceGroup);
    }
    
	public DanceGroupEventDate add(DanceGroup danceGroup) {
		DanceGroupEventDate danceGroupEventDate = new DanceGroupEventDate();
		danceGroupEventDate.setDanceGroup(danceGroup);
		
		Date dateOfAdd = new Date();
		danceGroupEventDate.setDateOfEvent(dateOfAdd);
		
		danceGroupEventDate.setDateOfAdd(dateOfAdd);
		danceGroupEventDate.setDateOfUpdate(dateOfAdd);
		
		danceGroupEventDate = danceGroupEventDateService.add(danceGroupEventDate);
		return danceGroupEventDate;
	}
	

    public ArrayList<DanceGroupEventDateLiteViewModel> listAllLiteByIdOfDanceGroup(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;
        return listAllLiteByDanceGroup(danceGroup, false);
    }


    public ArrayList<DanceGroupEventDateLiteViewModel> listAllLiteByDanceGroup(DanceGroup danceGroup, boolean isOnlyActive)
    {
        ArrayList<DanceGroupEventDate> danceGroupEventDates = (
            isOnlyActive 
            ? (ArrayList<DanceGroupEventDate>)danceGroupEventDateService.listAllActiveByDanceGroup(danceGroup) 
            : (ArrayList<DanceGroupEventDate>)danceGroupEventDateService.listAllByDanceGroup(danceGroup)
        );

        ArrayList<DanceGroupEventDateLiteViewModel> danceGroupEventDateLiteViewModels = new ArrayList<DanceGroupEventDateLiteViewModel>();

        for (DanceGroupEventDate danceGroupEventDate : danceGroupEventDates)
        {
            danceGroupEventDateLiteViewModels.add(toLiteViewModel(danceGroupEventDate));
        }

        return danceGroupEventDateLiteViewModels;
    }

    public ArrayList<DanceGroupEventDateLiteViewModel> ArrayListAllActiveLiteByDates(Date dateFrom, Date dateTo)
    {
        ArrayList<DanceGroupEventDate> danceGroupEventDates = 
        		(ArrayList<DanceGroupEventDate>)danceGroupEventDateService.listAllActiveByDates(dateFrom, dateTo);

        ArrayList<DanceGroupEventDateLiteViewModel> danceGroupEventDateLiteViewModels = new ArrayList<DanceGroupEventDateLiteViewModel>();

        for (DanceGroupEventDate danceGroupEventDate : danceGroupEventDates)
        {
            danceGroupEventDateLiteViewModels.add(toLiteViewModel(danceGroupEventDate));
        }

        return danceGroupEventDateLiteViewModels;
    }



    public boolean delete(int id)
    {
        DanceGroupEventDate danceGroupEventDate = danceGroupEventDateService.findById(id);
        if (danceGroupEventDate == null) return false;
        return danceGroupEventDateService.delete(danceGroupEventDate);
    }

    public JsonAnswerStatus update(int id_of_dance_group_event_date, String name, int value, String dateData, Time time)
    {
        DanceGroupEventDate danceGroupEventDate =
            danceGroupEventDateService.findById(id_of_dance_group_event_date);
        if (danceGroupEventDate == null) return new JsonAnswerStatus("error", "not_found");

        if (name == "active")
        {
        	danceGroupEventDate.setActive(value);
        	if(danceGroupEventDateService.update(danceGroupEventDate))return new JsonAnswerStatus("success");
        }
        else if (name == "dateOfEvent")
        {
            Date dateOfEventNew = new Date();

        	try {
	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            dateOfEventNew = formatter.parse(dateData);
	            danceGroupEventDate.setDateOfEvent(dateOfEventNew);
	            
	        	if(danceGroupEventDateService.update(danceGroupEventDate))return new JsonAnswerStatus("success");
	        	
        	} catch(ParseException ex) {
        		ex.printStackTrace();
        		return new JsonAnswerStatus("error", "wrong_date");
        	}
            
        }
        else if (name == "timeFrom" || name == "timeTo")
        {

            switch (name)
            {
                case "timeFrom":
                    danceGroupEventDate.setTimeFrom(time);
                    break;
                case "timeTo":
                    danceGroupEventDate.setTimeTo(time);
                    break;
                default:
                    break;
            }
            
        	if(danceGroupEventDateService.update(danceGroupEventDate))return new JsonAnswerStatus("success");
        }

        return new JsonAnswerStatus("error", "unknown");
    }

    private DanceGroupEventDateLiteViewModel toLiteViewModel(DanceGroupEventDate danceGroupEventDate)
    {
        return new DanceGroupEventDateLiteViewModel(
            danceGroupEventDate.getId(),
            (danceGroupEventDate.getDanceGroup() != null ? danceGroupEventDate.getDanceGroup().getId() : 0),
            danceGroupEventDate.getActive(),
            danceGroupEventDate.getTimeFrom(),
            danceGroupEventDate.getTimeTo(),
            danceGroupEventDate.getDateOfEvent()
        );
    }
}
