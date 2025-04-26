package com.pluralsight;

public class Product {

    // Variables // -------------------------------------------------------------------------------------------------------
    private String sku = "";
    private String itemName = "";
    private double price = 0;
    private String department = "";




    public Product(String sku, String itemName, double price, String department) {
        this.sku = sku;
        this.itemName = itemName;
        this.price = price;
        this.department = department;


    }


    //Getters // ------------------------------------------------------------------------------------------------------
    public String getSku() {
        return sku;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    private String getDepartment() {
        return department;
    }

    // Setters // -----------------------------------------------------------------------------------------------------
    public void setSku(String sku) {
        this.sku = sku;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Product: " + this.sku + "|Product Name/Desc: " + this.itemName + "|Price: " + this.price + "|Department: " + this.department;
    }
}
