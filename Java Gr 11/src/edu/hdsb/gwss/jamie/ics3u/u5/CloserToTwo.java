/*
 * Author: Jamie
 * Date: Apr 21, 2020
 * Version: v1.1
 * Description: A program the keeps adding negative powers to 1 so that the sum
 * get close, but never to 0
 */
package edu.hdsb.gwss.jamie.ics3u.u5;

/**
 *
 * @author revit
 */
public class CloserToTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        double sum = 0, addend = 0; 
        long power;
        
        System.out.println("This program demonstrates that the result of adding");
        System.out.println("numbers 1, 1/2, 1/4, 1/16, ...  and so on as it gets");
        System.out.println("closer to 2 without ever becoming 2.\n");
        for (int i = 0; sum < 2; i++) {
            power = (long)Math.pow(2, i);
            sum = addend + 1.0/power;
            System.out.println(addend + " + 1/" + power + " = " + sum);
            addend = sum;
        }
    }
}
