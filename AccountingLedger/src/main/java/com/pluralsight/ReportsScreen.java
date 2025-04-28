package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.pluralsight.AccountingLedger.*;

public class ReportsScreen {

    public static ResultHelper reportsScreen (Scanner scanner) throws IOException, InterruptedException {
        boolean keepGoing = true;
        while (keepGoing) {
            titleNewLineTop();
            System.out.println("Welcome To Your Account Ledger Reporting\n" +
                    "What service do you need?\n\n" +
                    "(1) (MTD) Month To Date Transactions)\n" +
                    "(2) (PM) Previous Month Transactions\n" +
                    "(3) (YTD) Year To Date Transactions\n" +
                    "(4) (PY) Previous Year Transactions\n" +
                    "(5) (SBV) Search By Vendor\n" +
                    "(6) (CS) Custom Search // Coming Soon\n" +
                    "(L) Return To Ledger Screen\n" +
                    "(0) Return To Main Menu\n" +
                    "(X) Exit Program");
            titleLineBottom();
            System.out.print("\n\nEnter:  ");
            String userSelectionInput = scanner.nextLine().trim().replaceAll("\\s+", "");
            ResultHelper usi = allowUserToExitOrReturn(userSelectionInput); if (returner(usi)) {return usi;}
            char userSelection = userSelectionInput.toUpperCase().charAt(0);

            if (userSelection == '1') {
                ResultHelper mtd = monthToDate(scanner);
               if (returner(mtd)) {return mtd;}
            } else if (userSelection == '2') {
                ResultHelper prevMonth = previousMonth(scanner);
                if (returner(prevMonth)) {return prevMonth;}
            } else if (userSelection == '3') {
                ResultHelper ytd = yearToDate(scanner);
                if (returner(ytd)) {return ytd;}
            } else if (userSelection == '4') {
                ResultHelper prevYear = previousYear(scanner);
                if (returner(prevYear)) {return prevYear;}
            } else if (userSelection == '5') {
                ResultHelper sbv = searchByVendor(scanner);
                if (returner(sbv)) {return sbv;}
            } else if (userSelection == '6') {
                ResultHelper sba = searchByAnything(scanner);
                if (returner(sba)) {return sba;}
            } else if (userSelection == 'L') {
                ResultHelper ledger = LedgerScreen.ledgerScreen(scanner);
                if (returner(ledger)) {return ledger;}
            }
        }
        return new ResultHelper('z', true);
    }

    // Functions // ---------------------------------------------------------------------------------------------------
    public static ResultHelper monthToDate (Scanner scanner) throws IOException, InterruptedException {
        BufferedReader lilJon = new BufferedReader(new FileReader("transactions.csv"));
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();
        LocalDate targetDate = LocalDate.of(todayYear, todayMonth, todayDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        scanner = new Scanner(lilJon);
        scanner.nextLine();

        System.out.println("\n");
        boolean found = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineParts = line.split("\\|");
            if (lineParts.length > 1) {
                String getTransactionDate = lineParts[0];
                LocalDate transactionDate = LocalDate.parse(getTransactionDate, formatter);
                if (transactionDate.getMonth() == targetDate.getMonth() && transactionDate.getYear() == targetDate.getYear()) {
                    timer(110);
                    System.out.println(line);
                    lineBottom();
                    found = true;
                }
            }
        }
        if (!found) {
            newLineTop();
            System.out.println("No Results Found.");
            lineBottom();
        }

        boolean goToLedger = false;
        Scanner userInput = new Scanner(System.in);
        while (!goToLedger) {
            titleNewLineTop();
            System.out.println("Here are your (MTD) month to date transactions!");
            System.out.println(promptUser());
            System.out.println("(R) Go Back To Reports Menu");
            System.out.println("(L) Go Back To Ledger Menu");
            System.out.println("(0) Go Back To Main Menu");
            System.out.println("(X) Exit");
            titleLineBottom();
            String userChoiceInput = userInput.nextLine().trim().replaceAll("\\s+", "");
            ResultHelper uci = allowUserToExitOrReturn(userChoiceInput); if (returner(uci)) {return uci;}
            char userChoice = userChoiceInput.toUpperCase().charAt(0);

            if (userChoice == 'L') {
                ResultHelper ledger = LedgerScreen.ledgerScreen(userInput);
                if (returner(ledger)) {return ledger;}
            } else if (userChoice == '0') {
                return new ResultHelper('0', true);
            } else if (userChoice == 'R') {
                return new ResultHelper('R', true);
            } else {
                System.out.println("\nInvalid Input. Please choose from listed options.");
            }
        }

        return new ResultHelper('0', true);
    }

    public static ResultHelper previousMonth (Scanner scanner) throws IOException, InterruptedException {
        BufferedReader lilJon = new BufferedReader(new FileReader("transactions.csv"));
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();
        int targetMonth = todayMonth - 1;
        int targetYear = todayYear;
        LocalDate targetDate = null;
        if (targetMonth == 0) { // Handles The Case of Previous Month Being December In January // --------------------
            targetMonth = 12;
            targetYear -= 1;
        }
        targetDate = LocalDate.of(targetYear, targetMonth, todayDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        scanner = new Scanner(lilJon);
        scanner.nextLine();

        System.out.println("\n");
        boolean found = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineParts = line.split("\\|");
            if (lineParts.length > 1) {
                String getTransactionDate = lineParts[0];
                LocalDate transactionDate = LocalDate.parse(getTransactionDate, formatter);
                if (transactionDate.getMonth() == targetDate.getMonth() && transactionDate.getYear() == targetDate.getYear()) {
                    timer(110);
                    System.out.println(line);
                    lineBottom();
                    found = true;
                }
            }
        }
        if (!found) {
            newLineTop();
            System.out.println("No Results Found.");
            lineBottom();
        }

        boolean goToLedger = false;
        Scanner userInput = new Scanner(System.in);
        while (!goToLedger) {
            titleNewLineTop();
            System.out.println("Here are your (PV) previous month transactions!");
            System.out.println(promptUser());
            System.out.println("(R) Go Back To Reports Menu");
            System.out.println("(L) Go Back To Ledger Menu");
            System.out.println("(0) Go Back To Main Menu");
            System.out.println("(X) Exit");
            titleLineBottom();
            String userChoiceInput = userInput.nextLine().trim().replaceAll("\\s+", "");
            ResultHelper uci = allowUserToExitOrReturn(userChoiceInput); if (returner(uci)) {return uci;}
            char userChoice = userChoiceInput.toUpperCase().charAt(0);

            if (userChoice == 'L') {
                ResultHelper ledger = LedgerScreen.ledgerScreen(userInput);
                if (returner(ledger)) {return ledger;}
            } else if (userChoice == '0') {
                return new ResultHelper('0', true);
            } else if (userChoice == 'R') {
                return new ResultHelper('R', true);
            } else {
                System.out.println("\nInvalid Input. Please choose from listed options.");
            }
        }

        return new ResultHelper('0', true);
    }

    public static ResultHelper yearToDate (Scanner scanner) throws IOException, InterruptedException {
        BufferedReader lilJon = new BufferedReader(new FileReader("transactions.csv"));
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();
        LocalDate targetDate = LocalDate.of(todayYear, todayMonth, todayDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        scanner = new Scanner(lilJon);
        scanner.nextLine();

        System.out.println("\n");
        boolean found = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineParts = line.split("\\|");
            if (lineParts.length > 1) {
                String getTransactionDate = lineParts[0];
                LocalDate transactionDate = LocalDate.parse(getTransactionDate, formatter);
                if (transactionDate.getYear() == targetDate.getYear()) {
                    timer(110);
                    System.out.println(line);
                    lineBottom();
                    found = true;
                }
            }
        }
        if (!found) {
            newLineTop();
            System.out.println("No Results Found.");
            lineBottom();
        }

        boolean goToLedger = false;
        Scanner userInput = new Scanner(System.in);
        while (!goToLedger) {
            titleNewLineTop();
            System.out.println("Here are your (YTD) year to date transactions!");
            System.out.println(promptUser());
            System.out.println("(R) Go Back To Reports Menu");
            System.out.println("(L) Go Back To Ledger Menu");
            System.out.println("(0) Go Back To Main Menu");
            System.out.println("(X) Exit");
            titleLineBottom();
            String userChoiceInput = userInput.nextLine().trim().replaceAll("\\s+", "");
            ResultHelper uci = allowUserToExitOrReturn(userChoiceInput); if (returner(uci)) {return uci;}
            char userChoice = userChoiceInput.toUpperCase().charAt(0);

            if (userChoice == 'L') {
                ResultHelper ledger = LedgerScreen.ledgerScreen(userInput);
                if (returner(ledger)) {return ledger;}
            } else if (userChoice == '0') {
                return new ResultHelper('0', true);
            } else if (userChoice == 'R') {
                return new ResultHelper('R', true);
            } else {
                System.out.println("\nInvalid Input. Please choose from listed options.");
            }
        }

        return new ResultHelper('0', true);
    }

    public static ResultHelper previousYear (Scanner scanner) throws IOException, InterruptedException {
        BufferedReader lilJon = new BufferedReader(new FileReader("transactions.csv"));
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();
        LocalDate targetDate = LocalDate.of(todayYear - 1, todayMonth, todayDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        scanner = new Scanner(lilJon);
        scanner.nextLine();
        System.out.println("\n");
        boolean found = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineParts = line.split("\\|");
            if (lineParts.length > 1) {
                String getTransactionDate = lineParts[0];
                LocalDate transactionDate = LocalDate.parse(getTransactionDate, formatter);
                if (transactionDate.getYear() == targetDate.getYear()) {
                    timer(110);
                    System.out.println(line);
                    lineBottom();
                    found = true;
                }
            }
        }
        if (!found) {
            newLineTop();
            System.out.println("No Results Found.");
            lineBottom();
        }

        boolean goToLedger = false;
        Scanner userInput = new Scanner(System.in);
        while (!goToLedger) {
            titleNewLineTop();
            System.out.println("Here are your (PY) previous year transactions!");
            System.out.println(promptUser());
            System.out.println("(R) Go Back To Reports Menu");
            System.out.println("(L) Go Back To Ledger Menu");
            System.out.println("(0) Go Back To Main Menu");
            System.out.println("(X) Exit");
            titleLineBottom();
            String userChoiceInput = userInput.nextLine().trim().replaceAll("\\s+", "");
            ResultHelper uci = allowUserToExitOrReturn(userChoiceInput); if (returner(uci)) {return uci;}
            char userChoice = userChoiceInput.toUpperCase().charAt(0);

            if (userChoice == 'L') {
                ResultHelper ledger = LedgerScreen.ledgerScreen(userInput);
                if (returner(ledger)) {return ledger;}
            } else if (userChoice == '0') {
                return new ResultHelper('0', true);
            } else if (userChoice == 'R') {
                return new ResultHelper('R', true);
            } else {
                System.out.println("\nInvalid Input. Please choose from listed options.");
            }
        }

        return new ResultHelper('0', true);
    }

    public static ResultHelper searchByVendor (Scanner scanner) throws IOException, InterruptedException {

        Scanner userInput = new Scanner(System.in);
        titleNewLineTop();
        System.out.println("Here you can search by vendor name.\n" +
                "If you are searching for personal deposits or withdraws you can enter (P).\n" +
                promptUser());
        titleLineBottom();
        System.out.print("\n\nEnter:  ");
        String userInputInput = userInput.nextLine().trim().replaceAll("\\s+", " ");
        ResultHelper uii = allowUserToExitOrReturn(userInputInput); if (returner(uii)) {return uii;}
        if (userInputInput.equalsIgnoreCase("P")) {userInputInput = "Personal";}

        boolean doneSearching = false;
        boolean found = false;
        while (!doneSearching) {
            BufferedReader lilJon = new BufferedReader(new FileReader("transactions.csv"));
            scanner = new Scanner(lilJon);
            scanner.nextLine();
            System.out.println("\n");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineParts = line.split("\\|");
                if (lineParts.length > 3) {
                    String vendor = lineParts[3];
                    if (vendor.toLowerCase().contains(userInputInput.toLowerCase())) {
                        timer(110);
                        System.out.println(line);
                        lineBottom();
                        found = true;
                    }
                }
            }
            if (!found) {
                newLineTop();
                System.out.println("No Results Found For " + userInputInput);
                lineBottom();
            }

            boolean goToLedger = false;
            while (!goToLedger) {
                titleNewLineTop();
                System.out.println("Here are transactions matching your search!");
                System.out.println("You can also start another search here.");
                System.out.println(promptUser());
                System.out.println("(R) Go Back To Reports Menu");
                System.out.println("(L) Go Back To Ledger Menu");
                System.out.println("(0) Go Back To Main Menu");
                System.out.println("(X) Exit");
                titleLineBottom();
                System.out.print("\n\nEnter:  ");
                String userChoiceInput = userInput.nextLine().trim().replaceAll("\\s+", "");
                ResultHelper uci = allowUserToExitOrReturn(userChoiceInput);
                if (returner(uci)) {return uci;}

                char userChoice = userChoiceInput.toUpperCase().charAt(0);

                if (userChoice == 'L') {
                    ResultHelper ledger = LedgerScreen.ledgerScreen(userInput);
                    if (returner(ledger)) {
                        return ledger;
                    }
                } else if (userChoice == '0') {
                    return new ResultHelper('0', true);
                } else if (userChoice == 'R') {
                    return new ResultHelper('R', true);
                } else {
                    userInputInput = userChoiceInput;
                    goToLedger = true;
                }
            }
        }

        return new ResultHelper('0', true);
    }

    public static ResultHelper searchByAnything (Scanner scanner) throws  IOException, InterruptedException {
        Scanner userInput = new Scanner(System.in);
        boolean doneSearching = false;
        while (!doneSearching) {
            titleNewLineTop();
            System.out.println("Here you can search by a variety of factors that include:\n" +
                    "Start Date, End Date, Description, Vendor, or Amount.\n" +
                    promptUser());
            System.out.println("(L) Return To Ledger Menu");
            System.out.println("(R) Return to Reports Menu");
            System.out.println("(0) Return to Main Menu");
            System.out.println("(X) Exit");
            lineBottom();
            System.out.print("\n\nEnter:  ");
            String userInputInput = userInput.nextLine().trim().replaceAll("\\s+", " ");
            ResultHelper uii = allowUserToExitOrReturn(userInputInput); if (returner(uii)) {return uii;}

            expectedSBAInputs expecting = expectedSBAInputs.DATE;

            if (expecting == expectedSBAInputs.DATE) {
                if (isDate(userInputInput)) {
                    boolean confirmStartVSEnd = false;
                    while (!confirmStartVSEnd) {
                        titleNewLineTop();
                        System.out.println("Date Entered: " + userInputInput);
                        System.out.println("Is this the date you want to start a search from?\n" +
                                "Or Is this the date you want to stop displaying results after?\n" +
                                promptUser() + "\n" +
                                "(S) Start Date\n" +
                                "(E) End Date");
                        titleLineBottom();
                        System.out.print("\n\nEnter:  ");


                    }

                    expecting =  expectedSBAInputs.DESCRIPTION;
                } else {
                    System.out.println("\nInvalid Date. Please use yyyy-mm-dd format.");
                }
            } else if (expecting == expectedSBAInputs.DESCRIPTION) {
                if (!userInputInput.isEmpty()) {
                    System.out.println("Description Entered: " + userInputInput);
                    expecting = expectedSBAInputs.VENDOR;
                } else {
                    System.out.println("This Field Cannot Be Empty");
                }
            } else if (expecting == expectedSBAInputs.VENDOR) {
                if (!userInputInput.isEmpty()) {
                    System.out.println("Vendor Entered: " + userInputInput);
                    expecting = expectedSBAInputs.AMOUNT;
                } else {
                    System.out.println("This Field Cannot Be Empty");
                }
            } else if (expecting == expectedSBAInputs.AMOUNT) {
                if (isAmount(userInputInput)) {
                    System.out.println("Amount Entered: " + userInputInput);
                } else {
                    System.out.println("Invalid Amount. Enter a number like 10.00 or 12.99.");
                }
            }
        }

        return new ResultHelper('0', true);
    }

    // Back End // ----------------------------------------------------------------------------------------------------
    enum expectedSBAInputs {
        DATE, DESCRIPTION, VENDOR, AMOUNT
    }
    public static boolean isDate (String input) {
        try {
            LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean isAmount (String input) {
        return input.matches("-?\\d+(\\.\\d{1,2})?");
    }
    public static boolean isVendor (String input) {
        return !input.isEmpty() && !input.matches("\\d+") && input.split(" ").length > 1;
    }
    public static boolean isDescription (String input) {
        return !input.isEmpty() && !input.matches("\\d+") && input.split(" ").length <= 2;
    }
    public static void searchByDate (String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
    }


}
