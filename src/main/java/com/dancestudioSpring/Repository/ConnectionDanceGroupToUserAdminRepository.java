package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionDanceGroupToUserAdmin;

@Repository
public interface ConnectionDanceGroupToUserAdminRepository extends CrudRepository<ConnectionDanceGroupToUserAdmin, Long> {
	ConnectionDanceGroupToUserAdmin findById(int id);
}
