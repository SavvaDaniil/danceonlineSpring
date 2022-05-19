package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.TeacherSalary;

@Repository
public interface TeacherSalaryRepository extends CrudRepository<TeacherSalary, Long> {
	TeacherSalary findById(int id);
}
