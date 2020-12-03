/*
 * Author: Jamie
 * Date: Apr 15, 2020
 * Version: v1.0
 * Description: A program that displays the conversion of ounces to grams from
 * ounce values 1-15.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.text.DecimalFormat;
/**
 *
 * @author revit
 */
public class OuncesToGrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OBJECT
        DecimalFormat decimal = new DecimalFormat ("0.00");
        System.out.format("%-6s | %-6s\n", "Ounces", "Grams" );
        for (int i = 1; i < 16; i++) {
            double grams = 28.35 * i;
            //decimal.format was used to avoid avoid a trailing 00...1
            System.out.format("%-6s | %6s\n", i, decimal.format(grams) );
        }
    }
    
    public static void printSplash(){
        System.out.println("Once to grams conversion chart.\n");
        System.out.println("This program will print a titled table that can be");
        System.out.println("used to convert ounces to grams, for values 1 to 15.");
        System.out.println("(1 ounce = 28.35 grams)");
    }
    
}
