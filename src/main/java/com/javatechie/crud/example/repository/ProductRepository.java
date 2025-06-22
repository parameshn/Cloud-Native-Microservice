package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    
    Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}

