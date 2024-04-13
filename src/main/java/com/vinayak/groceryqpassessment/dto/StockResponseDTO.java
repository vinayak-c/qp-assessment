package com.vinayak.groceryqpassessment.dto;

public class StockResponseDTO {
    private long id;
    private boolean isInStock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }
}
