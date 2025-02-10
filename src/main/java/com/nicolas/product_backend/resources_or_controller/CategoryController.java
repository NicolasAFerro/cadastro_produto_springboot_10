package com.nicolas.product_backend.resources_or_controller;


import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import com.nicolas.product_backend.models.Category;

import com.nicolas.product_backend.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 
//responde a requisições http
@RestController 
@CrossOrigin
public class CategoryController {
    // private List<Category> categories = Arrays.asList(new Category(1, "Produção Própria"),
    //         new Category(2, "Nacional"),
    //         new Category(3, "Importado"), 
    //         new Category(4, "Premium"));

    //isso aqui é uma inicialização ; poderia ter um construtor da classe e 
    //inicializar lá  
    //public CategoryService()
    //this.categoryRepository = new CategoryRepository();


    @Autowired 
    private CategoryService categoryService;

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        

        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("categories")
    public List<Category> getCategory() {
        return categoryService.getAll();
    }

}
