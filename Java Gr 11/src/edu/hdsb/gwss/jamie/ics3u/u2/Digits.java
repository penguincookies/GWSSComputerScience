/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: Takes any integer number with up to 3 digits and displays the 
 * digit of each place value
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class Digits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int hundreds;
       int tens;
       int ones;
        
       Scanner findNumber = new Scanner(System.in);
       System.out.println("Enter a three digit number:");
       int number = findNumber.nextInt();
       
       hundreds = number/100;
       tens = (number - (hundreds * 100))/10;
       ones = number - (hundreds * 100) - (tens * 10);
       
       System.out.format("%-10s | %-2d\n", "Hundreds", hundreds);
       System.out.format("%-10s | %-1d\n", "Tens", tens);
       System.out.format("%-10s | %-1d\n", "Ones", ones);
       
    }
    
}
