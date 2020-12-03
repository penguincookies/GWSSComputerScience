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
public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printSplash();
        String sentence = getSentence();
        StringTokenizer st = new StringTokenizer ( sentence, " ");
        int palindromeCount = checkSentence(st);
        printResult(palindromeCount);
    }
    
    public static void printSplash(){
        System.out.println("Palindrome");
        System.out.println("Words that are the same forwards and backwards are ");
        System.out.println("called palindromes.  This program determine if a ");
        System.out.println("sentence contains palindromes.\n");
    }
    
    public static String getSentence() {
        Scanner input = new Scanner(System.in);
        //File myFile = new File( "" );
        //Scanner input = new Scanner ( myFile );
        System.out.print("Enter a sentence(no punctuation): ");
        String sentence = input.nextLine();
        return sentence;
    }
    
    public static int checkSentence (StringTokenizer st) {
        int palindromeCount = 0;
        System.out.println("The following palindromes are in the sentence:");
        while (st.hasMoreTokens()) {
            String wordBackwards = "";
            String word = st.nextToken();
            for (int i = word.length() - 1; i >= 0; i--) {
                wordBackwards = wordBackwards.concat(String.valueOf(word.charAt(i)));
            }
            if (word.equalsIgnoreCase(wordBackwards)) {
                palindromeCount++;
                System.out.println(word);
            }
        }
        return palindromeCount;
    }
    
    public static void printResult(int palindromeCount) {
        System.out.println("\nThere are " + palindromeCount + " palindrome(s) in the sentence.");
    }
    
}
