/*
 * Author: Jamie
 * Date: Apr 5, 2020
 * Version: v1.0
 * Description: This program will take two words. Then it will place periods
 * between the two words so that the total character count will be 30. If the
 * two words exceed 30 characters, the program will insert no periods. Sentences
 * are not accepted by the program.
 */
package edu.hdsb.gwss.jamie.ics3u.u4;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class Length30 {
    //VARIABLES
        public static String wordOne, wordTwo;
        public static int totalLength, totalPoints;
        public static boolean isWord;
        
        //CONSTANTS
        public static int CHARACTER_MAXIMUM = 30;
        
        //OBJECTS
        public static Scanner input = new Scanner(System.in);
        
    public static void main(String[] args) {
        printSplash();
        getWords();
        
        totalLength = wordOne.length() + wordTwo.length();
        totalPoints = CHARACTER_MAXIMUM - totalLength;
        System.out.print(wordOne);
        for (int i = 0; i < totalPoints; i++){
            System.out.print(".");
        }
        System.out.println(wordTwo);
    }
    
    public static void printSplash(){
        System.out.println("Enter two words. The program will insert points");
        System.out.println("between the two until the total charater count is");
        System.out.println("30. If the two words exceed 30 characters combined,");
        System.out.println("the program will not print any points.");
        System.out.println("---------------------------------------------------\n");
    }
    
    public static void getWords(){
        do {
            System.out.print("Enter the first word: ");
            wordOne = input.nextLine();
            wordOne = wordOne.trim();
            if (wordOne.contains(" ")){
                isWord = false;
                System.out.println("That's not a word. Try again.");
            }
            else {
                isWord = true;
            }
        } while (isWord == false);
        do {
            System.out.print("Enter the second word: ");
            wordTwo = input.nextLine();
            wordTwo = wordTwo.trim();
            if (wordTwo.contains(" ")){
                isWord = false;
                System.out.println("That's not a word. Try again.");
            }
            else {
                isWord = true;
            }
        } while (isWord == false);
    }
}
