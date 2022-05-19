package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionDiscountToUser.ConnectionDiscountToUserUpdateDTO;
import com.dancestudioSpring.Entity.ConnectionDiscountToUser;
import com.dancestudioSpring.Entity.Discount;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.ConnectionDiscountToUserService;
import com.dancestudioSpring.Service.DiscountService;
import com.dancestudioSpring.Service.UserService;

@Component
public class ConnectionDiscountToUserFacade {

	@Autowired
	ConnectionDiscountToUserService connectionDiscountToUserService;

	public ConnectionDiscountToUser add(Discount discount, User user) {
		ConnectionDiscountToUser connectionDiscountToUser = new ConnectionDiscountToUser();
		connectionDiscountToUser.setDiscount(discount);
		connectionDiscountToUser.setUser(user);
		connectionDiscountToUser.setDateOfAdd(new Date());
		connectionDiscountToUser = connectionDiscountToUserService.add(connectionDiscountToUser);
		return connectionDiscountToUser;
	}
	
	
    public ArrayList<Integer> listAllConnectedIdOfDiscountsByIdOfUser(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        return listAllConnectedIdOfDiscountsByUser(user);
    }

    public ArrayList<Integer> listAllConnectedIdOfDiscountsByUser(User user)
    {
        ConnectionDiscountToUserService connectionDiscountToUserService = new ConnectionDiscountToUserService();
        List<ConnectionDiscountToUser> connectionDiscountToUsers = connectionDiscountToUserService.listAllByUser(user);
        ArrayList<Integer> listAllConnectedIdOfDiscountsByUser = new ArrayList<Integer>();
        for (ConnectionDiscountToUser connectionDiscountToUser : connectionDiscountToUsers)
        {
            if (connectionDiscountToUser.getDiscount() == null) continue;
            listAllConnectedIdOfDiscountsByUser.add(connectionDiscountToUser.getDiscount().getId());
        }

        return listAllConnectedIdOfDiscountsByUser;
    }

    public boolean update(ConnectionDiscountToUserUpdateDTO connectionDiscountToUserUpdateDTO)
    {
        DiscountService discountService = new DiscountService();
        Discount discount = discountService.findById(connectionDiscountToUserUpdateDTO.getId_of_discount());
        if (discount == null) return false;

        UserService userService = new UserService();
        User user = userService.findById(connectionDiscountToUserUpdateDTO.getId_of_user());
        if (user == null) return false;

        if (connectionDiscountToUserUpdateDTO.getStatus() == 1)
        {
            ConnectionDiscountToUser connectionDiscountToUser = this.add(discount, user);
            if (connectionDiscountToUser != null) return true;
        }
        else if (connectionDiscountToUserUpdateDTO.getStatus() == 0)
        {
            if (connectionDiscountToUserService.delete(discount, user)) return true;
        }

        return false;
    }

    public boolean delete(int id)
    {
        ConnectionDiscountToUserService connectionDiscountToUserService = new ConnectionDiscountToUserService();
        ConnectionDiscountToUser connectionDiscountToUser = connectionDiscountToUserService.findById(id);
        if (connectionDiscountToUser == null) return false;

        return connectionDiscountToUserService.delete(connectionDiscountToUser);
    }
}
