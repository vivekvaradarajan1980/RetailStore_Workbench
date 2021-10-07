package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RetailRepo {

    private Map<Long, RetailStore> retailStoreList = new HashMap();

    public Map<Long, RetailStore> getAllProducts() {

        return this.retailStoreList;
    }

    public RetailStore getProductById(long id) {
        return retailStoreList.get(id);
    }

    public RetailStore saveProduct(RetailStore retailStore) {
        retailStoreList.put(retailStore.getId(),retailStore);
        return retailStore;

    }
}

