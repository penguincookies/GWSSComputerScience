/*
 * Author: Jamie
 * Date: May 24, 2020
 * Version: v1.0
 * Description: This program will create a text file and write in it 100 randomly
 * generated numbers ranging from 1-100 inclusive
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
//import java.nio.file.*; 
//Needed in case a FileNotFoundException is thrown. A FileNotFoundException would
//be thrown if "myFile" was not found.  https://stackoverflow.com/questions/19788989/error-unreported-exception-filenotfoundexception-must-be-caught-or-declared-to
import java.io.IOException;
/**
 *
 * @author revit
 */
public class RandomNumbers {

    /**
     * @param args the command line arguments
     */
    
    //'throws' alerts the method that it might throw an IOException. Then if the
    // specifed error occurs, the method can handle it an proceed. https://www.geeksforgeeks.org/throw-throws-java/
    public static void main ( String[] args ) throws IOException { 

    // Create File and Create a File Writer and a Scanner
    File myFile = new File( "ints.txt" );
    File outputFile = new File ( "test.txt" );
    PrintWriter output = new PrintWriter( outputFile );
    Scanner input = new Scanner ( myFile );

    // Write Data
    for (int i = 0; i < 100; i++) {
         output.println( (int)(Math.random()*100)+1 );   
    }
    
    // Close File. When the file is 'opened', the OS will lock it so other processes
    // can't interfere with it. Once you're done, you have to unlock it by using close()
    //https://stackoverflow.com/questions/7118603/explain-the-close-method-in-java-in-laymans-terms
    //output.close();
    
    while ( input.hasNextLine() ){
        System.out.println(input.nextLine());
    }
    
    //Close File
    input.close();
    output.close();

}
    
}
