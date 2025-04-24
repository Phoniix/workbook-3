package com.pluralsight;

public class Product {

// Variables // -------------------------------------------------------------------------------------------------------
    int upc = 0;
    String itemName = "";
    double price = 0;

    public Product(int upc, String itemName, double price) {
        this.upc = upc;
        this.itemName = itemName;
        this.price = price;


    }

    //Getters // ------------------------------------------------------------------------------------------------------
    public int getUpc() {
        return upc;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }

    // Setters // -----------------------------------------------------------------------------------------------------
    public void setUpc(int upc) {
        this.upc = upc;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
