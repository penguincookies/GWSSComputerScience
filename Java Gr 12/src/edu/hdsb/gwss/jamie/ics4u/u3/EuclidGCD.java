/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u3;

/**
 *
 * @author revit
 */
public class EuclidGCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(GDC(7, 9));
    }
    
    public static int GDC(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1 > num2) {
            return GDC(num2, num1 - num2);
        }
        if (num1 < num2) {
            return GDC(num1, num2 - num1);
        }
        return 0;
    }
    
}
