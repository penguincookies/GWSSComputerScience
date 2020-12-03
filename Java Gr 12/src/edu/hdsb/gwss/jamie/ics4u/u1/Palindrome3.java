/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
/**
 *
 * @author revit
 */
public class Palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printSplash();
        String sentence = getSentence();
        StringTokenizer st = new StringTokenizer ( sentence, " ");
        boolean palindrome = checkSentence(st);
        printResult(palindrome, sentence);
    }
    
    public static void printSplash(){
        System.out.println("Palindrome");
        System.out.println("Words that are the same forwards and backwards are ");
        System.out.println("called palindromes.  This program determine if a ");
        System.out.println("sentence is a palindrome.\n");
    }
    
    public static String getSentence() {
        Scanner input = new Scanner(System.in);
        //File myFile = new File( "" );
        //Scanner input = new Scanner ( myFile );
        System.out.print("Enter a sentence(no punctuation): ");
        String sentence = input.nextLine();
        return sentence;
    }
    
    public static boolean checkSentence (StringTokenizer st) {
        String word = "";
        String wordBackwards = "";
        boolean palindrome = false;
        while (st.hasMoreTokens()) {
            word = word.concat(st.nextToken());
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            wordBackwards = wordBackwards.concat(String.valueOf(word.charAt(i)));
        }
        if (word.equalsIgnoreCase(wordBackwards)) {
            palindrome = true;
        }
        return palindrome;
    }
    
    public static void printResult(boolean palindrome, String sentence) {
        if (palindrome) {
            System.out.println(sentence + " IS a palindrome.");
        }
        else {
            System.out.println(sentence + " IS NOT a palindrome.");
        }
    }
    
}
