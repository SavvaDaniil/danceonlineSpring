package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionAbonementPrivateToUser;

@Repository
public interface ConnectionAbonementPrivateToUserRepository extends CrudRepository<ConnectionAbonementPrivateToUser, Long> {
	ConnectionAbonementPrivateToUser findById(int id);
}
