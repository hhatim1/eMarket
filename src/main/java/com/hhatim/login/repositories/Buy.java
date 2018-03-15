package com.hhatim.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Product;

public interface Buy extends CrudRepository<Product, Long> {

}
