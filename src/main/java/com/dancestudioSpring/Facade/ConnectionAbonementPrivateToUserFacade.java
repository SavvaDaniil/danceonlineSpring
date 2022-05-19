package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionAbonementPrivateToUser.ConnectionAbonementPrivateToUserUpdateDTO;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementPrivateToUser;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.Service.ConnectionAbonementPrivateToUserService;
import com.dancestudioSpring.Service.UserService;

@Component
public class ConnectionAbonementPrivateToUserFacade {

	@Autowired
	ConnectionAbonementPrivateToUserService connectionAbonementPrivateToUserService;
	
	public ConnectionAbonementPrivateToUser add(Abonement abonement, User user) {
		ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser = new ConnectionAbonementPrivateToUser();
		connectionAbonementPrivateToUser.setAbonement(abonement);
		connectionAbonementPrivateToUser.setUser(user);
		connectionAbonementPrivateToUser.setDateOfAdd(new Date());
		connectionAbonementPrivateToUser = connectionAbonementPrivateToUserService.add(connectionAbonementPrivateToUser);
		return connectionAbonementPrivateToUser;
	}
	
	public ArrayList<Integer> listAllConnectedIdOfAbonementPrivatesByIdOfUser(int id_of_user){
		UserService userService = new UserService();
		User user = userService.findById(id_of_user);
		if(user == null)return null;
		return this.listAllConnectedIdOfAbonementPrivatesByUser(user);
	}
	
	public ArrayList<Integer> listAllConnectedIdOfAbonementPrivatesByUser(User user){
		
		List<ConnectionAbonementPrivateToUser> connectionAbonementPrivateToUsers = connectionAbonementPrivateToUserService.listAllByUser(user);
		ArrayList<Integer> listAllConnectedIdOfAbonementPrivatesByUser = new ArrayList<Integer>();
		for(ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser : connectionAbonementPrivateToUsers) {
			if(connectionAbonementPrivateToUser.getAbonement() == null)continue;
            listAllConnectedIdOfAbonementPrivatesByUser.add(connectionAbonementPrivateToUser.getAbonement().getId());
		}
		return listAllConnectedIdOfAbonementPrivatesByUser;
	}
	

    public HashSet<Integer> hashAllConnectedIdOfAbonementPrivatesByUser(User user)
    {
        List<ConnectionAbonementPrivateToUser> connectionAbonementPrivateToUsers = connectionAbonementPrivateToUserService.listAllByUser(user);
        HashSet<Integer> hashAllConnectedIdOfAbonementPrivatesByUser = new HashSet<Integer>();
        for (ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser : connectionAbonementPrivateToUsers)
        {
            if (connectionAbonementPrivateToUser.getAbonement() == null) continue;
            hashAllConnectedIdOfAbonementPrivatesByUser.add(connectionAbonementPrivateToUser.getAbonement().getId());
        }

        return hashAllConnectedIdOfAbonementPrivatesByUser;
    }

    public boolean update(ConnectionAbonementPrivateToUserUpdateDTO connectionAbonementPrivateToUserUpdateDTO)
    {
        AbonementService abonementService = new AbonementService();
        Abonement abonement = abonementService.findById(connectionAbonementPrivateToUserUpdateDTO.getId_of_abonement());
        if (abonement == null) return false;

        UserService userService = new UserService();
        User user = userService.findById(connectionAbonementPrivateToUserUpdateDTO.getId_of_user());
        if (user == null) return false;

        ConnectionAbonementPrivateToUserService connectionAbonementPrivateToUserService = new ConnectionAbonementPrivateToUserService();
        if (connectionAbonementPrivateToUserUpdateDTO.getStatus() == 1)
        {
            ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser = this.add(abonement, user);
            if (connectionAbonementPrivateToUser != null) return true;
        }
        else if (connectionAbonementPrivateToUserUpdateDTO.getStatus() == 0)
        {
            if (connectionAbonementPrivateToUserService.delete(connectionAbonementPrivateToUserService.findByAbonementPrivateAndUser(abonement, user))) return true;
        }

        return false;
    }

    public boolean delete(int id)
    {
        ConnectionAbonementPrivateToUser connectionAbonementPrivateToUser = connectionAbonementPrivateToUserService.findById(id);
        if (connectionAbonementPrivateToUser == null) return false;
        return connectionAbonementPrivateToUserService.delete(connectionAbonementPrivateToUser);
    }
}
