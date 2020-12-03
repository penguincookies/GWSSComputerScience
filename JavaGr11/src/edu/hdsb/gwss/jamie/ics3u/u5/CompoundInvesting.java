/*
 * Author: Jamie
 * Date: Apr 19, 2020
 * Version: v1.0
 * Description: This program calculates compounding annual intrest for a period
 * of up to 15 years. I double checked using https://www.bankrate.com/calculators/savings/compound-savings-calculator-tool.aspx
 * The site had rounding errors so I also doubled checked by doing all the math
 * for one test case manually.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.util.Scanner;
import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 *
 * @author revit
 */
public class CompoundInvesting {
    //VARIABLES
    //Short for totalBefore and totalAfter
    public static double investment, rate, interest, totalB, totalA;
    public static int years;
    public static boolean valid = false;
    
    //OBJECTS
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat decimal = new DecimalFormat ("0.00");
    
   
    public static void main(String[] args) {
        printSplash();
        userInput();
        printTable();
    }
    
    public static void printSplash(){
        System.out.println("Compound Investing");
        System.out.println("This program will print out a title table that will");
        System.out.println("display the amount of a yearly investment over a");
        System.out.println("period of up to 15 tears.");
        System.out.println("---------------------------------------------------");
    }
    
    public static void userInput(){
        do{
            System.out.print("\nEnter the yearly investment: ");
            investment = input.nextDouble();
            //Check if the amount has more than 2 decimal places or if it's less
            //than a cent
            if (investment < 0.01 || BigDecimal.valueOf(investment).scale() > 2) {
                System.out.println("That's not a valid amount of money, try again.");
                valid  = false;
            }
            else{
                valid = true;
            }
        }while (valid == false);
        do{
            System.out.print("Enter the interest rate (%): ");
            rate = input.nextDouble();
            //I don't think fractional percents are real and if someone has a 0%
            //interest rate, they don't need this prgram.
            if (rate < 1 || rate > 100) {
                System.out.println("That's not a valid rate, try again.");
                valid = false;
            }
            else{
                valid = true;
            }
        }while (valid == false);
        do{
            System.out.print("Enter the number of years: ");
            years = input.nextInt();
            if (years < 1 || years > 15) {
                System.out.println("That's not a valid number of years, try again.");
                valid = false;
            }
            else{
                valid = true;
            }
        }while (valid == false);
    }
    
    public static void printTable(){
        rate = (rate/100);
        totalB = investment;
        System.out.format( "%-4s | %-17s | %-8s | %-10s\n", "Year", "Amount In Account", "Interest", "Total" );
        //'i' represents
        for (int i = 0; i <= years; i++) {
            interest = totalB*rate;
            totalA = totalB + interest;
            System.out.format( "%4s | %17s | %8s | %10s\n", i, 
                    decimal.format(totalB), decimal.format(interest), 
                        decimal.format(totalA) );
            totalB = totalA + investment;
        }
    }
    
}
