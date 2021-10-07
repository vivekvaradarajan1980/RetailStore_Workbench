package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RetailStoreService {

    private final RetailRepo retailRepo;

    public RetailStoreService( RetailRepo retailRepo) {
        this.retailRepo = retailRepo;
    }

    public Map<Long, RetailStore> getAllProducts() {
        return retailRepo.getAllProducts();
    }

    public RetailStore getProductById(Long id) {
        return retailRepo.getProductById(id);
    }

    public RetailStore saveProduct(RetailStore retailStore) {

       return retailRepo.saveProduct(retailStore);
    }
}
