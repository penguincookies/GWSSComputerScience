/*
 * Author: Jamie
 * Date: Mar 11, 2020
 * Version: v0.1
 * Description: Takes the number of bolts, washers, and nuts you order and checks
 * if they are too few of any component and calculates total price
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author 3U Jamie
 */
public class OrderChecker {
    //CONSTANTS 
    public static final double BOLT_PRICE = 0.05;
    public static final double NUT_PRICE = 0.03;
    public static final double WASHER_PRICE = 0.01;
    
    //VARIABLES
    public static int bolts;
    public static int nuts;
    public static int washers;
    public static double total;
    
    //OBJECTS
    public static Scanner input = new Scanner (System.in);
    public static NumberFormat money = NumberFormat.getCurrencyInstance();
    
    
    
        public static void main(String[] args) {
        userPurchase();
        checkOrder();
        totalCost();
    }
        
        public static void userPurchase(){
            System.out.print("Enter the number of bolts to purchase: ");
            bolts = input.nextInt();
            System.out.print("Enter the number of nuts to purchase: ");
            nuts = input.nextInt();
            System.out.print("Enter the number of washers lts to purchase: ");
            washers = input.nextInt();
        }
        
        public static void checkOrder(){
            if ( nuts < bolts ) {
                System.out.println("\nCheck the order: too few nuts ");
            }
            if ( washers < (bolts*2) ) {
                System.out.println("Check the order: too few washers");
            }
        }
        
        public static void totalCost(){
            total = (bolts*BOLT_PRICE) + (nuts*NUT_PRICE) + (washers*WASHER_PRICE);
            System.out.println("Your total is: " + money.format(total));
        }
    
}
