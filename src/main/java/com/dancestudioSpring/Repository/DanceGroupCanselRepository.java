package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.DanceGroupCansel;

@Repository
public interface DanceGroupCanselRepository extends CrudRepository<DanceGroupCansel, Long> {
	DanceGroupCansel findById(int id);
}
