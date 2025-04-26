package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountingLedger {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        char function = welcomeScreen(scanner);
        int firstLoop = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            if (firstLoop > 1) {
                function = homeScreen(scanner);
            } if (firstLoop < 1) {
                firstLoop ++;
            }
            //------------------------------------------//
            while (function != 'X') {
                if (function == 'D') {
                    keepGoing = makeDeposit(scanner); if (!keepGoing) {break;}
                } else if (function == 'P') {

                } else if (function == 'L') {
                    function = accountLedgerScreen(scanner);
                } else if (function == 'X') {
                    exitSequence();
                } else {
                    System.out.println("\nInvalid Input. Please choose from listed options.");
                }
            }

            if (function == 'X') {
                exitSequence();
                keepGoing = false;
            }

        } // KeepGoing Loop End // ------------------------------------------------------------------------------------


    } // Main End // --------------------------------------------------------------------------------------------------

    // Welcome and Exit Sequences // ----------------------------------------------------------------------------------
    public static char welcomeScreen (Scanner scanner) {
        char userSelection = '0';
        boolean keepGoing = true;
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Welcome User! Use Account Ledger App to monitor and make transactions!\n" +
                    "What Service do you need today?\n\n" +
                    "(D) Make Deposit\n" +
                    "(P) Make Payment\n" +
                    "(L) Open Ledger to View & Manage\n" +
                    "(X) Exit App");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");
            userSelection = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (userSelection != 'D' && userSelection !='P' && userSelection != 'L' && userSelection != 'X') {
                System.out.println("\nPlease choose only from listed options. Or Enter X to exit.");
                continue;
            } else {
                return userSelection;
            }

        }
        return userSelection;
    }
    public static char homeScreen (Scanner scanner) {
        char userSelection = '0';
        boolean keepGoing = true;
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Welcome User! Use Account Ledger App to monitor and make transactions!\n" +
                    "What Service do you need today?\n\n" +
                    "(D) Make Deposit\n" +
                    "(P) Make Payment\n" +
                    "(L) Open Ledger to View & Manage\n" +
                    "(X) Exit App");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");
            userSelection = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (userSelection != 'D' && userSelection !='P' && userSelection != 'L' && userSelection != 'X') {
                System.out.println("\nPlease choose only from listed options. Or Enter X to exit.");
                continue;
            }


            keepGoing = false;
        }
        return userSelection;
    }
    public static void exitSequence () throws InterruptedException {
        titleNewLineTop();
        System.out.println("Thank you for using Account Ledger App!");
        System.out.println("Goodbye!");
        titleLineBottom();
        timer(1500);
    }

    // Functions // ---------------------------------------------------------------------------------------------------
    public static char accountLedgerScreen (Scanner scanner) {
        char userChoice = '!';
        boolean keepGoing = true;
        while (keepGoing) {
            userChoice = '!';
            titleNewLineTop();
            System.out.println("What Report Service Do You Need?\n" +
                    "(1) Month To Date Transactions\n" +
                    "(2) Previous Month Transactions\n" +
                    "(3) Year To Date Transactions\n" +
                    "(4) Previous Year Transactions\n" +
                    "(5) Search By Vendor\n" +
                    "(6) Custom Search\n" +
                    "(0) Go Back To Menu" +
                    "(X) Close App");

            userChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (userChoice != '1' || userChoice != '2' || userChoice != '3' || userChoice != '4' || userChoice != '5' || userChoice != '6' || userChoice != '0' || userChoice != 'X') {
                System.out.println("\nPlease Choose Only From Listed Options. Or Enter X To Exit.");
                continue;
            } else if (userChoice != 'X' || userChoice != '0'){
                ledgerReports(userChoice);
            } else if (userChoice == '0' || userChoice == 'X') {
                keepGoing = false;
                break;
            }
        } // Loop End //
        return userChoice;
    }
    public static void ledgerReports (char userChoice) {
        boolean keepGoing = true;
        int firstLoop = 0;
        while (keepGoing) {
            if (firstLoop > 1) {

            } if (firstLoop < 1) {
                firstLoop ++;
            }
        }
    }
    public static boolean makeDeposit (Scanner scanner) throws NumberFormatException, InterruptedException {
        double transactionAmnt = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Would you like to make a deposit?\n" +
                    "Enter deposit amount to enter 0 to return to menu.\n" +
                    "Or press (X) to close the app\n" +
                    "(0) Go back\n" +
                    "(X) Exit");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");

            // Catches Exit Sequence // -------------------------------------------------------------------------------
            String transactionInput = scanner.nextLine().trim().replaceAll("\\s+", "");
            keepGoing = allowUserToExitOrReturn(scanner, transactionInput); if (!keepGoing) {return keepGoing;}

            // If not Exit Sequence // --------------------------------------------------------------------------------
            try {

                transactionAmnt = Double.parseDouble(transactionInput);
            } catch (NumberFormatException ignored) {}

            timer(750);
            boolean descDone = false;
            String finalDesc = "";
            while (!descDone) {
                titleNewLineTop();
                System.out.println("In 300 character or less. Write a short description of the transaction." +
                        promptUser());
                titleLineBottom();
                System.out.print("\n\nEnter:  ");

                // Input // Catches Exit / Return Request // ----------------------------------------------------------
                String descInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
                keepGoing = allowUserToExitOrReturn(scanner, descInput); if (!keepGoing) {return keepGoing;}

                // If no exit / return call //-------------------------------------------------------------------------
                if (descInput.length() <= 300) {
                   finalDesc = autoLineBreakAt100UpTo300(descInput);
                   descDone = true;
                   break;
                } else {
                    System.out.println("Invalid Input or too many characters!");
                }
            }

            timer(750);
            String vendor = "";
            titleNewLineTop();
            System.out.println("Is this money coming from a company? Or a personal deposit.\n" +
                    "Enter the name of the company or simply enter (P) for a Personal Deposit\n" +
                    promptUser());
            titleLineBottom();
            System.out.print("\n\nEnter:  ");
            String vendorInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
            keepGoing = allowUserToExitOrReturn(scanner, vendorInput); if (!keepGoing) {return keepGoing;}

            if (vendorInput.equalsIgnoreCase("P")) {
                vendor = "Personal Deposit";
            } else {
                vendor = autoCapitalizeFirstLetter(vendorInput);
            }


            // (".*[^a-zA-Z0-9 ].*")
            boolean confirmTransaction = false;
            while (!confirmTransaction) {
                newLineTop();
                System.out.println("Amount: [$" + transactionAmnt + "] Entered\n" +
                        "Description: " + finalDesc + "\n" +
                        "Vendor: " + vendor);
                lineBottom();
                System.out.println("\nIs this info correct? (Y) or (N)\n" +
                        "(Y)es or (N)o?");
                char userConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

                if (userConfirm == 'Y') {
                    confirmTransaction = true;
                    break;
                } else if (userConfirm == 'N') {
                    timer1000();
                    boolean confirmInfo = false;
                    while (!confirmInfo) {
                        titleNewLineTop();
                        System.out.println("(1) Amount: [$" + transactionAmnt + "] Entered\n" +
                                "(2) Description: " + finalDesc + "\n" +
                                "(3) Vendor: " + vendor);
                        System.out.println("Which part needs to be fixed?\n\n" +
                                "(1) Amount\n" +
                                "(2) Description\n" +
                                "(3) Vendor\n" +
                                "(4) Nothing, it looks fine.");
                        titleLineBottom();
                        char pickPart = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (pickPart == '1') {
                            titleNewLineTop();
                            System.out.println("Please Enter Amount.");
                            titleLineBottom();
                            System.out.print("\n\nEnter:  ");
                            transactionAmnt = Double.parseDouble(scanner.nextLine().trim().replaceAll("\\s+", " "));
                            break;
                        } else if (pickPart == '2') {
                            boolean reEnterDesc = false;
                            while (!reEnterDesc) {
                                titleNewLineTop();
                                System.out.println("In 300 character or less. Write a short description of the transaction.");
                                titleLineBottom();
                                System.out.print("\n\nEnter:  ");
                                String descInput = scanner.nextLine().trim().replaceAll("\\s+", " ");

                                if (descInput.length() <= 300) {
                                    finalDesc = autoLineBreakAt100UpTo300(descInput);
                                    break;
                                } else {
                                    System.out.println("Invalid Input or too many characters!");
                                }
                            }
                        } else if (pickPart == '3') {
                            titleNewLineTop();
                            System.out.println("Is this money coming from a company? Or a personal deposit.\n" +
                                    "Enter the name of the company or simply enter (P) for a Personal Deposit\n");
                            titleLineBottom();
                            System.out.print("\n\nEnter:  ");
                            vendorInput = scanner.nextLine().trim().replaceAll("\\s+", " ");

                            if (vendorInput.equalsIgnoreCase("P")) {
                                vendor = "Personal Deposit";
                            } else {
                                vendor = autoCapitalizeFirstLetter(vendorInput);
                            }

                            break;
                        } else if (pickPart == '4') {
                            break;
                        } else {
                            System.out.println("\n Invalid Input. Please choose from listed options.");
                        }

                    }

                } else {
                    System.out.println("\nInvalid Input. (Y) or (N).");
                }
            } // TC Loop End // ---------------------------------------------------------------------------------------

            titleNewLineTop();
            System.out.println("Thank you for your deposit and continued use of Account Ledger App!");
            System.out.println("Do you need to make another deposit? (Y) or (N)");
            System.out.println("(Y)es or (N)o?");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");
            char userConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (userConfirm == 'Y') {
                newLineTop();
                System.out.println("Setting up next transaction...");
                lineBottom();
                timer(500);

            } else if (userConfirm == 'N') {
                keepGoing = false;

            } else {
                System.out.println("\nInvalid Input. Please choose from listed options.");
            }

            return keepGoing;
        } // Keep Going End // ----------------------------------------------------------------------------------------
        return keepGoing;
    }

    // Back End // ----------------------------------------------------------------------------------------------------
    public static void transactionLogger (double transactionAmnt) throws IOException, NumberFormatException {
        LocalDate dateInput = LocalDate.now();
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateInput.format(formatterD);
        LocalTime timeInput = LocalTime.now();
        DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = timeInput.format(formatterT);
        try {
            BufferedWriter lilJon = new BufferedWriter(new FileWriter("transactions.csv"));
            lilJon.write(date + "|" + time + "|" + transactionAmnt);
            lilJon.flush();
        } catch (IOException ignored) {}
    }
    public static void activityLogger (String action) throws IOException {
        LocalDate dateInput = LocalDate.now();
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateInput.format(formatterD);
        LocalTime timeInput = LocalTime.now();
        DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = timeInput.format(formatterT);
        try {
            BufferedWriter lilJon = new BufferedWriter(new FileWriter("logs.txt"));
            lilJon.write(date + "|" + time + "|" + action);
            lilJon.flush();
        } catch (IOException ignored) {}
    }
    public static double currentBalance (Scanner scanner) {
        double transaction = 0;
        double totalDebits = 0;
        double totalDeposits = 0;
        scanner = new Scanner("transactions.csv");
        scanner.nextLine();

        for (int i = 0; scanner.hasNextLine(); i++) {
            String [] input = scanner.nextLine().split("|");
            try {
                transaction = Double.parseDouble(input[4]);
            } catch (NumberFormatException ignored) {}

            if (transaction > 0) {
                totalDeposits += transaction;
            } else if (transaction < 0) {
                totalDebits += transaction;
            }
        }
        double balance = totalDeposits + totalDebits;
        return balance;
    }
    public static boolean allowUserToExitOrReturn (Scanner scanner, String input) throws NumberFormatException {
        boolean keepGoing = true;
        input = input.trim().replaceAll("\\s+", " ");
        if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("0")) {
            if (input.equalsIgnoreCase("0")) {System.out.println("Returning to menu..."); timer1500();}
            keepGoing = false;
        }
        char dcInput = input.toUpperCase().charAt(0);
        if (dcInput == '0' || dcInput == 'X') {
            if (dcInput == '0') {System.out.println("Returning to menu..."); timer1500();}
            keepGoing = false;
        }
        return keepGoing;
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
    public static void timer1500 () {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void timer1000 () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String promptUser () {
        return "You can also enter (0) to return to menu, or (X) to exit app.";

    }
    public static String autoLineBreakAt100UpTo300 (String input) {
        String returnInput = "";
        if (input.length() > 100) {
            while (input.length() > 100) {
                int breaker = input.lastIndexOf(' ', 100);
                returnInput += input.substring(0, breaker) + "\n";
                input = input.substring(breaker + 1);
            }
            returnInput += input;
        } if (input.length() < 100) {
            returnInput = input;
        }
        return returnInput;
    }
    public static String autoCapitalizeFirstLetter (String input) {
        String [] inputParts = input.toLowerCase().split(" ");
        for (int i = 0; i < inputParts.length; i++) {
            inputParts [i] = inputParts [i].substring(0, 1).toUpperCase() + inputParts [i].substring(1);
        }
        input = String.join(" ", inputParts);
        return input;
    }


}
