package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.Discount.DiscountEditByColumnDTO;
import com.dancestudioSpring.DTO.Discount.DiscountNewDTO;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.DiscountService;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.ViewModel.Discount.DiscountLiteViewModel;
import com.dancestudioSpring.ViewModel.Discount.DiscountWithConnectionToUserLiteViewModel;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Abonement.AbonementWithConnectionToDiscountLiteViewModel;
import com.dancestudioSpring.ViewModel.Discount.DiscountEditViewModel;

@Component
public class DiscountFacade {

	@Autowired
	DiscountService discountService;
	
	public Discount add(String name) {
		Discount discount = new Discount();
		discount.setName(name);
		discount.setDateOfAdd(new Date());
		discount = discountService.add(discount);
		return discount;
	}
	
    public ArrayList<DiscountLiteViewModel> listAllLite()
    {
        List<Discount> discounts = discountService.listAll();
        ArrayList<DiscountLiteViewModel> discountLiteViewModels = new ArrayList<DiscountLiteViewModel>();
        int i = 0;
        for (Discount discount : discounts)
        {
            i++;
            discountLiteViewModels.add(new DiscountLiteViewModel(i, discount.getId(), discount.getName(), discount.getDateOfAdd()));
        }

        return discountLiteViewModels;
    }

    public ArrayList<DiscountWithConnectionToUserLiteViewModel> listAllWithConnectectionToUserLite(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        List<Discount> discounts = discountService.listAll();
        ArrayList<DiscountWithConnectionToUserLiteViewModel> discountWithConnectionToUserLiteViewModels = new ArrayList<DiscountWithConnectionToUserLiteViewModel>();

        ConnectionDiscountToUserFacade connectionDiscountToUserFacade = new ConnectionDiscountToUserFacade();
        List<Integer> listAllConnectedIdOfDiscountsByUser = connectionDiscountToUserFacade.listAllConnectedIdOfDiscountsByUser(user);
        for (Discount discount : discounts)
        {
            discountWithConnectionToUserLiteViewModels.add(
                new DiscountWithConnectionToUserLiteViewModel(
                    discount.getId(),
                    discount.getName(),
                    (listAllConnectedIdOfDiscountsByUser.contains(discount.getId()) ? 1 : 0)
                )
            );
        }

        return discountWithConnectionToUserLiteViewModels;
    }


    public DiscountEditViewModel getEdit(int id)
    {
        Discount discount = discountService.findById(id);
        if (discount == null) return null;

        AbonementFacade abonementFacade = new AbonementFacade();
        ArrayList<AbonementWithConnectionToDiscountLiteViewModel> abonementWithConnectionToDiscountLiteViewModels = abonementFacade.listAllWithConnectionToDiscount(discount);

        DiscountEditViewModel discountEditViewModel = new DiscountEditViewModel(
            discount.getId(),
            discount.getName(),
            abonementWithConnectionToDiscountLiteViewModels
        );

        return discountEditViewModel;
    }

    public DiscountLiteViewModel getLiteBydId(int id)
    {
        Discount discount = discountService.findById(id);
        if (discount == null) return null;
        return new DiscountLiteViewModel(discount.getId(), discount.getName(), discount.getDateOfAdd());
    }

    public Discount add(DiscountNewDTO discountNewDTO)
    {
        if (discountNewDTO.getName() == null) return null;
        Discount discount = this.add(discountNewDTO.getName());
        return discount;
    }

    public boolean delete(int id)
    {
        Discount discount = discountService.findById(id);
        if (discount == null) return false;
        return discountService.delete(discount);
    }

    public JsonAnswerStatus update(DiscountEditByColumnDTO discountEditByColumnDTO)
    {
        Discount discount = discountService.findById(discountEditByColumnDTO.getId_of_discount());
        if (discount == null) return new JsonAnswerStatus("error", "not_found");

        if(discountEditByColumnDTO.getName() == "name")discount.setName(discountEditByColumnDTO.getValue());
        
        if(!discountService.update(discount))return new JsonAnswerStatus("error");

        return new JsonAnswerStatus("success", null);
    }
}
