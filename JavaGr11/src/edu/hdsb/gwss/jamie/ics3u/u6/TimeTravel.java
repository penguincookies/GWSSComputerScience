/*
 * Author: Jamie
 * Date: June 4, 2020
 * Version: v1.2
 * Description: This program will take a text file containing current time, travel
 * time in hours, and the time gap in hours to determine what time it will be at
 * the destination
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
/**
 *
 * @author revit
 */
public class TimeTravel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args ) throws IOException{
        //VARIABLES
        String timestamp = null;
        int hour, minute, second, travelTime, timeGap;
        
        //OBJECTS
        File inputFile = new File ( "Travel10.txt" );
        File outputFile = new File ( "Out10.txt" );
        Scanner input = new Scanner ( inputFile );
        PrintWriter output = new PrintWriter ( outputFile );
        DecimalFormat decimal = new DecimalFormat("00");
        StringTokenizer tokenizer;
        
        
        while ( input.hasNextLine() ){
        timestamp = input.nextLine();
        
            tokenizer = new StringTokenizer ( timestamp, ": ", false);
            hour = Integer.parseInt(tokenizer.nextToken());
            minute = Integer.parseInt(tokenizer.nextToken());
            second = Integer.parseInt(tokenizer.nextToken());
            travelTime = Integer.parseInt(tokenizer.nextToken());
            timeGap = Integer.parseInt(tokenizer.nextToken());
            
            hour = hour + travelTime + timeGap;
            //If the hours goes above or below the range of a 24 hour clock, these
            //lines fix it so that it fits into the range of 0-23
            while (hour > 23){
                hour = hour - 24;
            }
            while (hour < 0){
                hour = hour + 24;
            }
            
            output.println(decimal.format(hour) + ":" + decimal.format(minute) + ":" + decimal.format(second));
            
        }
        input.close();
        output.close();
    }
    
}
