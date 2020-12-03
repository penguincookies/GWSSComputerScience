/*
 * Author: Jamie
 * Date: Feb 23, 2020
 * Version: v0.1
 * Description: Takes 13 digits of an inputted ISBN number and determines if it
 * was inputted correctly or not.
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class ISBNChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CONSTANTS
        
        //VARIABLES
        int ISBNdigits [];
        int ISBNtotal = 0;
        ISBNdigits = new int[13];
        
        //OBJECT
        Scanner newDigit = new Scanner(System.in);
        
        //SPLASH PAGE
        System.out.println("This program will take the 13 digits of an ISBN"
                + "number and check if it's valid or not");
        
        for (int i = 0; i < ISBNdigits.length; i++) {
            //INPUT
            System.out.println("Enter digit " + (i+1));
            ISBNdigits[i] = newDigit.nextInt();
            //PROCESSING
            if (i%2 == 0) {
                ISBNtotal = ISBNtotal + ISBNdigits[i];
            }
            else {
                ISBNtotal = ISBNtotal + (ISBNdigits[i] * 3);
            }
        }
        
        //OUTPUT
        System.out.println("The 1-3 sum is " + ISBNtotal);
        if (ISBNtotal%10 == 0) {
            System.out.println("This is a valid International Standard Book Number");
        }
        else{
            System.out.println("This is not a valid International Standard Book Number");
        }
    }
    
}
