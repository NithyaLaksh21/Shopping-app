package main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import main.ShoppingSystem;

public class Admin {
    private UUID adminId;
    private String name;
    private String email;
    private String password;
    static Scanner scanner = new Scanner(System.in);
    private static List<Seller> sellers = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    static Seller seller = new Seller("1", "1234567890", "nits", "ni@gmail.com", "password");
    static Admin admin = new Admin("admin", "admin@gmail.com", "password");

    public Admin(String name, String email, String password) {
        this.adminId = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getAdminId() {
        return adminId;
    }

    public void setAdminId(UUID adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void deleteSellerAccount() {
        System.out.println("Enter seller ID :");
        String sellerId = scanner.nextLine();
        sellers.removeIf(seller -> seller.getId().equals(sellerId));
        System.out.println("Seller account deleted: " + sellerId);
    }

    public void deleteCustomerAccount() {
        System.out.println("Enter customer ID: ");
        String customerId = scanner.nextLine();
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
        System.out.println("Customer account deleted : " + customerId);
    }

    public static void displayAdminOperations() {
        System.out.println("************************************");
        System.out.println("Enter your choice");
        System.out.println("************************************");
        System.out.println("1. View Products");
        System.out.println("2. Add Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Update Product Quantity");
        System.out.println("5. Remove Customer"); //not working
        System.out.println("6. Delete Seller Account");
        System.out.println("7. Delete Customer Account");
        System.out.println("8. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> ShoppingSystem.displayProduct();
            case 2 -> {seller.addProducts(); break;}
            case 3 -> { seller.removeProduct() ;break;}
            case 4 -> { seller.updateQuantityOfProducts();break;}
            case 5 -> { seller.removeCustomer();break;}
            case 6 -> { admin.deleteSellerAccount();break;}
            case 7 -> { admin.deleteCustomerAccount();break;}
            case 8 -> {
                System.out.println("Exiting");
                System.exit(1);
            }
            default -> System.out.println("Invalid choice , please try again");
        }                        
    }
}
