package com.nicolas.product_backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.product_backend.models.Product;

public interface ProductRepository extends JpaRepository <Product,Integer>{
  
}
