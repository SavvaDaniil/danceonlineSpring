package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionDanceGroupToUserAdmin.ConnectionDanceGroupToUserAdminUpdateDTO;
import com.dancestudioSpring.Entity.ConnectionDanceGroupToUserAdmin;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.ConnectionDanceGroupToUserAdminService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.UserService;

@Component
public class ConnectionDanceGroupToUserAdminFacade {

	@Autowired
	ConnectionDanceGroupToUserAdminService connectionDanceGroupToUserAdminService;
	
	public ConnectionDanceGroupToUserAdmin add(DanceGroup danceGroup, User user) {
		ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = new ConnectionDanceGroupToUserAdmin();
		connectionDanceGroupToUserAdmin.setDanceGroup(danceGroup);
		connectionDanceGroupToUserAdmin.setUser(user);
		connectionDanceGroupToUserAdmin.setDateOfAdd(new Date());
		connectionDanceGroupToUserAdmin = connectionDanceGroupToUserAdminService.add(connectionDanceGroupToUserAdmin);
		return connectionDanceGroupToUserAdmin;
	}

    public ArrayList<Integer> listAllConnectedIdOfDanceGroupsByIdOfUser(int id_of_user)
    {
        UserService userService = new UserService();
        User user = userService.findById(id_of_user);
        if (user == null) return null;

        return listAllConnectedIdOfDanceGroupsByUser(user);
    }

    public ArrayList<Integer> listAllConnectedIdOfDanceGroupsByUser(User user)
    {
        List<ConnectionDanceGroupToUserAdmin> connectionDanceGroupToUserAdmins = connectionDanceGroupToUserAdminService.listAllByUser(user);
        ArrayList<Integer> listAllConnectedIdOfDanceGroupsByUser = new ArrayList<Integer>();
        for (ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin : connectionDanceGroupToUserAdmins)
        {
            if (connectionDanceGroupToUserAdmin.getDanceGroup() == null) continue;
            listAllConnectedIdOfDanceGroupsByUser.add(connectionDanceGroupToUserAdmin.getDanceGroup().getId());
        }

        return listAllConnectedIdOfDanceGroupsByUser;
    }

    public HashSet<Integer> hashOfAllConnectedIdOfDanceGroupsByUser(User user)
    {
        List<ConnectionDanceGroupToUserAdmin> connectionDanceGroupToUserAdmins = connectionDanceGroupToUserAdminService.listAllByUser(user);
        HashSet<Integer> hashOfAllConnectedIdOfDanceGroupsByUser = new HashSet<Integer>();
        for (ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin : connectionDanceGroupToUserAdmins)
        {
            hashOfAllConnectedIdOfDanceGroupsByUser.add(connectionDanceGroupToUserAdmin.getDanceGroup().getId());
        }

        return hashOfAllConnectedIdOfDanceGroupsByUser;
    }

    public boolean isUserAdminConnectedToDanceGroup(User user, DanceGroup danceGroup)
    {
        ConnectionDanceGroupToUserAdminService connectionDanceGroupToUserAdminService = new ConnectionDanceGroupToUserAdminService();
        return connectionDanceGroupToUserAdminService.isAnyByUserAndDanceGroup(user, danceGroup);
    }


    public boolean update(ConnectionDanceGroupToUserAdminUpdateDTO connectionDanceGroupToUserAdminUpdateDTO)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(connectionDanceGroupToUserAdminUpdateDTO.getId_of_dance_group());
        if (danceGroup == null) return false;

        UserService userService = new UserService();
        User user = userService.findById(connectionDanceGroupToUserAdminUpdateDTO.getId_of_user());
        if (user == null) return false;

        if (connectionDanceGroupToUserAdminUpdateDTO.getStatus() == 1)
        {
            ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = this.add(danceGroup, user);
            if (connectionDanceGroupToUserAdmin != null) return true;
        }
        else if (connectionDanceGroupToUserAdminUpdateDTO.getStatus() == 0)
        {
            if (connectionDanceGroupToUserAdminService.delete(danceGroup, user)) return true;
        }

        return false;
    }

    public boolean delete(int id)
    {
        ConnectionDanceGroupToUserAdminService connectionDanceGroupToUserAdminService = new ConnectionDanceGroupToUserAdminService();
        ConnectionDanceGroupToUserAdmin connectionDanceGroupToUserAdmin = connectionDanceGroupToUserAdminService.findById(id);
        if (connectionDanceGroupToUserAdmin == null) return false;

        return connectionDanceGroupToUserAdminService.delete(connectionDanceGroupToUserAdmin);
    }
}
