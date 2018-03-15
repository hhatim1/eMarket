package com.hhatim.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Users;

public interface LogRepository extends CrudRepository<Users, Long> {
	
	Users findByEmail(String email);

}
