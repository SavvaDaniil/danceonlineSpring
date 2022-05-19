package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.DTO.ConnectionAbonementToDanceGroup.ConnectionAbonementToDanceGroupUpdateDTO;
import com.dancestudioSpring.Entity.Abonement;
import com.dancestudioSpring.Entity.ConnectionAbonementToDanceGroup;
import com.dancestudioSpring.Entity.DanceGroup;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Service.AbonementService;
import com.dancestudioSpring.Service.ConnectionAbonementToDanceGroupService;
import com.dancestudioSpring.Service.DanceGroupService;

@Component
public class ConnectionAbonementToDanceGroupFacade {

	@Autowired
	ConnectionAbonementToDanceGroupService connectionAbonementToDanceGroupService;

	public ConnectionAbonementToDanceGroup add(Abonement abonement, DanceGroup danceGroup) {
		ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = new ConnectionAbonementToDanceGroup();
		connectionAbonementToDanceGroup.setAbonement(abonement);
		connectionAbonementToDanceGroup.setDanceGroup(danceGroup);
		connectionAbonementToDanceGroup.setDateOfAdd(new Date());
		connectionAbonementToDanceGroup = connectionAbonementToDanceGroupService.add(connectionAbonementToDanceGroup);
		return connectionAbonementToDanceGroup;
	}

    public ArrayList<Integer> listAllConnectedIdOfAbonementsByIdOfDanceGroup(int id_of_dance_group)
    {
        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(id_of_dance_group);
        if (danceGroup == null) return null;

        return listAllConnectedIdOfAbonementsByDanceGroup(danceGroup);
    }

    public ArrayList<Integer> listAllConnectedIdOfAbonementsByDanceGroup(DanceGroup danceGroup)
    {
        List<ConnectionAbonementToDanceGroup> connectionAbonementToDanceGroups = connectionAbonementToDanceGroupService.listAllByDanceGroup(danceGroup);
        ArrayList<Integer> listAllConnectedIdOfAbonementsByDanceGroup = new ArrayList<Integer>();
        for (ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup : connectionAbonementToDanceGroups)
        {
            if (connectionAbonementToDanceGroup.getAbonement() == null) continue;
            listAllConnectedIdOfAbonementsByDanceGroup.add(connectionAbonementToDanceGroup.getAbonement().getId());
        }

        return listAllConnectedIdOfAbonementsByDanceGroup;
    }

    public HashSet<Integer> hashAllConnectedIdOfAbonementsByDanceGroup(DanceGroup danceGroup)
    {
        List<ConnectionAbonementToDanceGroup> connectionAbonementToDanceGroups = connectionAbonementToDanceGroupService.listAllByDanceGroup(danceGroup);
        HashSet<Integer> hashAllConnectedIdOfAbonementsByDanceGroup = new HashSet<Integer>();
        for (ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup : connectionAbonementToDanceGroups)
        {
            if (connectionAbonementToDanceGroup.getAbonement() == null) continue;
            hashAllConnectedIdOfAbonementsByDanceGroup.add(connectionAbonementToDanceGroup.getAbonement().getId());
        }

        return hashAllConnectedIdOfAbonementsByDanceGroup;
    }

    public HashSet<Integer> hashAnyConnectedIdOfAbonementToAnyDanceGroup(User user, boolean isForApp)
    {
        DanceGroupFacade danceGroupFacade = new DanceGroupFacade();
        ArrayList<DanceGroup> danceGroupsForUser = danceGroupFacade.listAllForUser(user, isForApp);

        HashSet<Integer> hashAnyConnectedIdOfAbonementByDanceGroupToUserAnswer = new HashSet<Integer>();
        HashSet<Integer> hashAllConnectedIdOfAbonementsByDanceGroupTMP = new HashSet<Integer>();
        for (DanceGroup danceGroup : danceGroupsForUser)
        {
            hashAllConnectedIdOfAbonementsByDanceGroupTMP = hashAllConnectedIdOfAbonementsByDanceGroup(danceGroup);
            //System.Diagnostics.Debug.WriteLine("Рассматриваем группу " + danceGroup.name + " | число подключенных абонементов: " + hashAllConnectedIdOfAbonementsByDanceGroupTMP.Count());
            hashAnyConnectedIdOfAbonementByDanceGroupToUserAnswer.addAll(hashAllConnectedIdOfAbonementsByDanceGroupTMP);
            //System.Diagnostics.Debug.WriteLine("Промежуточное количество подключенных абонементов: " + hashAnyConnectedIdOfAbonementByDanceGroupToUserAnswer.Count());
        }
        return hashAnyConnectedIdOfAbonementByDanceGroupToUserAnswer;
    }

    public boolean update(ConnectionAbonementToDanceGroupUpdateDTO connectionAbonementToDanceGroupUpdateDTO)
    {
        AbonementService abonementService = new AbonementService();
        Abonement abonement = abonementService.findById(connectionAbonementToDanceGroupUpdateDTO.getId_of_abonement());
        if (abonement == null) return false;

        DanceGroupService danceGroupService = new DanceGroupService();
        DanceGroup danceGroup = danceGroupService.findById(connectionAbonementToDanceGroupUpdateDTO.getId_of_dance_group());
        if (danceGroup == null) return false;

        if (connectionAbonementToDanceGroupUpdateDTO.getStatus() == 1)
        {
            ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = this.add(abonement, danceGroup);
            if (connectionAbonementToDanceGroup != null) return true;
        } else if (connectionAbonementToDanceGroupUpdateDTO.getStatus() == 0)
        {
            if (connectionAbonementToDanceGroupService.delete(abonement, danceGroup)) return true;
        }

        return false;
    }

    public boolean delete(int id)
    {
        ConnectionAbonementToDanceGroup connectionAbonementToDanceGroup = connectionAbonementToDanceGroupService.findById(id);
        if (connectionAbonementToDanceGroup == null) return false;

        return connectionAbonementToDanceGroupService.delete(connectionAbonementToDanceGroup);
    }
}
