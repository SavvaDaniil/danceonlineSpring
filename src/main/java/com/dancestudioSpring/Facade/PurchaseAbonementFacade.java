package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementAnalyticsDTO;
import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementDTO;
import com.dancestudioSpring.DTO.PurchaseAbonement.PurchaseAbonementNewDTO;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.AbonementDynamicDateMustBeUsedTo;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.PurchaseAbonement;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.AbonementDynamicDateMustBeUsedToService;
import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.Service.ConnectionUserToDanceGroupService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.PurchaseAbonementService;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.Service.VisitService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementEditViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementStatistikLiteViewModel;

@Component
public class PurchaseAbonementFacade {

	@Autowired
	PurchaseAbonementService purchaseAbonementService;
	
	public PurchaseAbonement add(User user, Abonement abonement, int price, int cashless, int visits, int days, String comment, String dateOfBuyStr) {
		PurchaseAbonement purchaseAbonement = new PurchaseAbonement();
		
		purchaseAbonement.setUser(user);
		purchaseAbonement.setAbonement(abonement);
		purchaseAbonement.setPrice(price);
		purchaseAbonement.setCashless(cashless);
		purchaseAbonement.setVisits(visits);
		purchaseAbonement.setVisitsLeft(visits);
		purchaseAbonement.setDays(days);
		purchaseAbonement.setComment(comment);
		purchaseAbonement.setSpecialStatus(abonement.getSpecialStatus());
		purchaseAbonement.setIsTrial(abonement.getIsTrial());
		
		Date dateOfAdd = new Date();
		purchaseAbonement.setDateOfAdd(dateOfAdd);
		
		Date dateOfBuy = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBuy = formatter.parse(dateOfBuyStr);
            
    	} catch(ParseException ex) {
    		ex.printStackTrace();
    		return null;
    	}
    	purchaseAbonement.setDateOfBuy(dateOfBuy);
    	
    	purchaseAbonement = purchaseAbonementService.add(purchaseAbonement);
		return purchaseAbonement;
	}
	
	
	
	
    
    ...


    
    
    private PurchaseAbonement activate(PurchaseAbonement purchaseAbonement, Date dateOfActivation) {
    	purchaseAbonement.setDateOfActivation(dateOfActivation);
    	
    	Calendar calDateOfMustBeUsedTo = Calendar.getInstance();
    	calDateOfMustBeUsedTo.setTime(dateOfActivation);
    	calDateOfMustBeUsedTo.add(Calendar.DAY_OF_MONTH, (purchaseAbonement.getDays() - 1));
    	purchaseAbonement.setDateOfMustBeUsedTo(calDateOfMustBeUsedTo.getTime());

    	if(!purchaseAbonementService.update(purchaseAbonement))return null;
    	return purchaseAbonement;
    }
    
    private PurchaseAbonement deactivate(PurchaseAbonement purchaseAbonement) {
    	purchaseAbonement.setDateOfActivation(null);
    	purchaseAbonement.setDateOfMustBeUsedTo(null);

    	if(!purchaseAbonementService.update(purchaseAbonement))return null;
    	return purchaseAbonement;
    }

    public boolean returnVisit(PurchaseAbonement purchaseAbonement, boolean isReturnByAdmin)
    {
    	purchaseAbonement.setVisitsLeft(purchaseAbonement.getVisitsLeft() + 1);
    	if(purchaseAbonement.getVisitsLeft() == purchaseAbonement.getVisits() && purchaseAbonement.getDateOfActivation() != null) {
    		purchaseAbonement = this.deactivate(purchaseAbonement);
    	}
    	if (purchaseAbonement == null) return false;
        if (!purchaseAbonementService.update(purchaseAbonement)) return false;

        if(isReturnByAdmin && purchaseAbonement.getVisitsLeft() == purchaseAbonement.getVisits() 
        		&& purchaseAbonement.getDateOfActivation() == null && purchaseAbonement.getAbonement() != null)
        {
            if (purchaseAbonement.getAbonement().getSpecialStatus() == "raz") purchaseAbonementService.delete(purchaseAbonement);
        }
        return true;
    }
	
    
}
