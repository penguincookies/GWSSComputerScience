/*
 * Author: Jamie
 * Date: May 18, 2020
 * Version: v1.0
 * Description: This program will take a Canadian Social Insurance Number and see
 * if its check digit is correct. For more information on the check digit's
 * criteria, look at the splash page. Program verified using https://www.payroll.ca/Resources/Tools/SIN-Verification-Tool/Tool
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class SINCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int evenSum = 0, oddSum = 0;
        //There's two placeholders, one per data type that needed one
        double sinSum, digitPlaceholder;
        String sinString = "", charPlaceholder = "";
        
        printSplash();
        sinString = getInput(sinString);
        evenSum = getEvenSum(evenSum, charPlaceholder, sinString);
        oddSum = getOddSum(oddSum, sinString);
        
        sinSum = evenSum + oddSum;
        
        
        /*To find the next highest multiple of 10 I divide the sum by 10 until
          there's a number less than 10, ceiling that, and then multiply it by
          10 until it's just greater than the sum.*/
        do {
            digitPlaceholder = sinSum/10.0;
        } while (digitPlaceholder >= 10);
        digitPlaceholder = Math.ceil(digitPlaceholder);
        do {
            digitPlaceholder = digitPlaceholder*10;
        } while (digitPlaceholder < sinSum);
        
        digitPlaceholder = digitPlaceholder - sinSum;
        
        if (digitPlaceholder == Integer.parseInt(sinString.substring(8))) {
            System.out.println("The check digit of the SIN is correct.");
        }
        else {
            System.out.println("The check digit of the SIN is not correct.");
        }
        
        
    }
    
    public static void printSplash(){
        System.out.println("Social Insurance Number");
        System.out.println("In Canada, each person is uniquely identified by the");
        System.out.println("Government with a Social Insurance Number (SIN). A");
        System.out.println("Social Insurance Number consists of nine digits. The");
        System.out.println("The first eight numbers are assigned digits and the");
        System.out.println("last number is a check digit. This program determines");
        System.out.println("ifthe check digit for a SIN is correct.\n");
    }
    
    public static String getInput(String sinString){
        Scanner input = new Scanner(System.in);
        //A SIN has to be exactly 9 digits
        do {
            System.out.print("Enter a Social Insurance Number: ");
            sinString = String.valueOf(input.nextInt());
            sinString = sinString.trim();
            if (sinString.length() != 9) {
                System.out.println("That isn't a valid SIN, try again.\n");
            }
        } while ( sinString.length() != 9 );
        return sinString;
    }
    
    public static int getEvenSum(int evenSum, String charPlaceholder, String sinString){
        //The loop looks at digits at indexes 1,3,5,7
        for (int i = 1; i <= 7; i = i+2) {
            charPlaceholder = String.valueOf(Integer.parseInt(sinString.substring(i, i+1))*2);
            //If the product of the digit and 2 has more than one digit, the digits 
            //the product are added so I needed a string placeholder to measure length
            if (charPlaceholder.length() == 1) {
               evenSum = evenSum + Integer.parseInt(charPlaceholder); 
            }
            else {
                evenSum = evenSum + Integer.parseInt(charPlaceholder.substring(0,1))
                        + Integer.parseInt(charPlaceholder.substring(1));
            }
        }
        return evenSum;
    }
    
    public static int getOddSum (int oddSum, String sinString){
        //The loop looks at digits at indexes 0,2,4,6
        for (int i = 0; i <= 6; i = i+2) {
            oddSum = oddSum + Integer.parseInt(sinString.substring(i, i+1));
        }
        return oddSum;
    }
    
}
