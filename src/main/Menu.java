package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public void displayLoginMenu() {
    
        System.out.println("*************Shopping***************");
        System.out.println("1. Already a customer? Sign in ");
        System.out.println("2. Skip sign in");
        System.out.println("3. New to this app? Create an account?");
        System.out.println("************************************");
        System.out.println("Enter your choice from above: ");
    }

    public static void displayUserOperations() {
        while (true) {
            System.out.println("************************************");
            System.out.println("Enter your choice");
            System.out.println("************************************");
            System.out.println("1. Display Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Cancel Product");
            System.out.println("4. Change password");
            System.out.println("5. Logout");
            int subChoice = scanner.nextInt();

        switch (subChoice) {
            case 1 -> ShoppingSystem.displayProduct();
            case 2 -> ShoppingSystem.buyProduct();
            case 3 -> ShoppingSystem.cancelProduct() ;
            case 4 -> UserOperations.changePassword();
            case 5 -> { UserOperations.logout(); return; }
            default -> System.out.println("Invalid choice, please try again.");
            }
            
        System.out.println("Press any char to escape from this session or enter you choice from above");
        
        }
    }

    public void handleUserOperations() {
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 ->   UserOperations.login(); 
                case 2 ->  { 
                            ShoppingSystem.displayProduct();
                            System.exit(1);
                            }
                case 3 -> { UserOperations.createAccount(); break;}
                default ->  System.out.println("Invalid choice, please try again.");
            }
        } 
        catch(InputMismatchException e) {
            System.out.println("Invalid input, enter a valid number");
            scanner.nextLine();
        }
    }    


    public static TypeOfUsers getUserType(int userInput) {
        TypeOfUsers typeOfUsers[] = TypeOfUsers.values();
        return typeOfUsers[userInput -1];
    }

}
