package com.pluralsight;

public class Product {

    // Variable Introductions // --------------------------------------------------------------------------------------
    private String sku = "";
    private String name = "";
    private double price = 0;
    private String department = "";

    // Constructor // -------------------------------------------------------------------------------------------------
    public Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Getters // -----------------------------------------------------------------------------------------------------
    public String getSku() {
        return sku;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDepartment() {
        return department;
    }

    // Setters // -----------------------------------------------------------------------------------------------------
    public void setSku(String sku) {
        this.sku = sku;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
