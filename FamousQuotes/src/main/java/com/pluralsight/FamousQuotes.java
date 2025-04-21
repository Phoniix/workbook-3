package com.pluralsight;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        // Variable Introduction // -----------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        String [] famousQuotes = new String [10];

        // Quotes (Also Variables) //  Also 100% used ChatGPT to provide quotes in (quoteNumber format) to save time---
        String quoteOne = " ' The only limit to our realization of tomorrow is our doubts of today. ' \n- Franklin D. Roosevelt";
        String quoteTwo = " ' In the middle of difficulty lies opportunity. '  \n- Albert Einstein";
        String quoteThree = " ' Success is not final, failure is not fatal: It is the courage to continue that counts.  ' \n- Winston Churchill";
        String quoteFour = " ' Do not go where the path may lead, go instead where there is no path and leave a trail. ' \n- Ralph Waldo Emerson";
        String quoteFive = " ' Life is what happens when you're busy making other plans.  ' \n- John Lennon";
        String quoteSix = " ' The future belongs to those who believe in the beauty of their dreams. '  - Eleanor Roosevelt";
        String quoteSeven = " ' It does not matter how slowly you go as long as you do not stop. '  \n- Confucius";
        String quoteEight = " ' Believe you can and you're halfway there. '  \n- Theodore Roosevelt";
        String quoteNine = " ' What lies behind us and what lies before us are tiny matters compared to what lies within us. '  \n- Ralph Waldo Emerson";
        String quoteTen = " ' Happiness is not something ready made. It comes from your own actions. '  \n- Dalai Lama";

        // Placing the quotes into the array (This is me again, not ChatGPT) ------------------------------------------
        famousQuotes [0] = quoteOne;
        famousQuotes [1] = quoteTwo;
        famousQuotes [2] = quoteThree;
        famousQuotes [3] = quoteFour;
        famousQuotes [4] = quoteFive;
        famousQuotes [5] = quoteSix;
        famousQuotes [6] = quoteSeven;
        famousQuotes [7] = quoteEight;
        famousQuotes [8] = quoteNine;
        famousQuotes [9] = quoteTen;

        // Introducing the System // ----------------------------------------------------------------------------------
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\n-------------------------------------");
            System.out.println("Hello User! This is a quote display system!");
            System.out.println("There are 10 quotes labeled 1-10. To view enter a value 1-10!");
            System.out.println("Bonus! To see a random quote. Enter (R)");
            System.out.print("Enter:  ");

            String menuChoiceInput = scanner.nextLine().trim();

            if (menuChoiceInput.matches("\\d+")) {
                int menuChoice = Integer.parseInt(menuChoiceInput);

                if (menuChoice == 1) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 2) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 3) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 4) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 5) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 6) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 7) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 8) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 9) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else if (menuChoice == 10) {
                    System.out.println("\nDisplaying quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (menuChoice - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }
                } else {
                    System.out.println("\n-------------------------");
                    System.out.println("Invalid Input. Enter single digit 1-10");
                    System.out.println("-------------------------");
                }
            } else if (!menuChoiceInput.matches("\\d+")) {
                char menuChoice  = menuChoiceInput.toUpperCase().charAt(0);
                if (menuChoice == 'R') {
                    int showQuoteRandom = (int)((Math.random() * 10) + 1);

                    System.out.println("\nDisplaying random quote");
                    // For loop to search for menuChoice in famousQuotes // -----------------------------------------------
                    for (int index = 0; index < famousQuotes.length; index += 1) {
                        if (showQuoteRandom - 1 == index) {
                            System.out.println("\n---------------------------------");
                            System.out.println(famousQuotes [index]);
                            System.out.println("---------------------------------");
                        }
                    }

                    try { // Timer before displaying return to menu // ----------------------------------------------------
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Code Broke");
                        throw new RuntimeException();
                    }

                    boolean returnConfirm = false;
                    while (!returnConfirm) {
                        System.out.println("\n Would you like to see another quote? (Y) or (N)");
                        char userReturnChoice = scanner.nextLine().trim().toUpperCase().charAt(0);

                        if (userReturnChoice == 'Y') {
                            System.out.println("Returning to Main Screen...");
                            System.out.println("Just a sec...");

                            try { // Timer before displaying return to menu // ----------------------------------------------------
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                System.out.println("Code Broke");
                                throw new RuntimeException();
                            }
                            returnConfirm = true;

                        } else if (userReturnChoice == 'N') {
                            returnConfirm = true;
                            keepGoing = false;
                        } else {
                            System.out.println("\n-------------------------");
                            System.out.println("Invalid Input. (Y) or (N).");
                            System.out.println("-------------------------");
                        }
                    }

                } else {
                    System.out.println("\n-------------------------");
                    System.out.println("Invalid Input. " + menuChoice);
                    System.out.println("-------------------------");
                }
            } else {
                System.out.println("\n-------------------------");
                System.out.println("Invalid Input. (Y) or (N).");
                System.out.println("-------------------------");
            }


        }
        System.out.println("\nExit Sequence Initiated...");
        System.out.println("Just a sec...");
        try { // Timer before displaying return to menu // ----------------------------------------------------
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Code Broke");
            throw new RuntimeException();
        }

        System.out.println("\n---------------------------------");
        System.out.println("Thank you for using Quote Display App!");
        System.out.println("Goodbye!");
        System.out.println("---------------------------------");

        try { // Timer before displaying return to menu // ----------------------------------------------------
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Code Broke");
            throw new RuntimeException();
        }



    }



}
