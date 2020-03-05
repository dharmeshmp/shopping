package com.example.shopping.dto;

import com.example.shopping.model.Product;

import java.util.Objects;

public class CartItemDto {
    private Product product;
    private int quantity;
    private float amount;

    public CartItemDto(Product product, int quantity, float amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public CartItemDto() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemDto that = (CartItemDto) o;
        return product.getId() == that.product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
