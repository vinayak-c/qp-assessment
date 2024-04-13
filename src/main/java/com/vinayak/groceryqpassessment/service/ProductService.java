package com.vinayak.groceryqpassessment.service;

import com.vinayak.groceryqpassessment.model.Product;
import com.vinayak.groceryqpassessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository itemRepository;


    public List<Product> findAllItems() {
        return itemRepository.findAll();
    }


}
