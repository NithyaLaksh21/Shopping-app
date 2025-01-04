package main.entities;

import java.util.Scanner;
import java.util.UUID;

import main.ShoppingSystem;

public class Seller {
    private String id ;
    private String phoneNumber;
    private String name;
    private String email;
    private String password;
    private static Scanner scanner = new Scanner(System.in);


    public Seller(String id, String phoneNumber, String name, String email, String password) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    } 

    public void viewProducts() {
        ShoppingSystem.displayProduct();
    }

    public void addProducts() {
       System.out.println("Enter the product Name: ");
        String productName = scanner.next();
        System.out.println("Enter product description:");
        String description =scanner.next();
        scanner.nextLine();
        System.out.println("Enter product price:");
        int price = scanner.nextInt();
        System.out.println("Enter product quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        
        Product newProduct = new Product(productName, description, price, quantity);
        ShoppingSystem.addNewProductsToShop(newProduct);
    }

    public void removeProduct() {
        System.out.println("Enter product to remove");
        String productName = scanner.nextLine();
        ShoppingSystem.removeProductFromShop(productName);
    }

    public void updateQuantityOfProducts(){
        System.out.println("Enter product name who's quantity should be updated: ");
        String productName = scanner.nextLine();
        System.out.println("Enter new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine();
        ShoppingSystem.updateQuantityOfProductsInShop(productName, newQuantity);
    }

    public void removeCustomer() {
        System.out.println("Enter customer ID to remove: ");
        String customerIdStr = scanner.nextLine();
        UUID customerId = UUID.fromString(customerIdStr);
        ShoppingSystem.removeCustomer(customerId);
    }
}
