package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {
        try {
            // open the file
            FileWriter writer = new FileWriter("text.txt");
            // write to the file
            writer.write("Skills:\n");
            writer.write("Git, HTML, CSS, Bootstrap\n");
            writer.write("JavaScript/ES6, jQuery, REST API, Node.js, Express\n");
            writer.write("Angular\n");
            writer.write("Java");
            // close the file when you are finished using it
            writer.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.printStackTrace();
        }



    }

}
