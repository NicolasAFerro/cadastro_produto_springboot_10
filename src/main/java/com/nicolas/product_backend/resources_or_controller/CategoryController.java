package com.nicolas.product_backend.resources_or_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.server.ResponseStatusException;

import com.nicolas.product_backend.models.Category;
import com.nicolas.product_backend.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    private CategoryRepository categoryRepository;

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category cat = categoryRepository.findById(id)
                                         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        return ResponseEntity.ok(cat);
    }

    @GetMapping("categories")
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

}
