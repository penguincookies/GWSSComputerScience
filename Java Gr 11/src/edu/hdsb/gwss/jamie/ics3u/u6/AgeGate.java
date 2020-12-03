/*
 * Author: Jamie
 * Date: June 10, 2020
 * Version: v1.0
 * Description: This program will look at a set of birthdays and determine if
 * the people born on those dates are older or younger than the required age.
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 *
 * @author revit
 */
public class AgeGate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //VARIABLES
        String date;
        int month, day, year;
        
        //CONSTANTS
        int MONTH_TODAY = 11;
        int DAY_TODAY = 14;
        int YEAR_TODAY = 2019;
        int REQUIRED_AGE = 14;
        
        //OBJECTS
        File inputFile = new File ("Data11.txt");
        File outputFile = new File ( "Out11.txt" );
        Scanner input = new Scanner ( inputFile );
        PrintWriter output = new PrintWriter ( outputFile );
        StringTokenizer tokenizer;
        
        while ( input.hasNextLine() ){
            //Reads data one line at a time, processes it, and then moves on to
            //the next line
            date = input.nextLine();
            tokenizer = new StringTokenizer ( date, " ", false );
            month = Integer.parseInt (  tokenizer.nextToken() );
            day = Integer.parseInt (  tokenizer.nextToken() );
            year = Integer.parseInt (  tokenizer.nextToken() );
            
            /*The logic here is if the year difference is greater than the required
            age, you're definitely in. If it's less than the required age, you're 
            definitely out. If it's exactly the required age, you have to go on
            to check month, and if the difference there is also 0, you have to 
            check the day*/
            if (YEAR_TODAY - year > REQUIRED_AGE) {
                //validAge[counter] = true;
                output.println("old enough");
            }
            else if (YEAR_TODAY - year < REQUIRED_AGE) {
                output.println("too young");
            }
            else {
                if (MONTH_TODAY - month > 0) {
                    //validAge[counter] = true;
                    output.println("old enough");
                }
                else if (MONTH_TODAY - month < 0) {
                    output.println("too young");
                }
                else {
                    if (DAY_TODAY - day >= 0) {
                        //validAge[counter] = true;
                        output.println("old enough");
                    }
                    else {
                        output.println("too young");
                    }
                }
            }
        }
        input.close();
        output.close();
    }
    
}
