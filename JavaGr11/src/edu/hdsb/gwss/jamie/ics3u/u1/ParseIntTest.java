/*
 * Author: Jamie
 */
package edu.hdsb.gwss.jamie.ics3u.u1;
//import java.util.Scanner;

import java.util.Scanner;


public class ParseIntTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String thisWillBeReturnCarriage;
        int integer;
        
        Scanner input = new Scanner(System.in);
        
       
        //This is trying to input a string right after an int without Integer.parseInt
        System.out.print("Enter a number: ");
        integer = input.nextInt();
        System.out.print("Enter a word: ");
        thisWillBeReturnCarriage = input.nextLine();
        System.out.println("\nThe number is: " + integer);
        System.out.println("The word is: " + thisWillBeReturnCarriage);
        
        System.out.println("\n\n\n");
        
         //This is trying to input a string right after an int with Integer.parseInt
        System.out.print("Enter a new number: ");
        integer = Integer.parseInt(input.nextLine());
        System.out.print("Enter a word(this time it won't be blank): ");
        thisWillBeReturnCarriage = input.nextLine();
        System.out.println("\nThe number is: " + integer);
        System.out.println("The word is: " + thisWillBeReturnCarriage);
    }
    
}
