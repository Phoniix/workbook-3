package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {

    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println("ID: " + p.getUpc() + " " + p.getItemName() + "- Price: " + p.getPrice());
        }

    }

    public static ArrayList<Product> getInventory () {
        ArrayList<Product> inventory = new ArrayList<Product>();
        return inventory;
    }



}
