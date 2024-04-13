package com.vinayak.groceryqpassessment.controller;

import com.vinayak.groceryqpassessment.dto.ProductQuantityDTO;
import com.vinayak.groceryqpassessment.model.Product;
import com.vinayak.groceryqpassessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/inventory")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    // Add new grocery item
    @PostMapping
    public String addNewItem(@RequestBody Product newItem) {
        productRepository.save(newItem);
        return "Item added successfully";
    }

    // View existing grocery items
    @GetMapping
    public List<Product> viewItems() {
        return productRepository.findAll();
    }

    // Remove grocery item
    @DeleteMapping("/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        Optional<Product> itemOptional = productRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            productRepository.deleteById(itemId);
            return "Item removed successfully";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Item not found",null);
    }

    // Update details of existing grocery item
    @PutMapping("/{itemId}")
    public String updateItem(@PathVariable Long itemId, @RequestBody Product updatedItem) {
        Optional<Product> itemOptional = productRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            updatedItem.setId(itemId);
            productRepository.save(updatedItem);
            return "Item updated successfully";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Item not found",null);
    }

    // Manage inventory levels of grocery item
    @PatchMapping("/{itemId}")
    public String updateInventory(@PathVariable Long itemId, @RequestBody ProductQuantityDTO quantity) {
        Optional<Product> itemOptional = productRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            Product item = itemOptional.get();
            item.setQuantity(quantity.getQuantity());
            productRepository.save(item);
            return "Inventory updated successfully";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Item not found",null);
    }

}
