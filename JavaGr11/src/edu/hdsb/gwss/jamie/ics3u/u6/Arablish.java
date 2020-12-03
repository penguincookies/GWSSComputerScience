/*
 * Author: Jamie
 * Date: June 14, 2020
 * Version: v1.0
 * Description: This program will look at an Arablish sentence and convert them
 * to proper left-to-right English
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
public class Arablish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //VARIABLES
        //a is short for arablish, e is short for english
        String aSentence, eSentence = "", aWord, eWord = "";
        boolean hasLetters;
        int wordLength;
        
        //OBJECTS
        File inputFile = new File ( "Data31.txt" );
        File outputFile = new File ( "Out31.txt" );
        Scanner input = new Scanner ( inputFile );
        PrintWriter output = new PrintWriter ( outputFile );
        StringTokenizer tokenizer;
        
        while ( input.hasNextLine() ) {
            aSentence = input.nextLine();
            tokenizer = new StringTokenizer ( aSentence, " ", false );
            while ( tokenizer.hasMoreTokens() ) {
                hasLetters = false;
                aWord = tokenizer.nextToken();
                wordLength = aWord.length();
                /*The program assumes that the word doesn't have letters by deafault
                so it's easier to know whether or not to reverse the word. If there'e
                even a single letter, reverse the word. If there's a single number
                it's still unknown whether or not to reverse the word*/
                for (int i = (wordLength-1); i >= 0; i--) {
                    if (aWord.codePointAt(i) > 64) {
                        hasLetters = true;
                        break;
                    }
                }
                //Checks if the word had letter(s), if so reverses the aWord otherwise
                //aWord remains un-reversed
                if ( hasLetters == true ){
                    for (int i = (wordLength-1); i >= 0; i--) {
                        eWord = eWord + aWord.charAt(i);
                    }
                }
                else {
                    eWord = aWord;
                }
                eSentence = eWord + " " + eSentence;
                //Clears eWord
                eWord = "";
            }
            output.println(eSentence);
            //Clears eSentence
            eSentence = "";
        }
        output.close();
        input.close();
    }
    
}
