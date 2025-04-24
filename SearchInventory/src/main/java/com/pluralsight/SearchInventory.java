package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Variable Introduction // ------------------------------------------------------------------------------------
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        BufferedReader lilJon = new BufferedReader(new FileReader("products.csv"));
        BufferedWriter lilTim = new BufferedWriter(new FileWriter("products.csv", true));
        setArray(scanner, inventory, lilJon);
        boolean keepGoing = true;
        int function = 0;

        // App Start // -----------------------------------------------------------------------------------------------
        while (keepGoing || function != 5) {
            function = welcomeMenu(scanner);

            if (function == 1) {
                displayProducts(inventory);
            } else if (function == 2) {
                searchBySku(inventory, scanner);
            } else if (function == 3) {
                searchByPrice(inventory, scanner);
            } else if (function == 4) {
                addProduct(inventory, scanner, lilTim);
            } else if (function == 5) {
                exitSequence();
                keepGoing = false;
            } else {
                continue;
            }
        } // While Loop Ends // Exits App // --------------------------------------------------------------------------

        scanner.close();
        lilJon.close();
    }

    /// Learnt This From Workbook, make sure to study // ───────────────────────────────────────────────────────────────
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        return inventory;
    }

    /// Learnt This From Workbook, make sure to study // ───────────────────────────────────────────────────────────────

    // Front End // User Accessible Code // ---------------------------------------------------------------------------
    public static int welcomeMenu(Scanner scanner) throws NumberFormatException, InterruptedException, IOException {
        int menuChoice = 0;
        boolean confirmMenuChoice = false;
        while (!confirmMenuChoice) {
            titleNewLineTop();
            System.out.println("Welcome User! Manage your inventory here.");
            System.out.println("What service do you need?");
            System.out.println("\n(1) List All Products");
            System.out.println("(2) Lookup Product By ID/SKU");
            System.out.println("(3) Lookup Product by Price Range");
            System.out.println("(4) Add New Product");
            System.out.println("(5) Quit Application");
            titleLineBottom();
            System.out.print("\n\nEnter Command:  ");

            try {
                menuChoice = Integer.parseInt(scanner.nextLine().trim());

                if (!(menuChoice >= 1) && !(menuChoice <= 5)) {
                    System.out.println("Not Valid Input. Enter 1-5 only.");
                    timer(1000);
                    continue;
                }
            } catch (NumberFormatException ignored) {
            } /// ChatGPT Suggestion "ignored" variable name // Keeps code running without stopping for error ///
            confirmMenuChoice = true;
        }
        return menuChoice;
    }

    public static void exitSequence() throws InterruptedException {
        titleNewLineTop();
        System.out.println("Thank you for using Inventory App!");
        System.out.println("Goodbye!");
        titleLineBottom();
        timer(2000);
    }

    // Functions of The Program // User Accessible Code //  -----------------------------------------------------------
    public static void displayProducts(ArrayList<Product> inventory) throws InterruptedException {
        System.out.println("\nDisplaying Products...");
        timer(1500);
        for (int i = 0; i < inventory.size(); i++) {
            timer(150);
            newLineTop();
            Product p = inventory.get(i);
            System.out.println("ID: " + p.getSku() + " " + p.getItemName() + "- Price: " + p.getPrice());
        }
    }

    public static void searchBySku(ArrayList<Product> inventory, Scanner scanner) throws InterruptedException {
        boolean keepGoing = true;

        timer(1000);
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Enter SKU/ID to search. Otherwise, Press 0 to exit");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");

            String userSearch = scanner.nextLine().trim().replaceAll("\\s+", "").toUpperCase();

            timer(1000);

            if (userSearch.equalsIgnoreCase("0")) {
                System.out.println("\nReturning to Menu...");
                timer(1000);
                break;
            } else {
                boolean found = false;
                for (Product product : inventory) {
                    timer(100);
                    if (product.getSku().toUpperCase().startsWith(userSearch) ||
                            product.getSku().toUpperCase().endsWith(userSearch) ||
                            product.getSku().toUpperCase().equalsIgnoreCase(userSearch) &&
                                    product != null) {

                        newLineTop();
                        System.out.println(product.toString());
                        lineBottom();
                        found = true;
                    }
                } // For Loop End // Search Inventory By Key Term // --------------------------------------------------
                if (!found) {
                    titleNewLineTop();
                    System.out.println("No Product Found. Try Again");
                    titleLineBottom();
                }
            }
        } // While Loop End // Exits Method // ------------------------------------------------------------------------


    }

    public static void searchByPrice(ArrayList<Product> inventory, Scanner scanner) throws InterruptedException, NumberFormatException {
        boolean keepGoing = true;

        timer(1000);
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Enter Max Price to start search. Otherwise, Press 0 to exit");
            titleLineBottom();
            System.out.print("\n\nMax Price:  ");
            double userSearchMax = 0;

            try {
                userSearchMax = Double.parseDouble(scanner.nextLine().trim().replaceAll("\\s+", ""));
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Input");
            }

            if (userSearchMax == 0) {
                System.out.println("\nReturning to Menu...");
                timer(1000);
                break;
            }

            titleNewLineTop();
            System.out.print("\nMin Price:  ");
            titleLineBottom();
            double minPrice = 0;

            try {
                minPrice = Double.parseDouble(scanner.nextLine().trim().replaceAll("\\s+", ""));
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Input");
            }

            timer(1000);

            boolean found = false;
            for (Product product : inventory) {
                timer(100);
                if (userSearchMax >= product.getPrice() && minPrice <= product.getPrice() && product != null) {
                    newLineTop();
                    System.out.println(product.toString());
                    lineBottom();
                }
                found = true;
            } // For Loop End // Search Inventory By Key Term // --------------------------------------------------

            if (!found) {
                titleNewLineTop();
                System.out.println("No Product Found. Try Again");
                titleLineBottom();
            }


        } // While Loop End // Exits Method // ------------------------------------------------------------------------


    }

    public static void addProduct(ArrayList<Product> inventory, Scanner scanner, BufferedWriter lilTim) throws InterruptedException, NumberFormatException, IOException {
        timer(1000);
        boolean keepGoing = true;

        while (keepGoing) {
/// -----------------------------------------------------------------------------------------------------------------///
            titleNewLineTop();
            System.out.println("To add a new product enter 1. Otherwise enter 0 to exit.");
            System.out.println("(1) Add Product To Inventory");
            System.out.println("(0) Exit");
            titleLineBottom();

            System.out.print("\n\nEnter:  ");
            int userChoice = -1;

            try {
                userChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Input");
            }

            if (userChoice == 0) {
                System.out.println("\nReturning to Menu...");
                timer(1000);
                keepGoing = false;
                break;
            } else if (userChoice == 1) {
                boolean productRegistered = false;

/// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────///
                while (!productRegistered) {
                    String sku = newProductGetSKU(scanner);
/// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────///
                    String name = newProductGetName(scanner);
/// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────///
                    double price = newProductGetPrice(scanner);
/// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────///
                    String department = newProductGetNDepartment(scanner);

                     titleNewLineTop();
                    System.out.println("Compiling...");
                    titleLineBottom();

                    timer(1000);

///  ────────────────────────────────────────────────────────────────────────────────────────────────────────────────///
                    boolean confirmProduct = false;
                    while (!confirmProduct) {
                        titleNewLineTop();
                        System.out.println("SKU/ID: " + sku + "\nItem Name: " + name + "\nPrice: $" + price + "\nDepartment: " + department);
                        System.out.println("Is this information correct?");
                        System.out.println("\n(Y)es or (N)o?");
                        titleLineBottom();
                        char userConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userConfirm == 'Y') {
                            newLineTop();
                            System.out.println("Thanks for confirming!");
                            lineBottom();
                            confirmProduct = true;
                            break;
                        } else if (userConfirm == 'N') {
                            newLineTop();
                            System.out.println("What info needs editing?");
                            System.out.println("(1) SKU/ID\n(2) Name\n(3)Price\n(4)Department\n(5)Nothing. It is correct.");
                            lineBottom();
                            userConfirm = 0;
                            userConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

                            if (userConfirm == '1') {
                                sku = newProductGetSKU(scanner);
                            } else if (userConfirm == '2') {
                                name = newProductGetName(scanner);
                            } else if (userConfirm == '3') {
                                price = newProductGetPrice(scanner);
                            } else if (userConfirm == '4') {
                                department = newProductGetNDepartment(scanner);
                            } else if (userConfirm == '5') {
                                newLineTop();
                                System.out.println("Thanks for confirming!");
                                lineBottom();
                                confirmProduct = true;
                                break;
                            }
                        } else {
                            newLineTop();
                            System.out.println("Invalid Input. (Y) or (N)");
                        }
                    }

                    newLineTop();
                    System.out.println("Adding Item to Inventory...");
                    System.out.println("Please wait... Do not close app.");
                    lineBottom();

                    timer(2000);

                    try {
                        lilTim = new BufferedWriter(new FileWriter("products.csv", true));
                        lilTim.write("\n" + sku + "|" + name + "|" + price + "|" + department);
                        lilTim.flush();
                        Product newProduct = new Product(sku, name, price, department);
                        inventory.add(newProduct);
                    } catch (IOException ignored) { }


                    newLineTop();
                    System.out.println("Item has been successfully added!");
                    System.out.println("Do you need to add another item?");
                    System.out.println("(Y)es or (N)o");
                    lineBottom();
                    char userConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

                    if (userConfirm == 'Y') {
                        continue;
                    } else if (userConfirm == 'N') {
                        newLineTop();
                        System.out.println("Returning to Main Menu...");
                        lineBottom();
                        timer(1000);
                        keepGoing = false;
                        break;
                    } else {
                        newLineTop();
                        System.out.println("Invalid Input. (Y) or (N)");
                        lineBottom();
                    }


                }
                keepGoing = false;
                break;
            } else {
                System.out.println("\nInvalid Input. (1) or (2).");
            }
        }


    }


    // Back End // ----------------------------------------------------------------------------------------------------
    public static void setArray(Scanner scanner, ArrayList<Product> inventory, BufferedReader lilJon) throws IOException {
        lilJon = new BufferedReader(new FileReader("products.csv"));
        String lineReader = "";
        scanner = new Scanner(lilJon);
        scanner.nextLine(); // Skips Header // Learned From ChatGPT in the past // -----------------------------------

        for (int i = 0; scanner.hasNextLine(); i++) {
            lineReader = scanner.nextLine();
            String[] tempArray = lineReader.split("\\|"); // Splits LineReader Into Parts to Later Set Array // -

            try {
                Product newProduct = new Product(tempArray[0], tempArray[1], Double.parseDouble(tempArray[2]), tempArray[3]);
                inventory.add(newProduct);
            } catch (NumberFormatException e) { // Catch DPD // --------------------------------------------------------
                e.printStackTrace();
            }

        } // For Loop End // Scrolls Through Inventory To Set Array // ------------------------------------------------
    }

    public static String newProductGetSKU(Scanner scanner) throws InterruptedException {
        newLineTop();
        System.out.println("Enter Product SKU");
        lineBottom();
        System.out.print("Enter:  ");
        String sku = scanner.nextLine().trim().replaceAll("\\s+", "").toUpperCase();
        timer(500);
        newLineTop();
        System.out.println("Registered: [" + sku + "] as input for SKU");
        timer(500);
        lineBottom();
        return sku;
    }

    public static String newProductGetName(Scanner scanner) throws InterruptedException {
        newLineTop();
        System.out.println("Enter Product Name");
        lineBottom();
        System.out.print("Enter:  ");
        String nameInput = scanner.nextLine().trim().replaceAll("\\s+", " ").toLowerCase();
        String[] nameParts = nameInput.split(" ");
        for (int i = 0; i < nameParts.length; i++) {
            nameParts[i] = nameParts[i].substring(0, 1).toUpperCase() + nameParts[i].substring(1);
        }
        String name = String.join(" ", nameParts); // Chat
        newLineTop();
        System.out.println("Registered: [" + name + "] as input for name.");
        lineBottom();
        return name;
    }

    public static double newProductGetPrice(Scanner scanner) throws InterruptedException {
        double price = 0;
        while (price == 0) {
            newLineTop();
            System.out.println("Enter Product Price");
            lineBottom();
            System.out.print("Enter:  ");
            price = 0;
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid Input");
            }
            timer(500);
        }
        newLineTop();
        System.out.println("Registered: [$" + price + "] as input for price.");
        timer(500);
        lineBottom();
        return price;
    }

    public static String newProductGetNDepartment(Scanner scanner) throws InterruptedException {
        newLineTop();
        System.out.println("Enter Product Department");
        lineBottom();
        System.out.print("Enter:  ");
        String departmentInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
        timer(500);
        String[] departmentParts = departmentInput.split(" ");
        for (int i = 0; i < departmentParts.length; i++) {
            departmentParts[i] = departmentParts[i].substring(0, 1).toUpperCase() + departmentParts[i].substring(1);
        }
        String department = String.join(" ", departmentParts);
        newLineTop();
        System.out.println("Registered: [" + department + "] as input for Product Department.");
        lineBottom();
        timer(500);
        return department;
    }


    // Design Utility // ----------------------------------------------------------------------------------------------
    public static void titleNewLineTop () {
        System.out.println("\n☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F");
    }

    public static void titleLineBottom () {
        System.out.println("☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F");
    }

    public static void newLineTop() {
        System.out.println("\n───────────────────────────────────────────────────────────────");
    }

    public static void lineBottom() {
        System.out.println("───────────────────────────────────────────────────────────────");
    }

    public static void timer(int millis) throws InterruptedException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
