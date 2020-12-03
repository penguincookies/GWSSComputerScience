/*
 * Author: Jamie
 * Date: Mar 2, 2020
 * Version: v0.1
 * Description: Calculating the aspects of a quadratic funtion using methods
 */
package edu.hdsb.gwss.jamie.ics3u.u3;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author 3U Jamie
 */
public class Quadratics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        double a = 1;
        double b = -2;
        double c = -3;
        double discriminant = 0;
        double vertexX = 0;
        double vertexY = 0;
        double root1 = 0;
        double root2 =0;
        
        
        Scanner input = new Scanner(System.in);
        discriminant = findDiscriminant( discriminant, a, b, c );
        System.out.println("Discriminant: " + discriminant);
        vertexX = axisSymmetry( vertexX, a, b);
        System.out.println("Axis of Symmetry: " + vertexX);
        vertexY = vertex(vertexX, vertexY, a, b, c);
        System.out.println("Vertex: " + vertexX + ", " + vertexY);
        System.out.println("Y-Intercept: " + c);
        root1 = rootOne(root1, discriminant, a, b, c);
        root2 = rootTwo(root2, discriminant, a, b, c);
        System.out.println("Roots: (" + root1 + ", 0.0), (" + root2 + ", 0.0)");
        
    }
    
    public static double findDiscriminant( double discriminant, double a, double b, double c){
        discriminant = Math.sqrt(Math.pow( b, 2) - (4*a*c));
        return discriminant;
    }
    
    public static double axisSymmetry (double vertexX, double a, double b){
        vertexX = (-1*b)/(2*a);
        return vertexX;
    }
    
    public static double vertex (double vertexX, double vertexY, double a, double b, double c){
        vertexY = a*Math.pow(vertexX, 2) + b*vertexX + c;
        return vertexY;
    }
    
    
    public static double rootOne (double root1, double discriminant, double a, double b, double c){
        root1 = ((-1*b)+discriminant)/(2*a);
        return root1;
    }
    
    public static double rootTwo (double root2, double discriminant, double a, double b, double c){
        root2 = ((-1*b)-discriminant)/(2*a);
        return root2;
    }
    
}
