package main;

import java.util.Scanner;


public class UserOperations {

    static Scanner scanner = new Scanner(System.in);
    private static String password;
    private static String newPassword;

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
        System.out.println("2. Guest users");
        System.out.println("3. Admin");
        System.out.println("4. Customer");
        int userInput = scanner.nextInt();
        TypeOfUsers typeOfUsers = Menu.getUserType(userInput);

        if(userInput == 2) {
            System.out.println("You are a Guest User now, you won't be able to buy/cancel products. If you wanted to buy/cancel product from this store please choose accountType as Customer(4)");
        }else{
            System.out.println("Enter mobile number: ");
            String mobileNumber = scanner.next();
            System.out.println("Enter password: ");
            password = scanner.next();

            while (!mobileNumber.matches("^[7-9][0-9]{9}$")) {
                System.out.println("Invalid phone number, Please enter a valid 10 digit phone number");
                mobileNumber = scanner.next();
            }
        }

    
        switch (typeOfUsers) {
            case SELLER -> Menu.displayUserOperations();
            case GUESTUSER -> ShoppingSystem.displayProduct();
            case ADMIN -> Menu.displayUserOperations();
            case CUSTOMER -> Menu.displayUserOperations();
            default -> {break;}
        }
    }

    public static void logout() {
        System.out.println("Logged out successfully");
        System.exit(0);
    }
}
