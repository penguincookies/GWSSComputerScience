/*
 * Author: Jamie
 * Date: May 17, 2020
 * Version: v1.0
 * Description: This program will take a "conventional bearing" direction and 
 * print out the directions to achieve it.
 */
package edu.hdsb.gwss.jamie.ics3u.u6;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class Compass {
    //VARIABLES
    public static String direction = "";
    public static int degrees = 0;
    //Assume valid data by default
    public static boolean valid = true;
    //There's only two possible lengths of normal data. I check the length often
    //so it made more sense to make constants 
    public static final int MAX_LENGTH = 4, MIN_LENGTH = 3;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        //INPUT
        printSplash();
        System.out.print("Enter direction: ");
        direction = input.nextLine();
        direction = direction.toUpperCase();
        direction = direction.trim();
        
        //PROCESSING
        /*A whole function dedicated to error checking. It can handle most data,
          however, it can't handle erroneous data where there are non-numbers 
          where the magnitude of degrees should be*/
        errorCheck();
       
        //OUTPUT
        if (valid){
            printDirections();
        }
        else{
            System.out.println("That's not a valid direction, try again.");
        }
    }
    
    public static void printSplash(){
        System.out.println("Compass Directions");
        System.out.println("Compass directions are written in the following form: S45W.");
        System.out.println("This indicates that the direction is determined by facing");
        System.out.println("This program has the user enter a compass direction and ");
        System.out.println("then prints a message.\n");
    }
    
    public static void errorCheck (){
        //The whole process is an if else if statement cause it only needs to 
        //find one error for the data to be invalid
        if (direction.length() > MAX_LENGTH || direction.length() < MIN_LENGTH){
            valid = false;
        }
        //Checks if the first character is not a N or S
        else if (direction.charAt(0) != 'N' && direction.charAt(0) != 'S'){
            valid = false;
        }
        else if (direction.length() == MAX_LENGTH){
            degrees = Integer.parseInt(direction.substring(1,MAX_LENGTH-1));
            /*The range is 1-89 because if the degrees turn was 90 or 0 that 
              would mean staight in one of the four directions, rendering 
              "conventional bearing" redundant*/
            if (degrees >= 90 || degrees == 0){
                valid = false;
            }
            //Checks if the last character is not an E or W
            else if (direction.charAt(MAX_LENGTH-1) != 'E' && direction.charAt(MAX_LENGTH-1) != 'W'){
            valid = false;
        }
        }
        else if (direction.length() == MIN_LENGTH){
            degrees = Integer.parseInt(direction.substring(1,MIN_LENGTH-1));
            if (degrees == 0){
                valid = false;
            }
            else if (direction.charAt(MIN_LENGTH-1) != 'E' && direction.charAt(MIN_LENGTH-1) != 'W'){
            valid = false;
        }
        }
    }
    
    public static void printDirections(){
        if (direction.charAt(0) == 'N'){
            System.out.print("Start facing NORTH,");
        }
        else{
            System.out.print("Start facing SOUTH,");
        }
        System.out.print(" then turn " + degrees + " degrees ");
        if (direction.length() == MAX_LENGTH){
            if (direction.charAt(MAX_LENGTH-1)  == 'E'){
                System.out.println("torwards the EAST.");
            }
            else {
                System.out.println("torwards the WEST.");
            }
        }
        else{
            if (direction.charAt(2)  == 'E'){
                System.out.println("torwards the EAST.");
            }
            else {
                System.out.println("torwards the WEST.");
            }
        }    
    }
    
}
