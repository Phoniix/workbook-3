import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class SearchEngineLogger {

    public static void main(String[] args) {

        // Introducing the variables ----------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        LocalDate dateInput = LocalDate.now();
        String date = dateInput.toString();
        LocalTime timeInput = LocalTime.now();
        String time = timeInput.getHour() + ":" + timeInput.getMinute() + ":" + timeInput.getSecond();

        try {
            FileWriter lilTim = new FileWriter("logs.txt");
            BufferedWriter lilJon = new BufferedWriter(lilTim);
            lilJon.write("\n" + date + time + " " + "launch");


            //Introducing the System // -----------------------------------------------------------------------------------
            logStuff("launch");
            boolean keepGoing = true;
            while (keepGoing) {

                boolean welcomeMenuChoice = false;
                while (!welcomeMenuChoice) {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Hello User! Welcome to Sean's Searches™");
                    System.out.println("\nEnter a search term or press (0) to Exit");
                    System.out.println("(0) Exit");
                    System.out.print("\nEnter:  ");
                    String userInput = "";

                    try {
                        userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
                    } catch (Exception e) {
                        System.out.println("\n---------------------------------");
                        System.out.println("Invalid Input");
                        System.out.println("---------------------------------");
                    }

                    if (userInput.equalsIgnoreCase("0")) {
                        exitSequence();
                        lilJon.write("\n" + date + time + " " + "exit");
                        welcomeMenuChoice = true;
                        keepGoing = false;
                        return;
                    } else {
                        lilJon.write("\n" + date + time + " " + "search : " + userInput);
                        System.out.println("\nYou Searched: " + userInput);
                        System.out.println("\n\n ");
                    }

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void exitSequence () {
        System.out.println("\nExit sequence initiated...");
        System.out.println("Just a sec...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Code Broke.");
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Thank you for using Sean's Searches™");
        System.out.println("Goodbye!");
        System.out.println("----------------------------------------");
    }

    public static void logStuff (String action) {
        LocalDate dateInput = LocalDate.now();
        String date = dateInput.toString();
        LocalTime timeInput = LocalTime.now();
        String time = timeInput.getHour() + ":" + timeInput.getMinute() + ":" + timeInput.getSecond();

        try (BufferedWriter lilJon = new BufferedWriter(new FileWriter("logs.txt"))) {
            lilJon.write("\n" + date + time + " " + action);
        } catch (IOException e) {
            System.out.println("Unable to write to file, file not found.");
        }
    }


}
