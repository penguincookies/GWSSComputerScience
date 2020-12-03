/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u2;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author revit
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String colorCombo;
        String colors [] = new String [3];
        double resistance;
        colorCombo = getInput();
        colors = getColors(colorCombo);
        resistance = calculateResistance(colors);
        System.out.println("The value of the resistor is " + resistance + " ohms");
    }
    
    public static String getInput () {
        Scanner input = new Scanner (System.in);
        System.out.println("What is your resistor's color code?");
        System.out.println("Separate each color with hyphens");
        System.out.println("Ex: Red-Black-Blue");
        String colorCombo = input.nextLine();
        return colorCombo;
    }
    
    public static String[] getColors (String colorCombo) {
        String colors [] = new String [3];
        StringTokenizer st = new StringTokenizer ( colorCombo, "-" );
        for (int i = 0; i < 3; i++) {
            colors [i] = st.nextToken();
        }
        return colors;
    }
    
    public static double calculateResistance ( String colors[] ) {
        String colorValues [] = { "black", "brown", "red", "orange", "yellow", 
                                    "green", "blue", "violet", "grey", "white" };
        int bandValues [] = new int [3];
        double resistance;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (colors [i].equalsIgnoreCase(colorValues [j])) {
                    bandValues[i] = j;
                    break;
                }
            }
        }
        resistance = (bandValues[0]*10 + bandValues[1]) * Math.pow(10, bandValues[2]);
        
        return resistance;
    }
    
}
