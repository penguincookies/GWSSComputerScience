/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: A calculator coverting a C temperature to F
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class CelsiusToFahrenheit {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner findTemperature = new Scanner(System.in);
        System.out.println("Enter the temperature in Celcius");
        double celsius = findTemperature.nextDouble();
        double fahrenheit =  (celsius * 9/5) + 32;
        System.out.print( celsius + " degrees celsius is ");
        System.out.format("%3.1f", fahrenheit);
        System.out.println(" degrees Fahrenheit");
    }
    
}
