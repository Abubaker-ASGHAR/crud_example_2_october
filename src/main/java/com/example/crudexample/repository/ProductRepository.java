package com.example.crudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.crudexample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

}
