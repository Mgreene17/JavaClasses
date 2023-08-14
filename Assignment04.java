/*
Mike Greene Assignment 04 CIS365A
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Assignment4 {
    //main method and try to initialize the IOexception (catch at bottom)
    public static void main(String[] args){
      
      try{
        //import and read the pop1 csv
        File inputFile = new File("pop-1.csv");
        Scanner scanner = new Scanner(inputFile);

        //create 10 empty arrays to store 2010-2019 totals
        long[] popTotal = new long[10];
        scanner.nextLine();

        //calculate the total population for each year AND store it to each total population empty array
        while (scanner.hasNextLine()) {
            String rows = scanner.nextLine();
            String[] values = rows.split(",");
            for (int i = 1; i < values.length; i++) {
                popTotal[i - 1] += Long.parseLong(values[i]);
            }
        }

        System.out.println("Writing to new file...");
        
        // Open the output file and write each total population
        PrintWriter righter = new PrintWriter("summary.csv");

        for (int i = 0; i < popTotal.length; i++) {
            righter.print("Year " + (2010 + i) + ",");
            righter.println(popTotal[i]);
        }

        // Close the output file
        righter.close();

        System.out.println("Successfully wrote to summary.csv");

        
      }catch (IOException io_e){
      }
    }
}
