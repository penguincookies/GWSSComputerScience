/*
 * Author: Jamie
 * Date: Apr 5, 2020
 * Version: v1.0
 * Description: A program that takes two integers and prints all integers between
 * them inclusive.
 */
package edu.hdsb.gwss.jamie.ics3u.u4;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class StartEnd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int intOne, intTwo;
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        printSplash();
        System.out.print("Enter the first integer: ");
        intOne = input.nextInt();
        System.out.print("Enter the next integer: ");
        intTwo = input.nextInt();
        
        for (int i = Math.min(intOne, intTwo); i <= Math.max(intOne, intTwo); i++){
            System.out.print(i + " ");
        }
    }
    
    public static void printSplash(){
        System.out.println("Enter two integers and the program will");
        System.out.println("print all integers between the two inclusive.");
        System.out.println("---------------------------------------------\n");
    }
    
}
