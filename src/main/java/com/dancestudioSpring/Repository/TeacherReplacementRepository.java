package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.TeacherReplacement;

@Repository
public interface TeacherReplacementRepository extends CrudRepository<TeacherReplacement, Long> {
	TeacherReplacement findById(int id);
}
