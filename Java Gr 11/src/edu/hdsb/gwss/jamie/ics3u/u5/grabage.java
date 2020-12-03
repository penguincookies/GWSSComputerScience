/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;

/**
 *
 * @author revit
 */
public class grabage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 11111111;
        String entry = "" + number;
            int tenMagnitude = (entry.length())-1;
            double divisor = Math.pow(10, tenMagnitude);
            double total = 0;
            for(double i = 0; number != 0; i++){
                double result = (number/divisor)*(Math.pow(2, i));
                total = total + result;
                System.out.println(total);

                if(number == 0){
                    System.out.println(total);
                    System.out.println(i);
                }
            }
    }
    
}
