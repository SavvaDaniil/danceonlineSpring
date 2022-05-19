package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Abonement;

@Repository
public interface AbonementRepository extends CrudRepository<Abonement, Long> {
	Abonement findById(int id);
}
