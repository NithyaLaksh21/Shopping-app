package main;

import java.util.ArrayList;
import java.util.List;

import main.entities.Seller;

public class Database {
    private List<Seller> sellers = new ArrayList<>();

    public void addSeller(Seller seller) {
        this.sellers.add(seller);
    }

    public List<Seller> getSellers(String phoneNumber) {
        for(Seller seller: sellers) {
            System.out.println(seller);
        }
        return sellers;
    }
}
