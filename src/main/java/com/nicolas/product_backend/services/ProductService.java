package com.nicolas.product_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nicolas.product_backend.models.Product;
import com.nicolas.product_backend.repositories.ProductRepository;

//assim nossa classe de serviço pode ser injetada dentro de qualquer outra classe
//que precise dos seu serviços;
@Service
public class ProductService {

  @Autowired 
  private ProductRepository productRepository;
  public Product getById(int id){  
    //stream tem métodos que não tem na classe list
        //programação funcional
        Product prod = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found"));
    return prod;
  }


        
}
