package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionDiscountToUser;

@Repository
public interface ConnectionDiscountToUserRepository extends CrudRepository<ConnectionDiscountToUser, Long> {
	ConnectionDiscountToUser findById(int id);
}
