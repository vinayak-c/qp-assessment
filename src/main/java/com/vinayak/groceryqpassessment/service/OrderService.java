package com.vinayak.groceryqpassessment.service;

import com.vinayak.groceryqpassessment.dto.ItemRequestDTO;
import com.vinayak.groceryqpassessment.dto.OrderRequestDTO;
import com.vinayak.groceryqpassessment.dto.StockResponseDTO;
import com.vinayak.groceryqpassessment.model.Order;
import com.vinayak.groceryqpassessment.model.OrderItems;
import com.vinayak.groceryqpassessment.repository.OrderRepository;
import com.vinayak.groceryqpassessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private ProductRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public boolean createOrder(OrderRequestDTO items) {

        List<OrderItems> orderItems = items.getItems().stream().map(this::mapToDto).collect(Collectors.toList());

        List<Long> itemIds = orderItems.stream().map(OrderItems::getProductId).collect(Collectors.toList());

        List<StockResponseDTO> stockResponses = itemRepository.findByIdIn(itemIds).stream()
                .map(response -> {
                    StockResponseDTO s = new StockResponseDTO();
                    s.setId(response.getId());
                    s.setInStock(response.getQuantity()>0);
                    return s;
                }).collect(Collectors.toList());

        boolean allProductsInStock = stockResponses.stream().allMatch(StockResponseDTO::isInStock);

        if(allProductsInStock) {
            Order order = new Order();
            order.setOrderItems(orderItems);
            orderRepository.save(order);
            return true;
        } else {
            return false;
        }
    }

    private OrderItems mapToDto(ItemRequestDTO itemRequestDTO){
        OrderItems orderItems = new OrderItems();
        orderItems.setProductId(itemRequestDTO.getItemId());
        orderItems.setQuantity(itemRequestDTO.getQuantity());
        return orderItems;
    }
}
