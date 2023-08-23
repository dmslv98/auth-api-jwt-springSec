package com.exemplo.authapijwt02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.authapijwt02.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
