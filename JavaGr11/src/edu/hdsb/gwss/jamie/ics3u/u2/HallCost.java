/*
 * Author: Jamie
 * Date: Feb 23, 2020
 * Version: v0.1
 * Description: Calculates the cost of a rental hall with a flate rate of $350
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author revit
 */
public class HallCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initiates variables
        String name;
        int guests;
        double guestCost, totalCost;
        Scanner input = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        //Gets input
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("How many guests are coming?");
        guests = Integer.parseInt(input.nextLine());
        System.out.println("How much will it cost per person?");
        guestCost = Double.parseDouble(input.nextLine());
        
        //Output
        totalCost = (guestCost*guests)+350;
        System.out.println("Hello " + name + ", your total cost will be " + money.format(totalCost));
        
    }
    
}
