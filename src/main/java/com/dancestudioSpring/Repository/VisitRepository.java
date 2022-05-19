package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
	Visit findById(int id);
}
