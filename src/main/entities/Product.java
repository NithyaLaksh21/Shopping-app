package main.entities;

import java.util.UUID;

public class Product {
    private UUID productId;
    private String productName;
    private String description;
    private double price;
    private int quantity;

    
    public Product(String productName, String description, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }
}