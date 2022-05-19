package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.PurchaseAbonement;

@Repository
public interface PurchaseAbonementRepository extends CrudRepository<PurchaseAbonement, Long> {
	PurchaseAbonement findById(int id);
}
