package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionAbonementToDanceGroup;

@Repository
public interface ConnectionAbonementToDanceGroupRepository extends CrudRepository<ConnectionAbonementToDanceGroup, Long> {
	ConnectionAbonementToDanceGroup findById(int id);
}
