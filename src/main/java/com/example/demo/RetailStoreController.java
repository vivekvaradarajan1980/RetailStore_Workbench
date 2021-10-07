package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RetailStoreController {

    private final RetailStoreService retailStoreService;

    public RetailStoreController(RetailStoreService retailStoreService) {
        this.retailStoreService = retailStoreService;
    }

    @GetMapping("/api/products")
    public Map<Long, RetailStore> returnListOfProducts() {return retailStoreService.getAllProducts();}

    @GetMapping("/api/products/{id}")
    public RetailStore getProductById(@PathVariable Long id){
        return retailStoreService.getProductById(id);
    }

    @PostMapping("/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    public RetailStore saveProductById(@RequestBody RetailStore retailStore){
        return retailStoreService.saveProduct(retailStore);
    }
}
