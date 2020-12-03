/*
 * Author: Jamie
 * Date: Mar 12, 2020
 * Version: v0.1
 * Description: Takes the current year and the user's birth year in 2 digits and 
 * calculates their age assuming their age is >= 100.
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class Y2KDetector {
    //VARIABLES
    public static int birthYear;
    public static int currentYear;
    public static int age;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Enter the current year's last two digits: ");
        currentYear = input.nextInt();
        System.out.print("Enter your birth year's last two digits: ");
        birthYear = input.nextInt();
        
        if (birthYear < currentYear){
            age = currentYear - birthYear;
            System.out.println("Your age is: " + age);
        }
        else if (birthYear > currentYear){
            age = currentYear + 100 - birthYear;
            System.out.println("Your age is: " + age);
        }
        else {
            System.out.println("Your age is either 0 or 100");
        }
    }
    
    
}

