/*
 * Author: Jamie
 * Date: Apr 21, 2020
 * Version: v1.0
 * Description: A program that takes a given population of animals, a starting 
 * amount of food, the amount of food added per hour, and the number of hours 
 * and prints a table displaying the quantities for each at the end of an hour
 * for X hours.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class LabAnimals {
    //VARIABLES
    //Short for foodBefore and foodAfter
    public static int totalPopulation, foodB, foodA, foodPerHour, hour = 0;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        printSplash();
        userInput();
        printTable();
    }
    
    public static void printSplash(){
        System.out.println("Lab Animals\n");
        System.out.println("At present there are X animals in the lab and enough");
        System.out.println("food for Y animals.  At the end of every hour the");
        System.out.println("population doubles, and enough food is added to");
        System.out.println("support Z more animals. During any hour the animals");
        System.out.println("will eat enough food for only themselves. The program");
        System.out.println("will determine when the population will outgrow the");
        System.out.println("food supply.");
        System.out.println("-----------------------------------------------------\n");
    }
    
    public static void userInput(){
        //All the user inputs will only accept nonzero positive integers
        do{
            System.out.print("Enter the initial population              : ");
            totalPopulation = input.nextInt();
            if (totalPopulation <= 0) {
                System.out.println("That's not a valid amount, try again.");
            }
        }while (totalPopulation <= 0);
        do{
            System.out.print("Enter the initial food supply             : ");
            foodB = input.nextInt();
            if (foodB < 0) {
                System.out.println("That's not a valid amount, try again.");
            }
        }while (foodB < 0);
        do{
            System.out.print("Enter the amount of food to add each hour : ");
            foodPerHour = input.nextInt();
            if (foodPerHour < 0) {
                System.out.println("That's not a valid amount, try again.");
            }
        }while (foodPerHour < 0);
    }
    
    public static void printTable(){
        System.out.format( "%-4s | %-16s | %-13s | %-11s | %-14s\n", "Hour", "Animals at start", "Food at start", "Food at end", "Animals at end" );
        while (hour < 15){
            hour++;
            foodA = foodB + foodPerHour - totalPopulation;
            //If the animals are projected to run out of food prematurely, the 
            //table will stop
            if (foodA < 0){
                hour--;
                break;
            }
            System.out.format( "%-4s | %-16s | %-13s | %-11s | %-14s\n", hour, 
                    totalPopulation, foodB, foodA, totalPopulation*2 );
            totalPopulation = totalPopulation*2;
            foodB = foodA;
        }
        System.out.println("The animals will last for " + hour + " hour(s).");
    }
    
}
