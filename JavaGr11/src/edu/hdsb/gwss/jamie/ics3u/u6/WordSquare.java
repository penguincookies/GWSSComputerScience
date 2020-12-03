/*
 * Author: Jamie
 * Date: May 17, 2020
 * Version: v1.0
 * Description: This program will print a 'letter square' of a word entered by 
 * the user.
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class WordSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String word = "";
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        //INPUT
        printSplash();
        //The loop checks to see if there are any spaces, if there are the user
        //is promted to input again since their previous input wasn't a word
        do {
            System.out.print("Enter a word: ");
            word = input.nextLine();
            if (word.indexOf(' ') >= 0){
                System.out.println("That isn't a word, try again.\n");
            }
        }   while (word.indexOf(' ') >= 0);
        word = word.toUpperCase();
        
        //OUTPUT
        System.out.println("");
        //The loop will take the word and place its first character and place it
        //at the end. This repeats for as many characters there are in the word
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word);
            word = word.substring(1, word.length()) + word.substring(0,1);
        }
    }
    
    public static void printSplash(){
        System.out.println("Word Square");
        System.out.println("This program will print a word square from the word");
        System.out.println("you enter below. No sentences.\n");
    }
    
}
