package main.entities;

import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String name;
    private double customerNumber;
    private String address;
    private String email;
    private String password;
    
    public Customer(String name, double customerNumber, String address, String email, String password) {
        this.customerId = UUID.randomUUID();
        this.name = name;
        this.customerNumber = customerNumber;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(double customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
