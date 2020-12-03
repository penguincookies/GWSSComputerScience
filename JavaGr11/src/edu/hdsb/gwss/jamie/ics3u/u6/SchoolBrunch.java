/*
 * Author: Jamie
 * Date: June 9, 2020
 * Version: v1.0
 * Description: This program will take the attendance of the student brunch, calculate
 * the total profit, and then see if that's enough to fund the year-end trip
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 *
 * @author revit
 */
public class SchoolBrunch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //I originally didn't want to use so many arrays since we hadn't learned
        //them yet but it made using them and for loops a lot easier
        //VARIABLES
        String attendancePercentages = "";
        //index 0 is freshmen, 1 is sophomores, 2 is juniors, 3 is seniors
        double[] agePercentages = { 0, 0, 0, 0 };
        double totalCost = 0, attendants = 0, moneyRaised = 0;
        
        //CONSTANTS
        //index 0 is freshmen, 1 is sophomores, 2 is juniors, 3 is seniors
        int[] STUDENT_PROCEEDS = { 12, 10, 7, 5 };
        
        
        //OBJECTS
        File inputFile = new File ( "Brunch.txt" );
        Scanner input = new Scanner ( inputFile );
        StringTokenizer tokenizer;
        
        while ( input.hasNextLine() ){
            //Retrieves the data on the .txt file
            totalCost = Integer.parseInt(input.nextLine());
            attendancePercentages = input.nextLine();
            tokenizer = new StringTokenizer ( attendancePercentages, " ", false);
            //Assigns the percentage of attendance per age group
            for (int i = 0; i < 4; i++) {
                agePercentages[i] = Double.parseDouble(tokenizer.nextToken());
            }
            attendants = Integer.parseInt(input.nextLine());
            //Totals the money
            for (int i = 0; i < 4; i++) {
                moneyRaised = moneyRaised + ( agePercentages[i] * attendants  *  STUDENT_PROCEEDS[i] );
            }
            //Only half the proceeds are used to fund the end of year trip
            moneyRaised = moneyRaised/2;
            //If the student council has enough money, NO they don't need to raise
            //more. Otherwise, YES they need more money
            if (moneyRaised >=  totalCost) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
            //Resets to money raised so the loop can go on
            moneyRaised = 0;
        }
        
        input.close();
        
    }
    
}
