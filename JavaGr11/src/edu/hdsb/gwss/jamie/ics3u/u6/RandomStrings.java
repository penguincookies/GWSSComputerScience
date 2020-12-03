/*
 * Author: Jamie
 * Date: May 25, 2020
 * Version: v1.0
 * Description: This program will create a text file and write in it 100 randomly
 * generated Strings containing 6 random uppercase letters
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author revit
 */
public class RandomStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //VARIABLES
        char[] letters = {70, 71, 72, 73, 74, 75};
        
        //OBJECTS
        File myFile = new File ( "Strings.txt" );
        PrintWriter output = new PrintWriter ( myFile );
        Scanner input = new Scanner ( myFile );
        
        //Generates 6 random uppercase letters, prints them in a row. Repeats 
        //100 times,
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                letters [j] = (char)((int)(Math.random()*26)+65);
                output.print( letters [j] );
            }
            output.println("");
        }
        
        //Close file
        output.close();
        
        //Prints file while there are lines to print
        while ( input.hasNextLine() ){
        System.out.println(input.nextLine());
        }
        
        //Close file
        input.close();
    }
    
}