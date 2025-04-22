package com.pluralsight;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BedtimeStories {


    public static void main(String[] args) {

        //Variable Introductions // -----------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        // Introducing the System // ----------------------------------------------------------------------------------
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\n----------------------------------------------");
            System.out.println("Hello User! There are 3 bedtime stories available on this app!");
            System.out.println("\n(1) Goldilocks and the Three Bears");
            System.out.println("(2) Hansel and Gretel");
            System.out.println("(3) Mary Had A Little Lamb");
            System.out.println("Which would you like to have read? Simply enter 1-3.");
            System.out.println("\n----------------------------------------------");
            System.out.print("Enter:  ");
            int userMenuChoice = 0;

            try {
                userMenuChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\n-----------------------------");
                System.out.println("Invalid Input. Numbers Only.");
                System.out.println("-----------------------------");
            } catch (InputMismatchException e) {
                System.out.println("\n--------------------------------------");
                System.out.println("Invalid Input. Numbers out of range.");
                System.out.println("----------------------------------------");
            }

            if (userMenuChoice == 1) {
                System.out.println("\nBANGER story incoming...");
                System.out.println("Just wait, you'll see...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                theGoldilocksMethod(scanner);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                boolean returnConfirm = false;
                while (!returnConfirm) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("Wow! I love this tale. How about you?");
                    System.out.println("Would you like to read another story?");
                    System.out.println("(Y)es or (N)o. (Y) or (N)?");
                    System.out.println("----------------------------------------");
                    char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                    if (userReturnChoice == 'Y') {
                        System.out.println("Returning to menu...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }
                        returnConfirm = true;
                    } else if (userReturnChoice == 'N') {
                        System.out.println("Initiating exit sequence...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }

                        returnConfirm = true;
                        keepGoing = false;
                    } else {
                        System.out.println("\n-----------------------------");
                        System.out.println("Invalid Input. (Y) or (N)).");
                        System.out.println("-----------------------------");
                    }
                }

            } else if (userMenuChoice == 2) {
                System.out.println("\nCRAZY story incoming...");
                System.out.println("Just wait, you'll see...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                theHAGMethod(scanner);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                boolean returnConfirm = false;
                while (!returnConfirm) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("Wow! I love this tale. How about you?");
                    System.out.println("Would you like to read another story?");
                    System.out.println("(Y)es or (N)o. (Y) or (N)?");
                    System.out.println("----------------------------------------");
                    char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                    if (userReturnChoice == 'Y') {
                        System.out.println("Returning to menu...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }
                        returnConfirm = true;
                    } else if (userReturnChoice == 'N') {
                        System.out.println("Initiating exit sequence...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }

                        returnConfirm = true;
                        keepGoing = false;
                    } else {
                        System.out.println("\n-----------------------------");
                        System.out.println("Invalid Input. (Y) or (N)).");
                        System.out.println("-----------------------------");
                    }
                }
            } else if (userMenuChoice == 3) {
                System.out.println("\nPEACEFUL story incoming...");
                System.out.println("Just wait, you'll see...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                theMHALLMethod(scanner);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke.");
                    throw new RuntimeException();
                }

                boolean returnConfirm = false;
                while (!returnConfirm) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("Wow! I love this tale. How about you?");
                    System.out.println("Would you like to read another story?");
                    System.out.println("(Y)es or (N)o. (Y) or (N)?");
                    System.out.println("----------------------------------------");
                    char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                    if (userReturnChoice == 'Y') {
                        System.out.println("Returning to menu...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }
                        returnConfirm = true;
                    } else if (userReturnChoice == 'N') {
                        System.out.println("Initiating exit sequence...");
                        System.out.println("Just a sec...");

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Code Broke.");
                            throw new RuntimeException();
                        }

                        returnConfirm = true;
                        keepGoing = false;
                    } else {
                        System.out.println("\n-----------------------------");
                        System.out.println("Invalid Input. (Y) or (N)).");
                        System.out.println("-----------------------------");
                    }
                }
            } else {
                System.out.println("\n-----------------------------");
                System.out.println("Invalid Input. 1, 2 or 3 only.");
                System.out.println("-----------------------------");
            }


        }



    }

    public static void theGoldilocksMethod (Scanner scanner) {
        try {
            FileInputStream fileHandler = new FileInputStream("goldilocks.txt");
            scanner = new Scanner(fileHandler);
            String input = "";
            int lineCounter = 0;

            while (scanner.hasNextLine()) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke");
                    throw new RuntimeException();
                }

                input = scanner.nextLine();
                lineCounter ++;
                System.out.println("[" + lineCounter + "]" + input);
            }
        } catch (IOException e) {
            System.out.println("Code Broke.");
            e.printStackTrace();
        }
    }

    public static void theHAGMethod (Scanner scanner) {
        try {
            FileInputStream fileHandler = new FileInputStream("hansel_and_gretel.txt");
            scanner = new Scanner(fileHandler);
            String input = "";
            int lineCounter = 0;

            while (scanner.hasNextLine()) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke");
                    throw new RuntimeException();
                }

                input = scanner.nextLine();
                lineCounter ++;
                System.out.println("[" + lineCounter + "]" + input);
            }
        } catch (IOException e) {
            System.out.println("Code Broke.");
            e.printStackTrace();
        }
    }

    public static void theMHALLMethod (Scanner scanner) {
        try {
            FileInputStream fileHandler = new FileInputStream("mary_had_a_little_lamb.txt");
            scanner = new Scanner(fileHandler);
            String input = "";
            int lineCounter = 0;

            while (scanner.hasNextLine()) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Code Broke");
                    throw new RuntimeException();
                }

                input = scanner.nextLine();
                lineCounter ++;
                System.out.println("[" + lineCounter + "]" + input);
            }
        } catch (IOException e) {
            System.out.println("Code Broke.");
            e.printStackTrace();
        }
    }




}
