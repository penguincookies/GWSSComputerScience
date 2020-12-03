/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: The user inputs how many cents they have and the program 
 * calculates the most efficient way to distribute that in quarters, dimes,
 * nickels, and pennies
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class Change {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int pennies;
       int nickels;
       int dimes;
       int quarters;
       int remainder;
       
       Scanner changeCents = new Scanner(System.in);
       System.out.println("Enter your total amount in cents:");
       int cents = changeCents.nextInt();
       
       quarters = cents/25;
       remainder = cents - (quarters * 25);
       dimes = remainder/10;
       remainder = remainder - (dimes*10);
       nickels = remainder/5;
       pennies = remainder - (nickels * 5);
       
        System.out.format("%-10s | %4d\n", "Quarters", quarters);
        System.out.format("%-10s | %4d\n", "Dimes", dimes);
        System.out.format("%-10s | %4d\n", "Nickels", nickels);
        System.out.format("%-10s | %4d\n", "Pennies", pennies);
        
    }
    
}
