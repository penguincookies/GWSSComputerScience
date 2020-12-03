/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: Takes the subtotal and the tip percent and adds them both
 * to get the grand total
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class TipCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double amount, tipPercent;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your subtotal");
        amount = input.nextDouble();
        System.out.println("Enter the tip percent");
        tipPercent = input.nextDouble();
        double tipTotal = amount * (tipPercent * 0.01);
        double grandTotal = amount + tipTotal;
        System.out.print("Subtotal is $" + amount + ". Tip percent is " + tipPercent + "%. Total tip amount is $");
        System.out.format("%2.2f", tipTotal);
        System.out.print(". Total due is $");
        System.out.format("%2.2f", grandTotal);
        System.out.println(".");
    }
    
}
