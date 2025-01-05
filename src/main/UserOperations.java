package main;

import java.util.Scanner;
import java.util.UUID;

import main.entities.Admin;
import main.entities.Customer;
import main.entities.Seller;


public class UserOperations {

    static Scanner scanner = new Scanner(System.in);
    private static String password;
    private static String newPassword;
    private static Database database = new Database();


    public static void login() {
        while(true) {
            System.out.println("Login via mobile number : ");
            String phoneNumber = scanner.next();
            System.out.println("Enter password: ");
            password = scanner.next();
        
            if(phoneNumber.matches("^[7-9][0-9]{9}$") && password.equalsIgnoreCase("123")) {
                System.out.println("Logged in successful");
                break;
            }
            else { 
                System.out.println("This seems to be an error, please enter a valid 10 digit mobile number/valid password");
            }
        }
    }

    public static void changePassword() {
        while(true) {
            System.out.println("Enter the current password");
            String currentPassword = scanner.next();

            if(currentPassword.equalsIgnoreCase(password)) {
                System.out.println("Enter new password: ");
                newPassword = scanner.next();
                password = newPassword;
                System.out.println("Password changed successfully.");
                break;
            }    
            else {
                System.out.println("Incorrect password, please enter the correct password");
            }
        }
    }

    public static void createAccount() {
        System.out.println("Enter the type of account you want to create ? ");
        System.out.println("1. Seller");
        System.out.println("2. Customer");
        System.out.println("3. Admin");
        int userInput = scanner.nextInt();
        TypeOfUsers typeOfUsers = Menu.getUserType(userInput);

            System.out.println("Enter mobile number: ");
            String mobileNumber = scanner.next();
            System.out.println("Enter password: ");
            password = scanner.next();

            while (!mobileNumber.matches("^[7-9][0-9]{9}$")) {
                System.out.println("Invalid phone number, Please enter a valid 10 digit phone number");
                mobileNumber = scanner.next();
            }

            if(userInput == 1) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter email: ");
                String email = scanner.next();
                Seller seller = new Seller(UUID.randomUUID().toString(), mobileNumber, name, email, password);
                database.addSeller(seller);
                System.out.println("Successfully added seller account");
            }
            else if (userInput == 2){
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter email: ");
                String email = scanner.next();
                Customer customer = new Customer(name, userInput, name, email, email);
                database.addCustomer(customer);
                System.out.println("Successfully added customer account");
            }
            else {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter email: ");
                String email = scanner.next();
                Admin admin = new Admin(name, email, email);
                database.addAdmin(admin);
                System.out.println("Successfully added Admin account");
            }
        // }

    
        switch (typeOfUsers) {
            case SELLER -> {Seller.displaySellerOperations(); break;}
            case ADMIN -> {Admin.displayAdminOperations(); break;}
            case CUSTOMER ->{ Menu.displayUserOperations(); break;}
            default -> {break;}
        }
    }

    public static void logout() {
        System.out.println("Logged out successfully");
        System.exit(0);
    }
}
