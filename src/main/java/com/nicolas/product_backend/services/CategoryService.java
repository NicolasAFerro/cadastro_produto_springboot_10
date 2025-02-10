package com.nicolas.product_backend.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nicolas.product_backend.repositories.CategoryRepository; 
import com.nicolas.product_backend.models.Category ;
import com.nicolas.product_backend.models.Product;

@Service
public class CategoryService {
    @Autowired 
  private CategoryRepository categoryRepository; 


  public Category getById(int id){ 
    Category category= categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
    return category;
  } 

   public List<Category> getAll(){ 
    return categoryRepository.findAll();
  }
}
