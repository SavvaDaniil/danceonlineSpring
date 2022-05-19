package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
	Admin findById(int id);
	Admin findByUsername(String username);
}

