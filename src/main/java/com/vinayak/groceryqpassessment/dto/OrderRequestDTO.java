package com.vinayak.groceryqpassessment.dto;

import java.util.List;

public class OrderRequestDTO {

    private List<ItemRequestDTO> items;

    public List<ItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemRequestDTO> items) {
        this.items = items;
    }
}
