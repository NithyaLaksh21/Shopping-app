package main;

import java.util.ArrayList;
import java.util.List;

import main.entities.Admin;
import main.entities.Customer;
import main.entities.Seller;

public class Database {
    private List<Seller> sellers = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    
        public void addSeller(Seller seller) {
            this.sellers.add(seller);
        }
    
        public List<Seller> getSellers(String phoneNumber) {
            for(Seller seller: sellers) {
                System.out.println(seller);
            }
            return sellers;
        }
    
        public void addCustomer(Customer customer) {
            this.customers.add(customer);
        }

        public List<Customer> getCustomers(String phoneNumber) {
            for(Customer customer: customers) {
                System.out.println(customer);
            }
            return customers;
        }

        public void addAdmin(Admin admin) {
            this.admins.add(admin);
        }

        public List<Admin> getAdmins(String phoneNumber) {
            for(Admin admin: admins) {
                System.out.println(admin);
            }
            return admins;
        }

        
}
