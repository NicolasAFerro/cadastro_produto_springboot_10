package com.nicolas.product_backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.product_backend.models.Category;





public interface CategoryRepository extends JpaRepository <Category,Integer>{
  
  
  
}