/*
 * Author: Jamie
 * Date: Mar 30, 2020
 * Version: v1.0
 * Description: This program calculates BMI. It takes height and weight in either
 * all metric or all imperial units. I double-checked the veracity of this
 * program using https://www.diabetes.ca/managing-my-diabetes/tools---resources/body-mass-index-(bmi)-calculator
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author revit
 */
public class BMI {
    //VARIABLES
    public static double height, weight, bmi;
    public static String unitChoice;
    public static boolean isMetric, validInput;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat decimal = new DecimalFormat ("0.0");
    
    public static void main(String[] args) {
        printSplash();
        unitChoice();
        /*I chose to have 2 separate functions for metric or imperial input 
        because it looks neater than one big method that has a bunch of if 
        statements that determine if "input lb" or "input kg" is printed and
        it's more efficient to run cause the computer checks 'isMetric' once*/
        if ( isMetric == true ){
            metricInput();
        }
        else {
            imperialInput();
        }
        /*There's only one method calculating final BMI since the formula's for
        metric and imperial are basically the same. The only difference is lbs
        has to be multiplied by 703, which get's done in inperialInput().*/
        getBMI();
    }
    
    public static void printSplash() {
        System.out.println("This is a BMI calculator. It will take your height");
        System.out.println("and weight in either imperial or metric and then ");
        System.out.println("calculate and output your BMI.");
        System.out.println("--------------------------------------------------");
    }

    public static void unitChoice() {
        do {
            System.out.print("\nMetric or imperial?: ");
            unitChoice = input.nextLine();
            if ( "metric".equalsIgnoreCase(unitChoice.trim()) ){
                isMetric = true;
                validInput = true;
            }
            else if ( "imperial".equalsIgnoreCase(unitChoice.trim()) ){
                validInput = true;
            }
            else {
                System.out.println("That's not a valid choice, try again.");
            }
        } while (validInput == false);
    }
    
    public static void metricInput() {
        do {
            System.out.print("Enter your weight in kg: ");
            weight = input.nextDouble();
            //I used my source site's cap of 600kg to determine my extreme data
            //limit. The height limit came from the world's tallest living man.
            if ( weight > 300 ) {
                System.out.println( weight + "kg is a lot. Not a lot of people"
                        + " weight that\nmuch. Try again.");
                validInput = false;
            }
            else if ( weight >= 20 ) {
                validInput = true;
            }
            else {
                System.out.println( weight + "kg seems too light for"
                        + " someone using this\nprogram. Try again.");
                validInput = false;
            }
        } while ( validInput == false);
        do {
            System.out.print("Enter your height in cm: ");
            height = input.nextDouble()/100.0;
            if ( height > 2.5 ) {
                System.out.println( height + "m? How come you're not in the "
                        + "book of world\nrecords? Try again.");
                validInput = false;
            }
            else if ( height >= 0.60 ) {
                validInput = true;
            }
            else {
                System.out.println( height + "m seems too short for"
                        + " someone using this\nprogram. Try again.");
                validInput = false;
            }
        } while ( validInput == false);
    }
    
    public static void imperialInput() {
        do {
            System.out.print("Enter your weight in lb: ");
            weight = input.nextDouble();
            if ( weight > 600 ) {
                System.out.println( weight + "lb is a lot. Not a lot of people"
                        + " weight that\nmuch.Try again.");
                validInput = false;
            }
            else if ( weight >= 50 ) {
                validInput = true;
            }
            else {
                System.out.println( weight + "kg seems too light for"
                        + " someone using this\nprogram. Try again.");
                validInput = false;
            }
        } while ( validInput == false);
        do {
            System.out.print("Enter your height in in: ");
            height = input.nextDouble();
            
            if ( height > 97 ) {
                System.out.println( height + "in? How come you're not in the "
                        + "book of world\nrecords? Try again.");
                validInput = false;
            }
            else if ( height >= 24 ) {
                validInput = true;
            }
            else {
                System.out.println( height + "m seems too short for"
                        + " someone using this\nprogram. Try again.");
                validInput = false;
            }
        } while ( validInput == false);
        //I mention why I do this in main().
        weight = weight * 703;
    }
    
    public static void getBMI(){
        bmi = weight/(Math.pow( height, 2 ));
        System.out.println("\nYour bmi is " + decimal.format(bmi));
        if ( bmi >= 40 ) {
            System.out.println("You're morbidly obese.");
        }
        else if ( bmi >= 30 ) {
            System.out.println("You're obese.");
        }
        else if ( bmi >= 25 ) {
            System.out.println("You're overweight.");
        }
        else if ( bmi >= 18.5) {
            System.out.println("This is ideal.");
        }
        else if ( bmi >= 16 ){
            System.out.println("You're underweight.");
        }
        else {
            System.out.println("You're severely underweight.");
        }
    }
    
}
