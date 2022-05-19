package com.dancestudioSpring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dancestudioSpring.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findById(int id);
	User findByUsername(String username);
}
