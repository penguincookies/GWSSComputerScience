/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author revit
 */
public class PAlindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printSplash();
        String word = getWord();
        boolean palindrome = checkWord(word);
        printResult(palindrome);
    }
    
    public static void printSplash(){
        System.out.println("Palindrome");
        System.out.println("Words that are the same forwards and backwards are ");
        System.out.println("called palindromes.  This program determine if a ");
        System.out.println("word is a palindrome.\n");
    }
    
    public static String getWord() {
        Scanner input = new Scanner(System.in);
        //File myFile = new File( "" );
        //Scanner input = new Scanner ( myFile );
        System.out.print("Enter a word: ");
        String word = input.nextLine();
        return word;
    }
    
    public static boolean checkWord (String word) {
        String wordBackwards = "";
        boolean palindrome = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            wordBackwards = wordBackwards.concat(String.valueOf(word.charAt(i)));
        }
        if (word.equalsIgnoreCase(wordBackwards)) {
            palindrome = true;
        }
        System.out.println(word + " backwards is " + wordBackwards);
        return palindrome;
    }
    
    public static void printResult(boolean palindrome) {
        if (palindrome) {
            System.out.println("It IS a palindrome.");
        }
        else {
            System.out.println("It IS NOT a palindrome.");
        }
    }
    
}
