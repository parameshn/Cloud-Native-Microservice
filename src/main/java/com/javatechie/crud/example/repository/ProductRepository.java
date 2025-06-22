package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    
    List<Product> findByNameContainingIgnoreCase(String keyword);
}

