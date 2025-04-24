package com.pluralsight;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {

        //Introducing the System & Variables// ------------------------------------------------------------------------
        Employee[] employeeArray = new Employee[8];

        // Making employee Array ahead of time // ---------------------------------------------------------------------
        int index = -1;
        try (BufferedReader handlerManger = new BufferedReader(new FileReader("employees.csv"))) { // Resources Included in ().
            String input; // Declaring before use in loop // ----------------------------------------------------------

            while ((input = handlerManger.readLine()) != null && index < employeeArray.length) { // Uses resources to read a file and print line by line in loop.

                if (index > -1) { // Uses Index to bypass the header in the file // ----------------------------------
                    String[] tempArray = input.split("\\|"); // Uses input to split into parts for tempArray --
                    int tempID = Integer.parseInt(tempArray[0]); // Converts Part 1 into an int (ID) //---------------
                    String tempName = tempArray[1]; // Converts Part 2 into a String (NAME) // -----------------------
                    float tempHW = Float.parseFloat(tempArray[2]); // Converts Part 3 Into a float (HOURS WORKED) // -
                    float tempPR = Float.parseFloat(tempArray[3]); // Converts Part 4 Into a float (PAY RATE) // ------

                    Employee newEmployee = new Employee(tempID, tempName, tempHW, tempPR); // Plugs Temporary parts into temporary employee object
                    employeeArray[index] = newEmployee; // Plugs tempObject into a permanent employeeArray // --------
                }
                index++; // Updates for next iteration of the loop // -------------------------------------------------
            }

//            for (Employee employee : employeeArray) {
//                System.out.println("\nEmployee Logs-------------------");
//                System.out.println(employee);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

/// =================================================================================================================///

        boolean keepGoing = true;
        Scanner scanner = new Scanner(System.in);
        while (keepGoing) {
            System.out.println("\n------------------------------------");
            System.out.println("Hello User! This is a Payroll Processing/Reporting Application!");
            System.out.println("What services do you need today?");
            System.out.println("\n(1) Display Employee Logs & Employee Info.");
            System.out.println("(2) Download Report.");
            System.out.println("(0) Close App");
            System.out.print("Enter:  ");
            int userMenuChoice = 0;

            try {
                userMenuChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. Numbers Only.");
                System.out.println("-----------------------");
            } catch (InputMismatchException e) {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. Number our of Range.");
                System.out.println("-----------------------");
            }

            if (userMenuChoice == 1) {
                displayEmployeeLogs(employeeArray);
                keepGoing = returnSequence(scanner);
            } else if (userMenuChoice == 2) {
                downloadReport(scanner, employeeArray);
                keepGoing = returnSequence(scanner);
            } else if (userMenuChoice == 0) {
                System.out.println("Exit Sequence Initiated...");
                System.out.println("Just a sec...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("CodeBroke");
                    throw new RuntimeException();
                }

                keepGoing = false;
            } else {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. (1) or (2).");
                System.out.println("-----------------------");
            }

        }

    } // Main End // --------------------------------------------------------------------------------------------------

    public static void displayEmployeeLogs(Employee [] employeeArray) {
        System.out.println("Displaying Employee Data...");
        System.out.println("Just a sec...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Code Broke.");
            throw new RuntimeException();
        }

        // Variable Introductions // ----------------------------------------------------------------------------------

        int index = -1;


/// ================================================================================================================ ///
//======================================== // This was a Chat GPT suggestion // ======================================//
// ========= APA style: OpenAI. (2025). ChatGPT model (Version GPT-4). OpenAI. https://openai.com/chatgpt ============//
        // Try With Resources Syntax:   __ try () {} // __ (Resources ex: file reader, buff reader, etc... ) {  ...
        //...                          // File Gets Read Here                                                   ...
        // ...    }                    // Resources declared in () are auto-closed after try block
        // separate multiple resources with " ; ".
        // ALL RESOURCES MUUUUUSSSST BE AUTO CLOSABLE
/// ================================================================================================================ ///


        try (BufferedReader handlerManger = new BufferedReader(new FileReader("employees.csv"))) { // Resources Included in ().
            String input; // Declaring before use in loop // ----------------------------------------------------------

            while ((input = handlerManger.readLine()) != null && index < employeeArray.length) { // Uses resources to read a file and print line by line in loop.

                if (index > -1) { // Uses Index to bypass the header in the file // ----------------------------------
                    String[] tempArray = input.split("\\|"); // Uses input to split into parts for tempArray --
                    int tempID = Integer.parseInt(tempArray[0]); // Converts Part 1 into an int (ID) //---------------
                    String tempName = tempArray[1]; // Converts Part 2 into a String (NAME) // -----------------------
                    float tempHW = Float.parseFloat(tempArray[2]); // Converts Part 3 Into a float (HOURS WORKED) // -
                    float tempPR = Float.parseFloat(tempArray[3]); // Converts Part 4 Into a float (PAY RATE) // ------

                    Employee newEmployee = new Employee(tempID, tempName, tempHW, tempPR); // Plugs Temporary parts into temporary employee object
                    employeeArray[index] = newEmployee; // Plugs tempObject into a permanent employeeArray // --------

                    System.out.println("\n--------------------------------");
                    System.out.println(newEmployee.toString());
                    System.out.println("--------------------------------");
                }
                index++; // Updates for next iteration of the loop // -------------------------------------------------
            }

//            for (Employee employee : employeeArray) {
//                System.out.println("\nEmployee Logs-------------------");
//                System.out.println(employee);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean returnSequence(Scanner scanner) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("CodeBroke");
            throw new RuntimeException();
        }

        boolean closeApp = false;
        while (!closeApp) {
            System.out.println("\n--------------------------");
            System.out.println("Return to Menu or Exit?");
            System.out.println("(1) Return to Menu");
            System.out.println("(2) Exit");
            System.out.print("Enter:  ");
            int closeAppChoice = 0;

            try {
                closeAppChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. Numbers Only.");
                System.out.println("-----------------------");
            }

            if (closeAppChoice == 1) {
                System.out.println("Returning to Menu...");
                System.out.println("Just a sec...");
                return true;

            } else if (closeAppChoice == 2) {
                System.out.println("Exit Sequence Initiated...");
                System.out.println("Just a sec...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("CodeBroke");
                    throw new RuntimeException();
                }

                return false;
            } else {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. (1) or (2).");
                System.out.println("-----------------------");
            }

        }
        return closeApp;
    }

    public static void downloadReport(Scanner scanner, Employee [] employeeArray) {
        System.out.println("\n-----------------------------");
        System.out.println("Generating Report...");
        System.out.println("Just a sec...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Code Broke.");
            throw new RuntimeException();
        }

        System.out.println("\n-----------------------------");
        System.out.println("Report Successfully Generated!");

        String fileName = "";
        boolean fileNameConfirm = false;
        while (!fileNameConfirm) {
            System.out.println("\nPlease Enter File Name");
            System.out.print("Enter:  ");
            fileName = scanner.nextLine().trim().replaceAll("\\s+", " ").replaceAll(" ", "_");
            System.out.println("\nYou entered [" + fileName + "]");
            System.out.println("Is this correct? (Y) or (N)");
            System.out.print("Enter:  ");
            char fileConfirm = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (fileConfirm == 'Y') {
                System.out.println("\nThank you for confirming.");
            } else if (fileConfirm == 'N') {
                continue;
            } else {
                System.out.println("\n-----------------------");
                System.out.println("Invalid Input. (Y) or (N).");
                System.out.println("-----------------------");
            }

            String fileExtension = "";
            boolean fileExtConfirm = false;
            while (!fileNameConfirm) {
                System.out.println("\nPlease Choose a File Extension");
                System.out.println("(1) .csv");
                System.out.println("(2) .json");
                System.out.print("Enter:  ");
                int userExtConfirm = 0;

                try {
                    userExtConfirm = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("\n-----------------------");
                    System.out.println("Invalid Input. Numbers Only.");
                    System.out.println("-----------------------");
                } catch (InputMismatchException e) {
                    System.out.println("\n-----------------------");
                    System.out.println("Invalid Input. Number our of Range.");
                    System.out.println("-----------------------");
                }


                if (userExtConfirm == 1) {
                    System.out.println("\nThank you for confirming.");
                    fileExtension = ".csv";
                    fileNameConfirm = true;
                } else if (userExtConfirm == 2) {
                    System.out.println("\nThank you for confirming.");
                    fileExtension = ".json";
                    fileNameConfirm = true;
                } else {
                    System.out.println("\n-----------------------");
                    System.out.println("Invalid Input. (1) or (2).");
                    System.out.println("-----------------------");
                }
            }


            System.out.println("Creating new file...");
            System.out.println("Just a sec...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Code Broke.");
                throw new RuntimeException();
            }

            try (BufferedWriter writeToFile = new BufferedWriter( new FileWriter((fileName + fileExtension)))) {
                writeToFile.write("ID|NAME|GROSS PAY");
                for (Employee employee : employeeArray) {
                    writeToFile.write("\n" + employee.getEmployeeID() + "|" + employee.getEmployeeName() + "|" + employee.getGrossPay());
                }
            } catch (IOException e) {
                System.out.println("ERROR: An unexpected error occurred");
                e.printStackTrace();
            }

            System.out.println("Finishing up...");
            System.out.println("Almost Done...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Code Broke.");
                throw new RuntimeException();
            }

        }


    }
}