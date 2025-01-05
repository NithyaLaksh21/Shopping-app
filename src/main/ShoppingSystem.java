//admin, customer,order,product,shoppingcart, shipping.
//buyproduct, cancelproduct,displayproduct,logout
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.entities.Admin;
import main.entities.Customer;
import main.entities.Product;
import main.entities.Seller;


enum TypeOfUsers {
    SELLER,
    GUESTUSER,
    ADMIN,
    CUSTOMER
}

public class ShoppingSystem {
    static Scanner scanner = new Scanner(System.in);
        private static List<Product> cart = new ArrayList<>();
        private static List<Product>products = new ArrayList<>();
        private static int itemCount;
        private static List<Customer> customers = new ArrayList<>();
        static Admin admin = new Admin("admin", "admin@gmail.com", "password");
        static Seller seller = new Seller("1", "1234567890", "John Doe", "john@example.com", "password");
            
            
                public static void main(String[] args) {  
                    initializeProducts();
                    Menu menu = new Menu();
                    menu.displayLoginMenu();
                    menu.handleUserOperations();
                    
                    System.out.println("Are you a ....");
                    System.out.println("1. Customer");
                    System.out.println("2. Admin");
                    System.out.println("3. Seller");
                    System.out.println("4. Guest User");
                    System.out.println("Enter your userType");
                    int userInput = scanner.nextInt();
                    scanner.nextLine();

                    TypeOfUsers typeOfUsers;
                    switch (userInput) {
                        case 1 -> typeOfUsers = TypeOfUsers.CUSTOMER;
                        case 2 -> typeOfUsers = TypeOfUsers.ADMIN;
                        case 3 -> typeOfUsers = TypeOfUsers.SELLER;
                        case 4 -> typeOfUsers = TypeOfUsers.GUESTUSER;
                        default -> {
                            System.out.println("Invalid choice , exiting");
                            return;
                        }
                    }

                    while (true) {
                    switch (typeOfUsers) {
                        case SELLER -> seller.displaySellerOperations();
                        case CUSTOMER -> Menu.displayUserOperations();
                        case ADMIN -> Admin.displayAdminOperations();
                        case GUESTUSER -> {
                            displayProduct();
                            System.exit(1);
                        }
                        default -> {
                            System.out.println("Invalid user type");
                            return;
                        }
                    }
                }
            }   
            
            public static void initializeSeller() {
                Seller seller = new Seller("1", "9878656787", "no one", "ni@gmail.com", null);
            }


            public static void initializeProducts() {

                products.add(new Product("Maxi", "maxi dress with floral design", 500,1));
                products.add(new Product("Crop tops", "Stylish crop tops", 900,1));
                products.add(new Product("Kurti", "Traditional Kurti", 1500,1));
                products.add(new Product("Jumpsuit", "Comfy Jumpsuit", 1800,1));
                products.add(new Product("Jeans", "Classic jeans", 2000,1));
            }
            
            public static void displayProduct() {
                System.out.println("************************************");
                System.out.println("Available products");
                System.out.println("************************************");

                for(Product product: products) {
                    System.out.println(product.getProductName() + "- Rs:" + product.getPrice());
                }
                return;
            }

            public static void buyProduct() {
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

            public static void displayCart() {
                System.out.println("----------- My Orders ------------");
                for (Product product: cart) {
                    System.out.println(product.getProductName()+ " - Rs:" + product.getPrice());
                }
                System.out.println("-------------------------------------");
                
            }


            public static void cancelProduct() {
                displayCart();
                System.out.println("Enter the product to be cancelled");
                int userChoice = scanner.nextInt();
                
                    if(userChoice > 0 && userChoice <= cart.size()) {
                        Product cancelledProduct = cart.remove(userChoice-1);
                        itemCount--;
                        System.out.println("Product cancelled : "+ itemCount);
                        System.out.println("Product cancelled : "+ cancelledProduct.getProductName() + "- Rs:" + cancelledProduct.getPrice());
                        displayCart();
                    }
                    else {
                        System.out.println("No items in cart");
                    }  
            }

            public static void addNewProductsToShop(Product newProduct) {
                products.add(newProduct);
                System.out.println("Products added: " + newProduct.getProductName());
            }

            public static void removeProductFromShop(String productName) {
                products.removeIf(product -> product.getProductName().equals(productName));
                System.out.println("Product removed: " + productName);
            }

            public static void updateQuantityOfProductsInShop(String productName, int newQuantity) {
                for(Product product : products) {
                    if(product.getProductName().equals(productName)) {
                        product.setQuantity(newQuantity);
                        System.out.println("Product quantity updated: " + productName + " - new quantity " + newQuantity);
                        return;
                    }
                }
                System.out.println("Product not found " + productName);
            }

}
