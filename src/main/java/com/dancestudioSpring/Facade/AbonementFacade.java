package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.Service.ConnectionAbonementToDiscountService;
import com.dancestudioSpring.Service.ConnectionUserToDanceGroupService;
import com.dancestudioSpring.Service.PurchaseAbonementService;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Abonement.AbonementEditViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementForBuyingViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteWithPrivateConnectionToUserViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementWithConnectionToDiscountLiteViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementsBySpecialStatusViewModel;
import com.dancestudioSpring.ViewModel.AbonementDynamicDateMustBeUsedTo.AbonementDynamicDateMustBeUsedToLiteViewModel;
import com.dancestudioSpring.ViewModel.User.UserLiteViewModel;
import com.dancestudioSpring.DTO.Abonement.AbonementEditByColumnDTO;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementToDiscount;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Entity.User;

@Component
public class AbonementFacade {

	@Autowired
	AbonementService abonementService;

	public ArrayList<AbonementLiteViewModel> listAllLite(boolean isOrderByName){
		
		ArrayList<Abonement> abonements = (ArrayList<Abonement>)(isOrderByName ? abonementService.listAllNotDeletedOrderByName() 
				: abonementService.listAllNotDeleted());
		ArrayList<AbonementLiteViewModel> abonementLiteViewModels = new ArrayList<AbonementLiteViewModel>();
		
        for (Abonement abonement : abonements)
        {
            abonementLiteViewModels.add(
                new AbonementLiteViewModel(
                    abonement.getId(),
                    abonement.getName(),
                    abonement.getSpecialStatus(),
                    abonement.getDays(),
                    abonement.getPrice(),
                    abonement.getVisits(),
                    abonement.getStatusOfVisible(),
                    abonement.getStatusForApp(),
                    abonement.getIsPrivate(),
                    abonement.getIsTrial()
                )
            );
        }

        return abonementLiteViewModels;
	}
	



    public ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel> listAllPrivateConnectionsToUser(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        List<Abonement> abonements = abonementService.listAll();
        ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel> abonementLiteWithPrivateConnectionToUserViewModels = new ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel>();

        ConnectionAbonementPrivateToUserFacade connectionAbonementPrivateToUserFacade = new ConnectionAbonementPrivateToUserFacade();
        List<Integer> listAllConnectedIdOfAbonementPrivatesByUser = connectionAbonementPrivateToUserFacade.listAllConnectedIdOfAbonementPrivatesByUser(user);

        for (Abonement abonement : abonements)
        {
            abonementLiteWithPrivateConnectionToUserViewModels.add(
                new AbonementLiteWithPrivateConnectionToUserViewModel(
                    abonement.getId(),
                    abonement.getName(),
                    abonement.getIsPrivate(),
                    (listAllConnectedIdOfAbonementPrivatesByUser.contains(abonement.getId()) ? 1 : 0)
                )
            );
        }

        return abonementLiteWithPrivateConnectionToUserViewModels;
    }



    private AbonementLiteViewModel getLiteFromEntity(Abonement abonement)
    {
        return new AbonementLiteViewModel(
            abonement.getId(),
            abonement.getName(),
            abonement.getSpecialStatus(),
            abonement.getDays(),
            abonement.getPrice(),
            abonement.getVisits(),
            abonement.getStatusOfVisible(),
            abonement.getStatusForApp(),
            abonement.getIsPrivate(),
            abonement.getIsTrial()
        );
    }

    public AbonementsBySpecialStatusViewModel listsAllBySpecialStatusForUserByAdmin(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        return listsAllBySpecialStatus(false, user, null);
    }

    
    ...

    public boolean delete(int id)
    {
        Abonement abonement = abonementService.findById(id);
        if (abonement == null) return false;

        //нужно сделать проверку, есть ли в базе покупки или какие-либо действия с абонементом, если есть, то фейковый статус удаления


        return abonementService.delete(abonement);
    }

    public JsonAnswerStatus update(AbonementEditByColumnDTO abonementEditByColumnDTO)
    {
        Abonement abonement = abonementService.findById(abonementEditByColumnDTO.getId_of_abonement());
        if (abonement == null) return new JsonAnswerStatus("error", "not_found");

        switch (abonementEditByColumnDTO.getName())
        {
            case "name":
                abonement.setName(abonementEditByColumnDTO.getValue());
                break;
            case "days":
                abonement.setDays(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "price":
                abonement.setPrice(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "visits":
                abonement.setVisits(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "is_private":
                abonement.setIsPrivate(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "is_trial":
                abonement.setIsTrial(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "status_of_visible":
                abonement.setStatusOfVisible(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            case "status_for_app":
                abonement.setStatusForApp(Integer.parseInt(abonementEditByColumnDTO.getValue()));
                break;
            default:
                break;
        }
        
        if(!abonementService.update(abonement)) return new JsonAnswerStatus("error", "unknown");

        return new JsonAnswerStatus("success", null);
    }
    
    
}
