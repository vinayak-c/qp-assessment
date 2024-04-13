package com.vinayak.groceryqpassessment.repository;

import com.vinayak.groceryqpassessment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
