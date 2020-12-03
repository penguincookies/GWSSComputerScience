/*
 * Author: Jamie
 * Date: Mar 23, 2020
 * Version: v0.2
 * Description: A program that takes a pH value of water and determines whether
 * or not it's habitable for fish. It will loop until a valid pH value is entered.
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author revit
 */
public class AcidRain {
    //VARIABLES
    public static double pHValue;
    //Used to tell the program whether or not to ask for a pH value again.
    //Set to false by default.
    public static boolean validpH = false;
    
    //CONSTANTS
    public static double ACID_THRESHOLD = 6.4;
    public static double ALKALINE_THRESHOLD = 7.4;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat decimal = new DecimalFormat ("0.0");
    
    
    public static void main(String[] args) {
        printSplash();
        checkpH();
    }
    
    public static void printSplash() {
        System.out.println("This program will determine if a body of water's");
        System.out.println("pH is habititable to fish living there.");
        System.out.println("------------------------------------------------");
    }
    
    public static void checkpH() {
        //The loop will ask for a pH value and then it will ask again depending
        //on the validity of the response.
        do {
            System.out.print("\nEnter the water's pH level: ");
            pHValue = input.nextDouble();
            System.out.println("");
            //First checks for invalid extreme data.
            if (pHValue < 0 || pHValue > 14){
                System.out.println(decimal.format(pHValue) + " falls outside of "
                        + "the pH scale. Try again.");
            }
            else if (pHValue < ACID_THRESHOLD) {
                System.out.println("TOO ACIDIC - Fish will not survive.");
                /* Normal rain has a pH of 5.6. Acid rain ranges from 
                   4.2 to 4.4 in acidity. It seems unreasonable the the pH level
                   of a body of water drop below 3. So I set the benchmark of 
                   valid extreme data to +/-3 of 0 or 14.
                   Since it's very unlikely that the water's pH ever goes below
                   3 r above 11, the program assumes user error it something of
                   the like is inputted.*/
                if (pHValue <= 3) {
                    System.out.println("A pH value of " + decimal.format(pHValue)
                            + " is close to vinegar. \nTry recalibrating "
                            + "equipment and try again.");
                }
                else {
                    validpH = true;
                }
            }
            else if (pHValue > ALKALINE_THRESHOLD) {
                System.out.println("TOO ALKALINE - Fish will not survive.");
                if (pHValue >= 11) {
                    System.out.println("A pH value of " + decimal.format(pHValue)
                            + " is close to vinegar. \nTry recalibrating "
                            + "equipment and try again.");
                }
                else {
                    validpH = true;
                }
            }
            //If a pH value isn't invalid, acidic, or alkaline, then it's neutral
            else {
                System.out.println("NEUTRAL - Fish will survive,");
                validpH = true;
            }
            
        } while (validpH == false);
    }
        
}
