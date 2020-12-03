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
public class ArrayUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] [] numbers = {
            { 1, 2, 3, 4},
            { 5, 6 },
            { 7, 8, 9 },
            { 10, 11, 12, 13, 14, 15 },
            { 16, 17 }
        };
        display (numbers);
        System.out.println(sum(numbers));
        System.out.println(average(numbers));
        System.out.println(max(numbers));
        System.out.println(min(numbers));
    }
    
    public static void display ( int numbers [][] ) {
        for (int i = 0; i < numbers.length; i++) {
            display (numbers [i]);
            System.out.println("");
        }
    }
    
    public static void display ( int numbers[] ) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.format("%5s", numbers[i]);
        }
    }
    
    public static int sum ( int numbers [][] ) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sum = sum + numbers[i][j];
            }
        }
        return sum;
    }
    
    public static double average ( int numbers [][] ) {
        int sum = 0;
        double average;
        double count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sum = sum + numbers[i][j];
                count++;
            }
        }
        average = sum / count;
        return average;
    }
    
    public static int max ( int numbers [][] ) {
        int max = numbers [0][0];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                }
            }
        }
        return max;
    }
    
    public static int min ( int numbers [][] ) {
        int min = numbers [0][0];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] < min) {
                    min = numbers[i][j];
                }
            }
        }
        return min;
    }
    
}
