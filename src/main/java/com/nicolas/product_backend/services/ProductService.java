package com.nicolas.product_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nicolas.product_backend.models.Category;
import com.nicolas.product_backend.models.Product;
import com.nicolas.product_backend.repositories.CategoryRepository;
import com.nicolas.product_backend.repositories.ProductRepository;

//assim nossa classe de serviço pode ser injetada dentro de qualquer outra classe
//que precise dos seu serviços;
@Service
public class ProductService {

  @Autowired 
  private ProductRepository productRepository;

  @Autowired 
  private CategoryService categoryService;
  
  public Product getById(int id){  
    //stream tem métodos que não tem na classe list
        //programação funcional
        Product prod = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found"));
    return prod;
  }

  public List<Product> getAll(){ 
    return productRepository.findAll();
  }

  public Product save (Product product){ 

    return productRepository.save(product);
  } 

  public void deleteById(int id){ 
    Product prod = getById(id);

    productRepository.delete(prod);
  }
  
  public void update(int id, Product productUpdate){ 
    Product prod = getById(id);

    if(productUpdate.getCategory()==null) 
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category can not be empty");

    Category cat = categoryService.getById(productUpdate.getCategory().getId());

    prod.setDescription(productUpdate.getDescription()); 
    prod.setName(productUpdate.getName()); 
    prod.setPrice( productUpdate.getPrice()); 
    prod.setPromotion(productUpdate.isPromotion()); 
    prod.setNewProduct(productUpdate.isNewProduct());      
    prod.setCategory(cat);

    productRepository.save(prod);
  }
}
