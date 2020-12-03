/*
 * Author: Jamie
 * Date: June 10, 2020
 * Version: v1.1
 * Description: This program will look at two words and see if the placement of
 * both their vowles and consonants are identical. 'Y' is not considered a vowel 
 * in this case.
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
public class PatternMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //VARIABLES
        String wordA, wordB, bothWords;
        int lengthA, lengthB;
        //Assumes true by default
        boolean matchingPattern = true;
        boolean charAVowel, charBVowel;
        
        //OBJECTS
        File inputFile = new File ("Data21.txt");
        File outputFile = new File ( "Out21.txt" );
        Scanner input = new Scanner ( inputFile );
        PrintWriter output = new PrintWriter ( outputFile );
        StringTokenizer tokenizer;
        
        while ( input.hasNextLine() ){
            //Reads data one line at a time, processes it, and then moves on to
            //the next line
            bothWords = input.nextLine();
            tokenizer = new StringTokenizer ( bothWords, " ", false );
            wordA = tokenizer.nextToken();
            wordB = tokenizer.nextToken();
            lengthA = wordA.length();
            lengthB = wordB.length();
            
            //First checks length, the easiest charicteristic to check
            if (lengthA != lengthB) {
                matchingPattern = false;
            }
            //If the lengths are same, the program then checks chars at the same
            //index of both words and checks to see if they're both vowels or both
            //consonants
            else {
                for (int i = 0; i < lengthA; i++) {
                    if (wordA.charAt(i) == 'a' || wordA.charAt(i) == 'e'
                            || wordA.charAt(i) == 'i' || wordA.charAt(i) == 'o'
                            || wordA.charAt(i) == 'u') {
                        charAVowel = true;
                    }
                    else {
                        charAVowel = false;
                    }
                    if (wordB.charAt(i) == 'a' || wordB.charAt(i) == 'e'
                            || wordB.charAt(i) == 'i' || wordB.charAt(i) == 'o'
                            || wordB.charAt(i) == 'u') {
                        charBVowel = true;
                    }
                    else {
                        charBVowel = false;
                    }
                    
                    //As soon as a pair of coresponding chars don't match, the loop
                    //breaks and the words are labled different
                    if (charAVowel != charBVowel) {
                        matchingPattern = false;
                        break;
                    }
                    
                }
            }
            if (matchingPattern == true) {
                output.println ("same");
            }
            else {
                output.println ("different");
            }
            
            //Resets the boolean
            matchingPattern = true;
        }
        output.close();
        input.close();
    }
    
}
