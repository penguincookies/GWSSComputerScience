/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class Easter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("This program will take a year and calculate when");
        System.out.println("Easter Sunday will be that year. \n");
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b+8) / 25;
        int g = (b-f+1) / 3;
        int h = ( 19 * a + b - d - g + 15 ) % 30;
        int i = c / 4;
        int k = c % 4;
        int j = ( 32 + 2*e + 2*i - h - k ) % 7;
        int m = ( a + 11*h + 22*j ) / 451;
        int month = ( h + j - 7*m + 114 ) / 31;
        int p = ( h + j - 7*m + 114 ) % 31;
        int day = p + 1;
        System.out.print("This year, Easter will be on (month/day): ");
        System.out.println( month + "/" + day );
    }
    
}
