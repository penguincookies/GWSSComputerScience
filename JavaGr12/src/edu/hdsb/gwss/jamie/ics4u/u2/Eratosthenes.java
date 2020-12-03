/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u2;

/**
 *
 * @author revit
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean numbers[] = new boolean[1000]; 
        numbers = findPrimes(numbers);
        printResult(numbers);
    }
    
    public static boolean[] findPrimes (boolean[] numbers) {
        numbers [0] = true;
        for (int i = 1; i <= numbers.length/2; i++) {
            if (numbers[i] == false) {
                for (int j = (i*2)+1 ; j < numbers.length; j += (i+1)) {
                    numbers [j] = true;
                }
            }
        }
        return numbers;
    }
    
    public static void printResult (boolean[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers [i] == false) {
                System.out.format("%4s", i+1);
                counter++;
            }
            if (counter == 12) {
                System.out.println("");
                counter = 0;
            }
        }
    }
    
}
