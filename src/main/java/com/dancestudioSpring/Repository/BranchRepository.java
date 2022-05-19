package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
	Branch findById(int id);
}
