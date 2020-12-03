/*
 * Author: Jamie
 * Date: Feb 23, 2020
 * Version: v0.1
 * Description: Uses Heron's Formula to get three sides of a triangle to find
 * the area
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class HeronFormula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sidea, sideb, sidec, s, area;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter side A's length");
        sidea = input.nextDouble();
        System.out.println("Enter side B's length");
        sideb = input.nextDouble();
        System.out.println("Enter side C's length");
        sidec = input.nextDouble();
        s = (sidea + sideb+ sidec)/2.0;
        area = Math.sqrt(s*(s-sidea)*(s-sideb)*(s-sidec));
        System.out.println("The area of the triangle is " + area);
    }
    
}
