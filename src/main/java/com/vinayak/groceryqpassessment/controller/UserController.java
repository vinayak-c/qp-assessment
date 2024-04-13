package com.vinayak.groceryqpassessment.controller;

import com.vinayak.groceryqpassessment.dto.OrderRequestDTO;
import com.vinayak.groceryqpassessment.model.Product;
import com.vinayak.groceryqpassessment.service.OrderService;
import com.vinayak.groceryqpassessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/user/order")
public class UserController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    // View the list of available grocery items
    @GetMapping
    public List<Product> viewItems() {
        return productService.findAllItems();
    }

    //Create a new order with the provided items
    @PostMapping
    public String createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        // Validate items and create the order
        if(!orderService.createOrder(orderRequestDTO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"All products not in stock, try again",null);
        }
        return "Order placed successfully";
    }

}
