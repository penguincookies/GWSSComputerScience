/*
 * Author: Jamie
 * Date: Apr 5, 2020
 * Version: v1.0
 * Description: The program takes a word and prints as many times as there are 
 * characters in the word. It won't accept a String with a space in the middle.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class WordEcho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String word;
        int length;
        boolean isWord;
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        printSplash();
        do {
            System.out.print("Enter a word: ");
            word = input.nextLine();
            word = word.trim();
            length = word.length();
            if (word.contains(" ")){
                isWord = false;
                System.out.println("That's not a word. Try again.");
            }
            else {
                isWord = true;
            }
        } while (isWord == false);
        
        System.out.println("\nThe word \"" + word + "\" is " + length
                + " characters long.");
        
        for (int i = 0; i < length; i++){
            System.out.print( word + "  ");
        }
    }
    
    public static void printSplash(){
        System.out.println("This program will take a word and print that word");
        System.out.println("as many times as there are characters in the word.");
        System.out.println("--------------------------------------------------\n");
    }
    
}
