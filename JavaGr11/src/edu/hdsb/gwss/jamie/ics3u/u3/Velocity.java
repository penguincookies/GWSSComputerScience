/*
 * Author: Jamie
 * Date: Mar 2, 2020
 * Version: v0.1
 * Description: A velocity calculator using displacement and total time
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class Velocity {
    //VARIABLES
    public static double displacement, time, velocity;
    public static String direction;
    public static Scanner input = new Scanner (System.in);
    /**
     //* @param args the command line arguments
     */
    
    //INPUT
    public static void dataCollection() {
        System.out.print("Enter the total displacement in meters here: ");
        displacement = Double.parseDouble(input.nextLine());
        System.out.print("Enter the direction here: ");
        direction = input.nextLine();
        System.out.print("Enter the total time in seconds here: ");
        time = input.nextDouble();
    }
    
    //PROCESSING
    public static void velocity() {
        velocity = displacement/time;
        //OUTPUT
        System.out.println("\nThe average velocity is " + velocity + "m/s " 
                + "[" + direction + "]");
    }
    
    public static void main(String[] args) {
        //SPLASH PAGE
        System.out.println("This program will take displacement and total time\n"
                + "and will calculate the average valocity.");
        System.out.println("----------------------------------------------"
                + "----\n");
        dataCollection();
        velocity();
    }
    
}