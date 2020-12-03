/*
 * Author: Jamie
 * Date: May 1, 2020
 * Version: v1.1
 * Description: A program that can convert between binary, decimal and octal
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.util.Scanner;
/**
 *
 */
public class NumberConversion {
    //VARIABLES
    //Placeholders are named after exclusively what will be stored in them
    public static int outputNumber = 0, modeChoice = 0, 
            digitPlaceholder, digitCount;
    //Long is used to increase how high of a user input the program can handle.
    public static long userNumber, valuePlaceholder;
    //Although it means having to cast all the equations this is in, conversionFactor
    //has to be a double so it can be used in Math.pow
    public static double conversionFactor;
    public static String outputString = "";
    
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        printSplash();
        selectionMenu(); 
    }
    
    public static void printSplash(){
        System.out.println("This program will convert from decimal to octal or");
        System.out.println("binaray or from those two to decimal.");
    }
    
    public static void selectionMenu(){
        digitCount = 0;
        System.out.println("This program will convert from:\n");
        System.out.println("1: binary to decimal");
        System.out.println("2: octal to decimal");
        System.out.println("3: decimal to binary");
        System.out.println("4: decimal to octal");
        System.out.println("5: Exit\n");
        System.out.print("Choice: ");
        modeChoice = input.nextInt();
        switch(modeChoice){
            case 1:
                userInput();
                conversionFactor = 2;
                otherToDecimal();
                break;
            case 2:
                userInput();
                conversionFactor = 8;
                otherToDecimal();
                break;
            case 3:
                userInput();
                conversionFactor = 2;
                decimalToOther();
                break;
            case 4:    
                userInput();
                conversionFactor = 8;
                decimalToOther();
                break;
            case 5:
                System.out.println("See ya.");
                break;
            default:
                System.out.println("That's not a valid choice\n");
                selectionMenu();
                break;
        }
    }
    
    public static void userInput(){
        System.out.print("Enter number      : ");
        userNumber = input.nextLong();
        valuePlaceholder = userNumber;
        do {
            valuePlaceholder = valuePlaceholder/10;
            digitCount++;
        } while (valuePlaceholder > 0);
        outputNumber = 0;
    }
    
    public static void otherToDecimal(){
        boolean validNumber = false;
        //Subtract 1 from digit count so I can get just the lst digit in the 
        //ones place, not all the digits in the decimals
        for (double i = (digitCount-1); i >= 0; i--) {
            digitPlaceholder = (int)userNumber/(int)Math.pow(10, i);
            if (digitPlaceholder >= conversionFactor){
                System.out.println("This is an invalid number.\n");
                validNumber = false;
                break;
            }
            else {
                outputNumber += digitPlaceholder*(int)Math.pow(conversionFactor, i);
                validNumber = true;
            }
            userNumber = userNumber - (int)(digitPlaceholder*Math.pow(10, i));
        }
        if (validNumber){
        System.out.println("The output is: " + outputNumber + "\n");
        }
        selectionMenu();
    }
    
    public static void decimalToOther(){
        outputString = "";
        do {
            digitPlaceholder = (int)(userNumber%(int)conversionFactor);
            outputString = digitPlaceholder+outputString;
            userNumber = (userNumber-digitPlaceholder)/(int)conversionFactor;
        } while (userNumber != 0);
        
        System.out.println("The output is   : " + outputString + "\n");
        selectionMenu();
    }
}
