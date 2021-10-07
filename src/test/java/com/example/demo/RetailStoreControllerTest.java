package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.mockito.Mockito.framework;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RetailStoreController.class)
public class RetailStoreControllerTest
{
    @MockBean
    private RetailStoreService retailStoreService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnListOfProducts() throws Exception {
        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);
        RetailStore prod2 = new RetailStore(2, "Bakingsoda", 5);

        Map<Long, RetailStore> retailStoreList = new HashMap<>();
        retailStoreList.put(1L,prod1);
        retailStoreList.put(2L,prod2);

        when(retailStoreService.getAllProducts()).thenReturn(retailStoreList);

        MockHttpServletRequestBuilder getRequest = get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mvc.perform(getRequest)
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.[\"2\"].id").value(1L));

    }

    @Test
    public void shouldReturnProductById() throws Exception {
        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);
        RetailStore prod2 = new RetailStore(2, "Bakingsoda", 5);

        Map<Long, RetailStore> retailStoreList = new HashMap<>();
        retailStoreList.put(1L,prod1);
        retailStoreList.put(2L,prod2);

        when(retailStoreService.getProductById(1L)).thenReturn(prod1);

        MockHttpServletRequestBuilder getRequest = get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L));

    }

    @Test
    public void shouldReturnProductSaved() throws Exception {
        RetailStore prod1 = new RetailStore(1, "Bakingpowder", 12);
        ObjectMapper obj = new ObjectMapper();
        String jsonString = obj.writeValueAsString(prod1);

        when(retailStoreService.saveProduct(prod1)).thenReturn(prod1);

        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/api/product")
                        .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON);

        System.out.println(prod1);
        mvc.perform(postRequest)
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(12L));

    }



}
