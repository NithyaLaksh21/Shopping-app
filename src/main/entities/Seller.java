package main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.ShoppingSystem;

public class Seller {
    private String id ;
    private String phoneNumber;
    private String name;
    private String email;
    private String password;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    static Admin admin = new Admin("admin", "admin@gmail.com", "password");
    static Seller seller = new Seller("1", "1234567890", "nits", "ni@example.com", "password");


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
        customers.removeIf(customer -> customer.getCustomerId().equals(customerIdStr));
        System.out.println("Customer account deleted: " + customerIdStr);
    }

    public void viewOrders() {
        ShoppingSystem.displayCart();
    }

    public static void displaySellerOperations() {
        System.out.println("************************************");
        System.out.println("Enter your choice");
        System.out.println("************************************");
        System.out.println("1. View Products");
        System.out.println("2. Add Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Update Product Quantity");
        System.out.println("5. Remove Customer"); //not working
        System.out.println("6. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> ShoppingSystem.displayProduct();
            case 2 -> seller.addProducts();
            case 3 -> seller.removeProduct();
            case 4 -> seller.updateQuantityOfProducts();
            case 5 -> seller.removeCustomer();
            case 6 -> {
                System.out.println("Exiting");
                System.exit(1);
            }
            default -> System.out.println("Invalid choice . Please try again");
        }                        
    }

}
