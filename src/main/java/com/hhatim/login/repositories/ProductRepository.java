package com.hhatim.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll(); // type casting > setting the type for the return
}
