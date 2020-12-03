/*
 * Author: Jamie
 * Date: Feb 18, 2020
 * Version: v0.1
 * Description: Takes 2 sides and an angle of a triangle from user input to
 * use Cosine law and find the length of the third side.
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
/**
 *
 * @author 3U Jamie
 */
public class CosineLaw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Use Integer.parseInt to convert nextLine to an int 
        //so [enter] is not seen as the "next line"
        
        System.out.println("Enter the length of side a");
        double sidea = input.nextDouble();
        System.out.println("Enter the length of side b");
        double sideb = input.nextDouble();
        System.out.println("Enter the size of angle C in degrees");
        double angleC= input.nextDouble();
        double radiansC = angleC*Math.PI/180;
        
        double sidec = Math.sqrt(Math.pow(sideb, 2) + Math.pow(sidea, 2) - 2*sidea*sideb*Math.cos(radiansC));
        System.out.println("THe length of side c is " + sidec);
        
    }
    
}
