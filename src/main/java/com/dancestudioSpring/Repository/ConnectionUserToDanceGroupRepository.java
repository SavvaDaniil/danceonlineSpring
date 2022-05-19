package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionUserToDanceGroup;

@Repository
public interface ConnectionUserToDanceGroupRepository extends CrudRepository<ConnectionUserToDanceGroup, Long> {
	ConnectionUserToDanceGroup findById(int id);
}
