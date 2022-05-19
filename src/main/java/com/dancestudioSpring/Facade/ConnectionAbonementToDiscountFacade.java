package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionAbonementToDiscount.ConnectionAbonementToDiscountUpdateDTO;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementToDiscount;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.Service.ConnectionAbonementToDiscountService;
import com.dancestudioSpring.Service.DiscountService;

@Component
public class ConnectionAbonementToDiscountFacade {

	@Autowired
	ConnectionAbonementToDiscountService connectionAbonementToDiscountService;

	public ConnectionAbonementToDiscount add(Abonement abonement, Discount discount) {
		ConnectionAbonementToDiscount connectionAbonementToDiscount = new ConnectionAbonementToDiscount();
        connectionAbonementToDiscount.setAbonement(abonement);
        connectionAbonementToDiscount.setDiscount(discount);
        connectionAbonementToDiscount.setDateOfAdd(new Date());
        connectionAbonementToDiscount = connectionAbonementToDiscountService.add(connectionAbonementToDiscount);
        return connectionAbonementToDiscount;
	}
	
    public ArrayList<Integer> listAllConnectedIdOfAbonementsByIdOfDiscount(int id_of_discount)
    {
        DiscountService discountService = new DiscountService();
        Discount discount = discountService.findById(id_of_discount);
        if (discount == null) return null;

        return listAllConnectedIdOfAbonementsByDiscount(discount);
    }

    public ArrayList<Integer> listAllConnectedIdOfAbonementsByDiscount(Discount discount)
    {
        List<ConnectionAbonementToDiscount> connectionAbonementToDiscounts = connectionAbonementToDiscountService.listAllByDiscount(discount);
        ArrayList<Integer> listAllConnectedIdOfAbonementsByDiscount = new ArrayList<Integer>();
        for (ConnectionAbonementToDiscount connectionAbonementToDiscount : connectionAbonementToDiscounts)
        {
            if (connectionAbonementToDiscount.getAbonement() == null) continue;
            listAllConnectedIdOfAbonementsByDiscount.add(connectionAbonementToDiscount.getAbonement().getId());
        }

        return listAllConnectedIdOfAbonementsByDiscount;
    }


    ...

    public boolean delete(int id)
    {
        ConnectionAbonementToDiscount connectionAbonementToDiscount = connectionAbonementToDiscountService.findById(id);
        if (connectionAbonementToDiscount == null) return false;

        return connectionAbonementToDiscountService.delete(connectionAbonementToDiscount);
    }
}
