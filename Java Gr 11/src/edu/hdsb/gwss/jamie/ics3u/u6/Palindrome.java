/*
 * Author: Jamie
 * Date: May 18, 2020
 * Version: v1.0
 * Description: This program will take a word and determine whether or not it is
 * the same backwards and forwards.
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int wordLength = 0;
        String wordBackwards = "", word = "";
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        printSplash();
        
        //INPUT
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
        //wordBackwards = word;
        wordLength = word.length();
        for (int i = wordLength - 1; i >= 0; i--) {
            //wordBackwards = wordBackwards + word.substring(i, i + 1);
            wordBackwards = wordBackwards.concat(word.substring(i, i + 1));
        }
        System.out.println("\n" + word + " backwards is " + wordBackwards + ".");
        System.out.print("It is ");
        if (!word.equals(wordBackwards)){
            System.out.print("not ");
        }
        System.out.println("a palindrome.");
    }
    
    public static void printSplash(){
        System.out.println("Palindrome");
        System.out.println("Words that are the same forwards and backwards are ");
        System.out.println("called palindromes.  This program determine if a ");
        System.out.println("word is a palindrome.\n");
    }
    
}
