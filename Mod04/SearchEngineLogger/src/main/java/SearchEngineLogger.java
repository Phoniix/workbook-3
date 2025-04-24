import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class SearchEngineLogger {

    public static void main(String[] args) {

        //Variable Introductions // -----------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        //Introducing the System // -----------------------------------------------------------------------------------
        try (BufferedWriter lilJon = new BufferedWriter(new FileWriter("logs.txt", true))) { // ChatGPT Suggested to use ", true" so file opens in "Append Mode" //

            logStuff(lilJon, "launch"); // Logs Launch Before Hitting Main App

            boolean keepGoing = true;
            while (keepGoing) {
                nLDashedLinesLong();
                String search = welcomeMenu(scanner); // Opens Welcome menu // --------------------------------------------
                dashedLinesLongBottom();

                if (search.equalsIgnoreCase("0")) {
                    keepGoing = false;
                } else {
                    logStuff(lilJon, "Search : " + search);
                    keepGoing = searcher(search, scanner, lilJon);
                    break;
                }
            }// KeepGoing Loop End // Exits The App // ---------------------------------------------------------------
            exitSequence();
            logStuff(lilJon, "exit");
        } catch (IOException e) {
            System.out.println("AHHHHHHHHHHHHHHHH");
            e.printStackTrace();
        }

    }


    public static void nLDashedLinesLong () {
        System.out.println("\n───────────────────────────────────────────");
    } // New Line with Dashed Lines
    public static void dashedLinesLongBottom () {
        System.out.println("───────────────────────────────────────────");
    } // Prints Dashed Lines
    public static String  welcomeMenu  (Scanner scanner) {
        System.out.println("Hello User! Welcome to Sean's Searches™");
        System.out.println("Enter a search query or enter 0 to exit.");
        System.out.println("(0) Exit");
        System.out.print("Enter:  ");
        String userInput = "";

        try {
            userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");
        } catch (Exception e) {
            System.out.println("Y u do dis");
            e.printStackTrace();
        }
        return userInput;
    } // Opens welcome menu // Performs initial search // ----
    public static void timer (int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Code Broke.");
            throw new RuntimeException();
        }
    }
    public static boolean searcher (String userInput, Scanner scanner, BufferedWriter lilJon) throws IOException {
        boolean exitSearcher = false;
        while (!exitSearcher) {
            nLDashedLinesLong();
            System.out.println("\nYou searched: " + userInput);
            dashedLinesLongBottom();
            System.out.println("Search again or press 0 to exit.");
            System.out.println("(0) Exit");
            System.out.print("\nEnter:  ");
            userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");

            if (userInput.equalsIgnoreCase("0")) {
                logStuff(lilJon, "exit sequence : " + userInput);
                exitSearcher = true;
                break;
            } else {
                logStuff(lilJon, "search : " + userInput);
            }
        } // Searcher Loop Ends // Exits This Method // ---------------------------------------------------------------
        return !exitSearcher;
    } // Performs every search after initial search// can exit program //
    public static void exitSequence () {
        System.out.println("\nInitiating Exit Sequence...");
        timer(1500);
        System.out.println("\nThank you for using Sean's Searches™");
        System.out.println("Goodbye");
        timer(1500);

    } // Exit Message //
    public static void logStuff (BufferedWriter lilJon, String action) throws IOException { // ChatGPT suggest use of throws IO Exception in signature
        LocalTime timeInput = LocalTime.now();
        String time = timeInput.getHour()+ ":" + timeInput.getMinute() + ":" + timeInput.getSecond();
        String date = LocalDate.now().toString();

        lilJon.write(date + " " + time + " " + action);
        lilJon.newLine(); // ChatGPT Suggested to use this to start a next line automatically // ----------------------
        lilJon.flush(); // ChatGPT Suggested to use this to make sure it posts immediately // -------------------------


    } // Logs stuff //

}
