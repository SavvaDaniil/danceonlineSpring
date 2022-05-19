package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.TeacherRate;

@Repository
public interface TeacherRateRepository extends CrudRepository<TeacherRate, Long> {
	TeacherRate findById(int id);
}
