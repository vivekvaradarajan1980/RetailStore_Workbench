package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetailServiceTest {

    @Mock
    RetailRepo retailRepo;

    @InjectMocks
    RetailStoreService retailStoreService;


    @Test
    public void ReturnListProducts() throws Exception {

        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);
        RetailStore prod2 = new RetailStore(2, "Bakingsoda", 5);

        Map<Long, RetailStore> retailStoreList = new HashMap<>();
        retailStoreList.put(1L,prod1);
        retailStoreList.put(2L,prod2);


        when(retailRepo.getAllProducts()).thenReturn(retailStoreList);

       // RetailStoreService retailStoreService = new RetailStoreService(retailRepo);
        Map<Long, RetailStore> retaillist =retailStoreService.getAllProducts();

        assertThat(retaillist).isEqualTo(retailStoreList);
    }

    @Test
    public void ReturnProductById() throws Exception {

        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);
        RetailStore prod2 = new RetailStore(2, "Bakingsoda", 5);

        Map<Long, RetailStore> retailStoreList = new HashMap<>();
        retailStoreList.put(1L,prod1);
        retailStoreList.put(2L,prod2);


        when(retailRepo.getProductById(2L)).thenReturn(prod1);

        RetailStore productRequest =retailStoreService.getProductById(2L);

        assertThat(productRequest).isEqualTo(prod1);
    }

    @Test
    public void ReturnProductSaved() throws Exception {

        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);

        when(retailRepo.saveProduct(prod1)).thenReturn(prod1);

        // RetailStoreService retailStoreService = new RetailStoreService(retailRepo);
        RetailStore productRequest =retailStoreService.getProductById(1L);
        System.out.println(prod1);
        assertThat(productRequest).isEqualTo(prod1);
    }
}
