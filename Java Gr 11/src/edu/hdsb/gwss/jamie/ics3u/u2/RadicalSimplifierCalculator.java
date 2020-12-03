/*
 * Author: Jamie
 * Date: Feb 27, 2020
 * Version: v1.0
 * Description: A calculator that takes in a radian with an integer coeffcient
 * and radicand and simplifies it using radical rules
 * Double checked using:
 * https://www.symbolab.com/solver/radical-equation-calculator/2%5Csqrt%7B432%7D
 */
package edu.hdsb.gwss.jamie.ics3u.u2;

import java.util.Scanner;

/**
 *
 * @author 3U Jamie
 */
public class RadicalSimplifierCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CONSTANTS

        //VARIABLES
        double coefficient = 0;
        double radicand = 0;
        double constRadicand; //Placeholder for the radicand
        double highestRoot; //The square root of the highest possible number the radicand is divisible by
        double constRoot; //Placeholder for highest root

        //OBJECT
        Scanner input = new Scanner(System.in);

        //SPLASH PAGE
        System.out.println("This program will take any radical with an");
        System.out.println("integer radicand and completely simplifies it.");
        System.out.println("----------------------------------------------\n");

        //INPUT
        System.out.print("Enter the integer coefficient of the radical: ");
        coefficient = input.nextDouble();
        System.out.print("Enter the integer radicand of the radical: ");
        constRadicand = input.nextDouble();
        System.out.println("\nYour radical is: "
                + (int) coefficient + "\u221A"
                + (int) constRadicand);

        //PROCESSING
        highestRoot = Math.floor(Math.sqrt(constRadicand));
        constRoot = highestRoot;
        for (double i = 0; i < constRoot; i++) {
            radicand = constRadicand / Math.pow(highestRoot, 2);
            if (radicand == Math.floor(radicand)) {
                i = i + constRoot;
            } else {
                highestRoot--;
            }
        }

        coefficient = coefficient * highestRoot;

        //OUTPUT
        System.out.println("The simplifed form is: "
                + (int) coefficient + "\u221A"
                + (int) radicand);

    }

}
