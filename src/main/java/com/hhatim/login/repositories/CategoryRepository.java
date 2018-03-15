package com.hhatim.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
}
