/*
 * Author: Jamie
 * Date: Mar 14, 2020
 * Version: v1.0
 * Description: A program that checks if a given year is a leap year or not.
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class LeapYear {
    //VARIABLES
    public static int year;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
        
    public static void main(String[] args) {
        printSplash();
        checkYear();
    }
    
    public static void printSplash() {
        System.out.println("This program will take a given year and check \n"
                + "if it's a leap year.\n");
    }
    
    public static void checkYear() {
        System.out.print("What is the current year?: ");
        year = input.nextInt();
        //Checks for extreme data, which falls into two categories: a real year
        //that comes before the creation of leap years, or a negative year.
        if (year < 1752) {
            if (year < 0) {
                System.out.println("Negative years don't exist. So negative leap"
                        + " years don't exist either.");
            }
            else{
                System.out.println("Leap years weren't invented before 1752, "
                        + "go do some research.");
            }
        }
        //Otherwise it checks for the most basic criteria of a leap year, is it
        //diviisble by 4?
        else if (year%4 == 0){
                //Divisibility by 400 is only checked if divisibility by 100 is 
                //true because a number can't be divisible by 400 and not 100
                if (year%100 == 0) {
                    if (year%400 == 0) {
                        System.out.println(year + " is a leap year.");
                    }
                    else {
                    System.out.println(year + " is not a leap year.");
                    }
                }
                //If a year isn't divisible by 100 but it is by 4, it is 
                //guarunteed a leap year.
                else {
                    System.out.println(year + " is a leap year.");
                }
        }
        //If the year doesn't meet the abovw 2 criteria, it'a a valid year that
        //cannot be a leap year.
        else {
            System.out.println(year + " is not a leap year.");
        }
    }
    
}
