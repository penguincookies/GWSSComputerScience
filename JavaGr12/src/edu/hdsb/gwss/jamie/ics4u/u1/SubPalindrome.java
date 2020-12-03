/*
 * Author: Jamie
 * Date: September 18, 2020
 * Version: v1.0
 * Description: This program will take a file of Strings and determine the largest
 * sub-palindrome in each of the Strings
 */
package edu.hdsb.gwss.jamie.ics4u.u1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
/**
 *
 * @author revit
 */
public class SubPalindrome {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //VARIABLES
        String word;
        int palindromeSize;
        
        //OBJECTS
        File dataFile = new File("SubPalindromeA103.txt");
        Scanner input = new Scanner(dataFile);
        
        printSplash();
        //RUNS CODE AS LONG AS THE FILE HAS MORE LINES
        while (input.hasNextLine()) {
            word = input.nextLine();
            //TOKENIZER USED TO REMOVE SPACES
            StringTokenizer st = new StringTokenizer ( word, " ");
            palindromeSize = findSubPalindrome(st);
            System.out.println(palindromeSize);
        }
    }
    
    public static void printSplash () {
        System.out.println("This program will take a data set of strings only");
        System.out.println("containing letters and spaces and determine the");
        System.out.println("largest sub-palindrome per line. The output will");
        System.out.println("have one number per line representing the size of");
        System.out.println("the largest sub-palindrome for the coresponding line");
        System.out.println("in the data file.");
    }
    
    public static int findSubPalindrome (StringTokenizer st) {
        //VARIABLES
        String word = "";
        String palindromePL;
        int palindromeSize = 0;
        boolean isPalindrome = false;
        //IF THE LINE HAD SPACES, REMOVES THEM AND CONCATS ALL THE PARTS TOGETHER
        while (st.hasMoreTokens()) {
            word = word.concat(st.nextToken());
        }
        //THIS BLOCK LOOKS AT THE WORD IN CHUNKS FOR SUBPALINDROMES. IF A WORD 
        //HAS 5 LETTERS, THE CODES LOOKS AT THE 5-LETTER CHUNK FIRST, THEN THE
        //TWO 4-LETTER CHUNKS, THEN THE THREE 3-LETTER CHUNKS, AND SO ON
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                palindromePL = word.substring(j, word.length()-i+j+1);
                isPalindrome = checkWord(palindromePL);
                //SINCE THE CODE WORKS FROM BIG TO SMALL, THE FIRST SUBPALINDROME 
                //FOUND WILL BE THE BIGGEST AND THE CODE WILL BREAK AS SOON AS ONE
                //IS FOUND
                //THE TWO BREAKS ARE NECESSARY SINCE THIS IS A NESTED FOR LOOP
                if (isPalindrome) {
                   palindromeSize = palindromePL.length();
                   break;
                }
            }
            if (isPalindrome) {
                break;
            }
            
        }
        return palindromeSize;
    }
    
    public static boolean checkWord (String word) {
        //VARIABLES
        String wordBackwards = "";
        boolean palindrome = false;
        //THE PALINDROME CHECKER, TAKES THE GIVEN STRING AND COMPARES IT TO
        //THE BACKWARDS VERSION OF IT
        for (int i = word.length() - 1; i >= 0; i--) {
            wordBackwards = wordBackwards.concat(String.valueOf(word.charAt(i)));
        }
        if (word.equalsIgnoreCase(wordBackwards)) {
            palindrome = true;
        }
        return palindrome;
    }
    
}
