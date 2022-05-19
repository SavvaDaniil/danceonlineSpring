package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.AbonementDynamicDateMustBeUsedTo;

@Repository
public interface AbonementDynamicDateMustBeUsedToRepository extends CrudRepository<AbonementDynamicDateMustBeUsedTo, Long> {
	AbonementDynamicDateMustBeUsedTo findById(int id);
}
