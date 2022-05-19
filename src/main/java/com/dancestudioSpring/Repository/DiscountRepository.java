package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
	Discount findById(int id);
}
