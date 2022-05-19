package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.DanceGroupDayOfWeek;

@Repository
public interface DanceGroupDayOfWeekRepository extends CrudRepository<DanceGroupDayOfWeek, Long> {
	DanceGroupDayOfWeek findById(int id);
}