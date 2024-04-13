package com.vinayak.groceryqpassessment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItems> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
