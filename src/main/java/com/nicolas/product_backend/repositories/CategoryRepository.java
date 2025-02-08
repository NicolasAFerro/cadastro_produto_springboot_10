package com.nicolas.product_backend.repositories;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository <Category,Integer>{
  
  
}