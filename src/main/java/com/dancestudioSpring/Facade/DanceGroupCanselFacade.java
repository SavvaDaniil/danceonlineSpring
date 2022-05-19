package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.DanceGroupCansel;
import com.dancestudioSpring.Service.DanceGroupCanselService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroupCansel.DanceGroupCanselLiteViewModel;

@Component
public class DanceGroupCanselFacade {

	@Autowired
	DanceGroupCanselService danceGroupCanselService;
	
	public DanceGroupCansel add() {
		DanceGroupCansel danceGroupCansel = new DanceGroupCansel();
		Date dateOfAdd = new Date();
		
		//danceGroupCansel.setDanceGroup(danceGroup);
		danceGroupCansel.setDateFrom(dateOfAdd);
		danceGroupCansel.setDateTo(dateOfAdd);
		
		danceGroupCansel.setDateOfAdd(dateOfAdd);
		danceGroupCansel.setDateOfUpdate(dateOfAdd);
		
		danceGroupCansel = danceGroupCanselService.add(danceGroupCansel);
		return danceGroupCansel;
	}
	
	/*
    public DanceGroupCansel add(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;
        return this.add(danceGroup);
    }
    */
	
	

    public ArrayList<DanceGroupCanselLiteViewModel> listAllLiteByIdOfDanceGroup(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;
        return listAllLiteByDanceGroup(danceGroup);
    }

    public JsonAnswerStatus listAllForEdit()
    {
        DanceGroupFacade danceGroupFacade = new DanceGroupFacade();
        List<DanceGroupLiteViewModel> danceGroupLiteViewModels = danceGroupFacade.listAllLite();

        DanceGroupCanselService danceGroupCanselService = new DanceGroupCanselService();
        List<DanceGroupCansel> danceGroupCansels = danceGroupCanselService.listAll();

        ArrayList<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = new ArrayList<DanceGroupCanselLiteViewModel>();

        for (DanceGroupCansel danceGroupCansel : danceGroupCansels)
        {
            danceGroupCanselLiteViewModels.add(
                new DanceGroupCanselLiteViewModel(
                    danceGroupCansel.getId(),
                    (danceGroupCansel.getDanceGroup() != null ? danceGroupCansel.getDanceGroup().getId() : 0),
                    danceGroupCansel.getStatus(),
                    danceGroupCansel.getDateFrom(),
                    danceGroupCansel.getDateTo()
                )
            );
        }

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setDanceGroupLiteViewModels(danceGroupLiteViewModels);
        jsonAnswerStatus.setDanceGroupCanselLiteViewModels(danceGroupCanselLiteViewModels);
        
        return jsonAnswerStatus;
    }

    public ArrayList<DanceGroupCanselLiteViewModel> listAllLiteByDanceGroup(DanceGroup danceGroup)
    {
        DanceGroupCanselService danceGroupCanselService = new DanceGroupCanselService();
        List<DanceGroupCansel> danceGroupCansels = danceGroupCanselService.listAllByDanceGroup(danceGroup);

        ArrayList<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = new ArrayList<DanceGroupCanselLiteViewModel>();

        for (DanceGroupCansel danceGroupCansel : danceGroupCansels)
        {
            danceGroupCanselLiteViewModels.add(
                new DanceGroupCanselLiteViewModel(
                    danceGroupCansel.getId(),
                    danceGroup.getId(),
                    danceGroupCansel.getStatus(),
                    danceGroupCansel.getDateFrom(),
                    danceGroupCansel.getDateTo()
                )
            );
        }

        return danceGroupCanselLiteViewModels;
    }

    public ArrayList<DanceGroupCanselLiteViewModel> listAllActiveByDate(Date dateFrom, Date dateTo)
    {
        DanceGroupCanselService danceGroupCanselService = new DanceGroupCanselService();
        List<DanceGroupCansel> danceGroupCansels = danceGroupCanselService.listAllByDate(dateFrom, dateTo, true);

        ArrayList<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels = new ArrayList<DanceGroupCanselLiteViewModel>();

        for (DanceGroupCansel danceGroupCansel : danceGroupCansels)
        {
            danceGroupCanselLiteViewModels.add(
                new DanceGroupCanselLiteViewModel(
                    danceGroupCansel.getId(),
                    (danceGroupCansel.getDanceGroup() != null ? danceGroupCansel.getDanceGroup().getId() : 0),
                    danceGroupCansel.getStatus(),
                    danceGroupCansel.getDateFrom(),
                    danceGroupCansel.getDateTo()
                )
            );
        }

        return danceGroupCanselLiteViewModels;
    }



    public boolean delete(int id)
    {
        DanceGroupCanselService danceGroupCanselService = new DanceGroupCanselService();
        DanceGroupCansel danceGroupCansel = danceGroupCanselService.findById(id);
        if (danceGroupCansel == null) return false;
        return danceGroupCanselService.delete(danceGroupCansel);
    }

    public JsonAnswerStatus update(int id_of_dance_group_cansel, String name, int value, String date_of_day)
    {
        DanceGroupCansel danceGroupCansel = danceGroupCanselService.findById(id_of_dance_group_cansel);
        if (danceGroupCansel == null) return new JsonAnswerStatus("error", "not_found");

        if (name == "status")
        {
        	if (value != 0 && value != 1) value = 0;
        	danceGroupCansel.setStatus(value);
        	if(!danceGroupCanselService.update(danceGroupCansel))return new JsonAnswerStatus("error", "when_try_to_update");
        	
        }
        else if (name == "id_of_dance_group")
        {
            if(value == 0)
            {
            	danceGroupCansel.setDanceGroup(null);
            	if(!danceGroupCanselService.update(danceGroupCansel))return new JsonAnswerStatus("error", "when_try_to_update");
            } else {
            
	            DanceGroupService danceGroupService = new DanceGroupService();
	            DanceGroup danceGroup = danceGroupService.findById(value);
	            if (danceGroup == null && value != 0) return new JsonAnswerStatus("error", "not_found_dance_group");
	            
	            danceGroupCansel.setDanceGroup(danceGroup);
            	if(!danceGroupCanselService.update(danceGroupCansel))return new JsonAnswerStatus("error", "when_try_to_update");
            }
        }
        else if (name == "dateFrom" || name == "dateTo")
        {

        	Date dateNew = new Date();
        	try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                dateNew = formatter.parse(date_of_day);
                
        	} catch(ParseException ex) {
        		ex.printStackTrace();
                return new JsonAnswerStatus("error", "when_try_change_date");
        	}
        	
        	switch(name) {
	        	case "dateFrom":
	        		danceGroupCansel.setDateFrom(dateNew);
	        		break;
	        	case "dateTo":
	        		danceGroupCansel.setDateTo(dateNew);
	        		break;
        		default:
        			break;
        	}

        	if(!danceGroupCanselService.update(danceGroupCansel))return new JsonAnswerStatus("error", "when_try_to_update");
        	
        }

        if(danceGroupCansel.getStatus() == 1)
        {
            //нужно отменить все занятия для данной группы в данную дату

        }

        return new JsonAnswerStatus("success", null);
    }
}
