package com.hhatim.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Users;

public interface RegRepository extends CrudRepository<Users, Long> {

}
