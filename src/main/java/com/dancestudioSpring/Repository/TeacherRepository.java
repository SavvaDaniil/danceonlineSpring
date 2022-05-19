package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	Teacher findById(int id);
}
