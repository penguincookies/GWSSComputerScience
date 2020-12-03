/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: Makes a chart based on a quadratic equation using 
 * System.out.format
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class ValueOfQuadratic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner findX = new Scanner(System.in);
        double x = findX.nextDouble();
        double solution;
        
        System.out.println("For y = 3x^2 - 8X + 4:");
        //System.out.println("At x = " + x + ", the value of y is " + solution);
        System.out.format( "%-10s | %-10s\n", "x", "y" );
        for (int i = -4; i <= 4; i++) {
            solution = (3 * Math.pow(x, 2)) - (8 * x) + 4;
            System.out.format( "%10.2f | %10.2f\n", x, solution );
            x++;
        }
        
    }
    
}
