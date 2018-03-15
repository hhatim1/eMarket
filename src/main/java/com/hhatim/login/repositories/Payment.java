package com.hhatim.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hhatim.login.models.Product;

public interface Payment extends CrudRepository<Product, Long> {

}
