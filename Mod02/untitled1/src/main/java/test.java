import java.util.Scanner;

public class test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine().trim().replaceAll("\\s+", " ").replaceAll(" ", "_");
        System.out.println(fileName);


    }
}
