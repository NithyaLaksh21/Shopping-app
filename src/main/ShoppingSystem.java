//admin, customer,order,product,shoppingcart, shipping.
//buyproduct, cancelproduct,displayproduct,logout
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
    
        public static void main(String[] args) {  
            initializeProducts();
            while (true) {
                Menu.displayLoginMenu();
                Menu.handleUserOperations();
            }
        }   
            public static void initializeProducts() {
                
                products.add(new Product("Maxi", "maxi dress with floral design", 500));
                products.add(new Product("Crop tops", "Stylish crop tops", 900));
                products.add(new Product("Kurti", "Traditional Kurti", 1500));
                products.add(new Product("Jumpsuit", "Comfy Jumpsuit", 1800));
                products.add(new Product("Jeans", "Classic jeans", 2000));
            }

            public static void displayProduct() {
                System.out.println("************************************");
                System.out.println("Available products");
                System.out.println("************************************");

                for(Product product: products) {
                    System.out.println(product.getProductName() + "- Rs:" + product.getPrice());
                }
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
}
