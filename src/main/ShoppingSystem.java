package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShoppingSystem {
    Scanner scanner = new Scanner(System.in);
    private static List<String> cart = new ArrayList<>();
    private static List<String> products = new ArrayList<>();
    private static int itemCount;
        public static void main(String[] args) {
            products.add("Maxi - Rs:500");
            products.add("Crop Tops - Rs:300");
            products.add("Kurti - Rs:1500");
            products.add("Jumpsuit - Rs:800");
            products.add("Jeans - Rs:900");
    
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("*************Shopping***************");
                System.out.println("1. Already a customer? Sign in ");
                System.out.println("2. Skip sign in");
                System.out.println("3. New to this app? Create an account?");
                System.out.println("************************************");
                System.out.println("Enter your choice from above: ");
                
                
                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            login();
                            while(true) {
                                System.out.println("************************************");
                                System.out.println("Enter your choice");
                                System.out.println("************************************");
                                System.out.println("1. Display Products");
                                System.out.println("2. Buy Product");
                                System.out.println("3. Cancel Product");
                                System.out.println("4. Logout");
                                int subChoice = scanner.nextInt(); 

                                switch (subChoice) {
                                    case 1 -> displayProduct();
                                    case 2 -> buyProduct();
                                    case 3 -> cancelProduct() ;
                                    case 4 -> { logout(); return; }
                                    default -> System.out.println("Invalid choice, please try again.");
                                }
                            }
                        }
                        case 2 -> displayProduct();
                        case 3 -> {
                            createAccount();
                            while(true) {
                                System.out.println("************************************");
                                System.out.println("Enter your choice");
                                System.out.println("************************************");
                                System.out.println("1. Display Products");
                                System.out.println("2. Buy Product");
                                System.out.println("3. Cancel Product");
                                System.out.println("4. Logout");
                                int subChoice = scanner.nextInt(); 

                                switch (subChoice) {
                                    case 1 -> displayProduct();
                                    case 2 -> buyProduct();
                                    case 3 -> cancelProduct() ;
                                    case 4 -> { logout(); return; }
                                    default -> System.out.println("Invalid choice, please try again.");
                                }
                            }
                        }

                        default -> System.out.println("Invalid choice, please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, enter a valid number");
                }
            }
    
        }
    
        private static void login() {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Login via mobile number : ");
                String phoneNumber = scanner.next();
            try {
                if(phoneNumber.matches("^[7-9][0-9]{9}$")) {
                    System.out.println("Logged in successful");
                    break;
                }
                else { 
                    System.out.println("This seems to be an error, please enter a valid 10 digit mobile number");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid mobileNumber");
            }    
        }
    }

        private static void createAccount() {
            System.out.println("Enter mobile number: ");
            Scanner scanner = new Scanner(System.in);
            String mobileNumber = scanner.next();

            while (!mobileNumber.matches("^[7-9][0-9]{9}$")) {
                System.out.println("Invalid phone number, Please enter a valid 10 digit phone number");
                mobileNumber = scanner.next();
            }
        }

        static String productList;
        private static void buyProduct() {
            Scanner scanner = new Scanner(System.in);
            displayProduct();
            System.out.println("Enter the product to be ordered: ");
            int productChoice = scanner.nextInt();
            
                if(productChoice > 0 && productChoice <= products.size()) {
                    cart.add(products.get(productChoice-1));
                    itemCount ++;
                    System.out.println("Product added to cart: "+ itemCount);
                    displayCart();
                }
              else {
                System.out.println("Invalid choice");
              }
    }

    private static void displayCart() {
        System.out.println("----------- My Orders ------------");
        for (String n: cart) {
            System.out.println(n);
        }
        System.out.println("-------------------------------------");
        
    }

    private static void displayProduct() {
        System.out.println("************************************");
       System.out.println("Available products");
       System.out.println("************************************");

        for(String n: products) {
            System.out.println(n);
        }
    }

    private static void cancelProduct() {
        Scanner scanner = new Scanner(System.in);
        displayCart();
        System.out.println("Enter the product to be cancelled");
        int userChoice = scanner.nextInt();
        
            if(userChoice > 0 && userChoice<= cart.size()) {
                cart.remove(userChoice-1);
                itemCount--;
                System.out.println("Product cancelled : "+ itemCount);
                displayCart();
            }
            else {
                System.out.println("No items in cart");
            }  
    }

    private static void logout() {
        System.out.println("Logged out successfully");
        System.exit(0);
    }
}
