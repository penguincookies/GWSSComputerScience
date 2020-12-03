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
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*System.out.println(functionOne(5,3));
        System.out.println(functionOne(2,2));
        System.out.println(functionOne(1,4));
        System.out.println(functionOne(-5,-2));*/
        System.out.println(ackermannsFunction(1,1));
        System.out.println(ackermannsFunction(2,1));
        //System.out.println(ackermannsFunction(5,5));
        System.out.println(ackermannsFunction(3,0));
    }
    
    //f OF X AND Y WILL ALWAYS BE THE DIFFERENCE FROM THE GREATER
    //OF THE TWO TO THE LESSER OF THE TWO
    public static int functionOne(int x, int y) {
        if (x == y){
            return 0;
        }
        if (x < y){
            return -1*functionOne(y, x);
        }
        else {
            return 1+functionOne(x-1,y);
        }
    }
    
    public static int ackermannsFunction(int m, int n) {
        if (m < 0 || n < 0) {
            System.out.println("Negative Error");
            return -1;
        }
        if (m == 0) {
            return n+1;
        }
        if (m > 0 && n ==0) {
            return ackermannsFunction(m-1, 1);
        }
        return ackermannsFunction(m-1, ackermannsFunction(m, n-1));
    }
    
}
