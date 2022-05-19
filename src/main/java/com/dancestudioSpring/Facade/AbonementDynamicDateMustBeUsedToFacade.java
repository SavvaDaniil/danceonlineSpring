package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Entity.AbonementDynamicDateMustBeUsedTo;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Service.AbonementDynamicDateMustBeUsedToService;
import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.AbonementDynamicDateMustBeUsedTo.AbonementDynamicDateMustBeUsedToLiteViewModel;

@Component
public class AbonementDynamicDateMustBeUsedToFacade {

	@Autowired
	AbonementDynamicDateMustBeUsedToService abonementDynamicDateMustBeUsedToService;
	
	
    public ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> listAllLiteByIdOfAbonement(int id_of_abonement)
    {
        AbonementService abonementService = new AbonementService();
        Abonement abonement = abonementService.findById(id_of_abonement);
        if (abonement == null) return null;
        return listAllLiteByAbonement(abonement);
    }

    public ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> listAllLiteByAbonement(Abonement abonement)
    {
        List<AbonementDynamicDateMustBeUsedTo> abonementDynamicDatesMustBeUsedTo = 
        		abonementDynamicDateMustBeUsedToService.listAllByAbonement(abonement, false);

        ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel> abonementDynamicDateMustBeUsedToLiteViewModels = 
        		new ArrayList<AbonementDynamicDateMustBeUsedToLiteViewModel>();

        Date dateNow = new Date();
        for (AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo : abonementDynamicDatesMustBeUsedTo)
        {

            abonementDynamicDateMustBeUsedToLiteViewModels.add(
                new AbonementDynamicDateMustBeUsedToLiteViewModel(
                    abonementDynamicDateMustBeUsedTo.getId(),
                    abonementDynamicDateMustBeUsedTo.getStatus(),
                    (abonementDynamicDateMustBeUsedTo.getDateFrom() == null ? dateNow : abonementDynamicDateMustBeUsedTo.getDateFrom()),
                    (abonementDynamicDateMustBeUsedTo.getDateTo() == null ? dateNow : abonementDynamicDateMustBeUsedTo.getDateTo()),
                    (abonementDynamicDateMustBeUsedTo.getDateUsedTo() == null ? dateNow : abonementDynamicDateMustBeUsedTo.getDateUsedTo())
                )    
            );

        }

        return abonementDynamicDateMustBeUsedToLiteViewModels;
    }
	

    public AbonementDynamicDateMustBeUsedTo add(int id_of_abonement)
    {
        AbonementService abonementService = new AbonementService();
        Abonement abonement = abonementService.findById(id_of_abonement);
        if (abonement == null) return null;
        
        Date dateOfAdd = new Date();
        
        AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo = new AbonementDynamicDateMustBeUsedTo();
        abonementDynamicDateMustBeUsedTo.setAbonement(abonement);
        abonementDynamicDateMustBeUsedTo.setDateOfAdd(dateOfAdd);
        abonementDynamicDateMustBeUsedTo.setDateOfUpdate(dateOfAdd);
        
        abonementDynamicDateMustBeUsedTo.setDateFrom(dateOfAdd);
        abonementDynamicDateMustBeUsedTo.setDateTo(dateOfAdd);
        abonementDynamicDateMustBeUsedTo.setDateUsedTo(dateOfAdd);
        
        return abonementDynamicDateMustBeUsedToService.add(abonementDynamicDateMustBeUsedTo);
    }

    public boolean delete(int id)
    {
        return abonementDynamicDateMustBeUsedToService.delete(id);
    }

    public JsonAnswerStatus update(int id_of_abonement_dynamic_date_be_must_used_to, String name, int value, String dateData)
    {
        AbonementDynamicDateMustBeUsedTo abonementDynamicDateMustBeUsedTo = 
            abonementDynamicDateMustBeUsedToService.findById(id_of_abonement_dynamic_date_be_must_used_to);
        if (abonementDynamicDateMustBeUsedTo == null) return new JsonAnswerStatus("error", "not_found");

        if (name == "status")
        {
        	if(value != 0 && value != 1)value = 0;
        	abonementDynamicDateMustBeUsedTo.setStatus(value);
        	
            if (abonementDynamicDateMustBeUsedToService.update(abonementDynamicDateMustBeUsedTo))return new JsonAnswerStatus("success", null);
            
        } else if((name == "dateFrom"
            || name == "dateTo"
            || name == "dateUsedTo"))
        {
        	try {
	            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date dateNew = formatter.parse(dateData);
	            switch(name) {
	            	case "dateFrom":
	            		abonementDynamicDateMustBeUsedTo.setDateFrom(dateNew);
	            		break;
	            	case "dateTo":
	            		abonementDynamicDateMustBeUsedTo.setDateTo(dateNew);
	            		break;
	            	case "dateUsedTo":
	            		abonementDynamicDateMustBeUsedTo.setDateUsedTo(dateNew);
	            		break;
	        		default:
	        			break;
	            }
	            
	            if (abonementDynamicDateMustBeUsedToService.update(abonementDynamicDateMustBeUsedTo))return new JsonAnswerStatus("success", null);
        	} catch(ParseException ex) {
        		ex.printStackTrace();
        		return new JsonAnswerStatus("error", "wrong_date");
        	}
        }

        return new JsonAnswerStatus("error", "unknown");
    }
}
