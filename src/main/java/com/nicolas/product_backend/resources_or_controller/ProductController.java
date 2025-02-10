package com.nicolas.product_backend.resources_or_controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.product_backend.models.Product; 
import com.nicolas.product_backend.services.ProductService;
import java.net.URI;
import java.util.List;
//import java.util.Locale.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//https://learn.microsoft.com/pt-br/azure/architecture/best-practices/api-design
//restfull api design 
//restfull api bestPratices 

//ENDPOINT NÃO PODE SER VERBO
//TENTAR SER SEMPRE NO PLURAL

//ctrl+ k solta +z -> modo zen do vsCode
@RestController
@CrossOrigin // proteção do navegador para erro cors
public class ProductController {

    
   
    @Autowired 
    private ProductService productService;

   
    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));

    }

    // aqui ctrl+.
    @GetMapping("products")
    public List<Product> getProducts() {
        return  productService.getAll();
    }

    @PostMapping("products") // eu vou pegar o body dentro da requisição e vou transformar em produto
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        //ao atribuir o retorno do save
        product = productService.save(product);

        // CTRL . para importar as bibliotecas
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();
        // location é uri para esse recurso. O get dele
        return ResponseEntity.created(location).body(product);
    }

    @DeleteMapping("products/{id}") 
    public ResponseEntity<Void> removeProduct(@PathVariable int id){  
       productService.deleteById(id);
        return ResponseEntity.noContent().build();

    } 
        // ResponseEntity.noContent(): Esse método retorna um objeto do tipo ResponseEntity. 
        // odyBuilder.  
        // Esse builder permite que você adicione informações adicionais na resposta, como cabeçalhos, 
        //  antes de finalizar a construção da resposta.

        // .build(): Aqui você está finalizando o processo de construção e criando a
        // //  instância final de ResponseEntity<Void> com o status 204 No Content. 
        // return ResponseEntity.noContent()
        //              .header("Custom-Header", "Value")
        //              .build();


    //PUT ALTERA TUDO 
    //PATCH ALTERA EM PARTE 
    @PutMapping("products/{id}") 
    public ResponseEntity<Void> updateProduct(@PathVariable int id,@RequestBody Product productUpdate){  
        
        productService.update(id, productUpdate);
        return ResponseEntity.ok().build();

    } 
}
