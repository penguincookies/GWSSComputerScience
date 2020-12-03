/*
 * Author: Jamie
 * Date: May 17, 2020
 * Version: v1.0
 * Description: The user will input a string and then the program will count how
 * many vowels (excluding y) are in it.
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class CountingVowels {
    //VARIABLES
    public static int vowelCount = 0, indexPlaceholder;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String sentence;
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        //INPUT
        printSplash();
        System.out.print("Enter a sentence: ");
        sentence = input.nextLine();
        
        //PROCESSING
        sentence = sentence.toLowerCase();
        vowelCounter('a', sentence);
        vowelCounter('e', sentence);
        vowelCounter('i', sentence);
        vowelCounter('o', sentence);
        vowelCounter('u', sentence);
        
        //OUTPUT
        System.out.println("\nThere are " + vowelCount + " vowel(s) in this sentence.");
        
    }
    
    public static void printSplash(){
        System.out.println("Count Vowels");
        System.out.println("This program will take a sentence and count how");
        System.out.println("many vowels are in it.\n");
    }
    
    /*This method checks for the first instance of 'vowel' in the sentence. If
      there is one, then looks for another one starting from the char right 
      after until there are no more instances of 'vowel' in the sentence. It 
      also keeps track of the number all counted vowels*/
    public static void vowelCounter (char vowel, String sentence){
        indexPlaceholder = 0;
        while ( sentence.indexOf(vowel, indexPlaceholder) >= 0 ) {
            vowelCount++;
            indexPlaceholder = sentence.indexOf(vowel, indexPlaceholder) + 1;
        }
    }
    
}
