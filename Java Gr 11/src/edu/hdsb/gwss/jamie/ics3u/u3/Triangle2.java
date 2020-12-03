/*
 * Author: Jamie
 * Date: Mar 26, 2020
 * Version: v1.0
 * Description: This program will take 3 side lengths and determine if those 
 * sides can form a triangle and if so, is it a right triangle.
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class Triangle2 {
    //VARIABLES
    //I didn;t capitalize a, b, or c since in math only the angles are in caps.
    public static double sidea, sideb, sidec, hypotenuse, legOne, legTwo;
    public static boolean validTriangle, validRight;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        printSplash();
        getSides();
        checkIfTriangle();
        checkIfRight();
        System.out.print("\nThese sides ");
        if ( validTriangle == true ) {
            System.out.print("can ");
        }
        else {
            System.out.print("cannot ");
        }
        System.out.print("make a ");
        if ( validRight == true ) {
            System.out.print ("right ");
        }
        System.out.println("triangle.");
    }
    
    public static void printSplash() {
        System.out.println("One property that unifies all triangles is that");
        System.out.println("one given side will always be smaller than the ");
        System.out.println("other two combined. This program will take 3 side");
        System.out.println("lengths and see if they can be formed into a");
        System.out.println("triangle. The program will also check if the");
        System.out.println("sides can be formed into a right angle triangle.");
        System.out.println("-------------------------------------------------");
    }
    
    public static void getSides() {
        //For each side, the program will continue to keep asking for a side
        //length if the side length is 0 or a negative
        do{
            System.out.print("\nEnter the length of side a: ");
            sidea = input.nextDouble();
            if (sidea <= 0) {
                System.out.println("That's not a valid side length, try again.");
            }
        }while (sidea <= 0);
        do{
            System.out.print("\nEnter the length of side b: ");
            sideb = input.nextDouble();
            if (sideb <= 0) {
                System.out.println("That's not a valid side length, try again.");
            }
        }while (sideb <= 0);
        do{
            System.out.print("\nEnter the length of side c: ");
            sidec = input.nextDouble();
            if (sidec <= 0) {
                System.out.println("That's not a valid side length, try again.");
            }
        }while (sidec <= 0);
    }
    
    public static void checkIfTriangle(){
        /*In order for the triangle to be verified, all the individual sides 
        have to be smaller than the sum of the other two so it's most 
        efficient to check the three criteria in nested if statements*/
        if  ( sidea + sideb > sidec ){
            if ( sideb + sidec > sidea ){
                if ( sidec + sidea > sideb ) {
                    validTriangle = true;
                }
            }
        }
    }
    
    public static void checkIfRight() {
        //Checks to find the larges side to "c" and the other two to "a" and "b"
        //Then performs a leftside-rightside check with Pythagorean's Theorem.
        legOne = Math.min ( sidea, sideb );
        hypotenuse = Math.max ( sidea, sideb );
        legTwo = Math.min ( sidec, hypotenuse );
        hypotenuse = Math.max ( sidec, hypotenuse);
        if ( Math.pow( legOne, 2 ) + Math.pow ( legTwo, 2 ) == Math.pow ( hypotenuse, 2 ) ){
            validRight = true;
        }
    }
    
}
