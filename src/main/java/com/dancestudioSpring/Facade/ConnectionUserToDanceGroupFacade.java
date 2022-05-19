package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionUserToDanceGroup.ConnectionUserToDanceGroupUpdateDTO;
import com.dancestudioSpring.Entity.ConnectionUserToDanceGroup;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.ConnectionUserToDanceGroupService;
import com.dancestudioSpring.Service.DanceGroupService;
import com.dancestudioSpring.Service.UserService;

@Component
public class ConnectionUserToDanceGroupFacade {

	@Autowired
	ConnectionUserToDanceGroupService connectionUserToDanceGroupService;

	public ConnectionUserToDanceGroup add(DanceGroup danceGroup, User user) {
		ConnectionUserToDanceGroup connectionUserToDanceGroup = new ConnectionUserToDanceGroup();
		connectionUserToDanceGroup.setDanceGroup(danceGroup);
		connectionUserToDanceGroup.setUser(user);
		connectionUserToDanceGroup.setDateOfAdd(new Date());
		connectionUserToDanceGroup = connectionUserToDanceGroupService.add(connectionUserToDanceGroup);
		return connectionUserToDanceGroup;
	}

    ...

    public boolean delete(int id)
    {
        ConnectionUserToDanceGroupService connectionUserToDanceGroupService = new ConnectionUserToDanceGroupService();
        ConnectionUserToDanceGroup connectionUserToDanceGroup = connectionUserToDanceGroupService.findById(id);
        if (connectionUserToDanceGroup == null) return false;

        return connectionUserToDanceGroupService.delete(connectionUserToDanceGroup);
    }
}
