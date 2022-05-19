package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.DanceGroupEventDate;

@Repository
public interface DanceGroupEventDateRepository extends CrudRepository<DanceGroupEventDate, Long> {
	DanceGroupEventDate findById(int id);
}