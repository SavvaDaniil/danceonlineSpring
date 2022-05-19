package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.DanceGroup;

@Repository
public interface DanceGroupRepository extends CrudRepository<DanceGroup, Long> {
	DanceGroup findById(int id);
}
