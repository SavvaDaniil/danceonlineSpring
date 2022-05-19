package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.ConnectionAbonementToDiscount;

@Repository
public interface ConnectionAbonementToDiscountRepository extends CrudRepository<ConnectionAbonementToDiscount, Long> {
	ConnectionAbonementToDiscount findById(int id);
}