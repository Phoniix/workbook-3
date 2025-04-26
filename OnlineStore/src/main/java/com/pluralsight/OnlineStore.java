package com.pluralsight;

import java.io.*;
import java.util.*;

public class OnlineStore {


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader lilTim = new BufferedReader(new FileReader("products.csv"));
        BufferedWriter lilJon = new BufferedWriter(new FileWriter("products.csv"));
        ArrayList<Product> inventory = new ArrayList<>();
        setArray(scanner, inventory, lilTim);
        boolean keepGoing = true;
        int function = -5;

        while (keepGoing) {
            function = welcomeMenu(scanner);

            if (function == 1) {
                displayProducts(scanner, inventory);
            } else if (function == 2) {
                //displayCart();
            } else if (function == 0) {
                exitSequence(scanner);
            } else {
                continue;
            }

        }


        scanner.close();
        lilJon.close();
    } // Main End // --------------------------------------------------------------------------------------------------

    // Welcome and Exit Sequences // ----------------------------------------------------------------------------------
        public static int welcomeMenu (Scanner scanner) throws InterruptedException {
        int userChoice = -5;
        boolean keepGoing = true;
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Welcome User! This is your local Online Store!");
            System.out.println("What service do you need? Enter 1-3. Or enter 0 to exit the app.");
            System.out.println("\n(0) Exit");
            System.out.println("(1) View/Display Products");
            System.out.println("(2) View/Display Cart");
            System.out.println("(3) Checkout");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");

            try {
                userChoice = Integer.parseInt(scanner.nextLine().trim());

                if (!(userChoice >= 0) && !(userChoice <=3)) {
                    System.out.println("\nInvalid Input. Please choose a listed option.");
                }
            } catch (NumberFormatException ignored) {}
            keepGoing = false;
        } // Menu Loop End // ---------------------------------------------------------------------------------
        return userChoice;
        }

        public static void exitSequence (Scanner scanner) throws InterruptedException {

        }
    // Functions Of Program // ----------------------------------------------------------------------------------------
        public static void checkout (Scanner scanner, BufferedWriter lilJon) throws IOException, InterruptedException {

        }

        public static void displayProducts(Scanner scanner, ArrayList<Product> inventory) throws InterruptedException {
        System.out.println("\nDisplaying Products...");
        timer(1500);
        inventory.sort(Comparator.comparing(product -> product.getName()));
        for (int i = 0; i < inventory.size(); i++) {
            timer(150);
            newLineTop();
            Product p = inventory.get(i);
            System.out.println("ID: " + p.getSku() + " " + p.getName() + " - Price: " + p.getPrice());
        }
    }

        public static void displayCart () {

        }
    // Back End // ----------------------------------------------------------------------------------------------------
    public static void setArray(Scanner scanner, ArrayList<Product> inventory) throws IOException {
        scanner = new Scanner("products.csv");
        scanner.nextLine();

        for (int i =0; scanner.hasNextLine(); i++) {
            try {

            }
        }
    }
    // Design Elements // ---------------------------------------------------------------------------------------------
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
















} // Class End // -----------------------------------------------------------------------------------------------------
