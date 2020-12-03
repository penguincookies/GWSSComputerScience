/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u;

import java.util.Scanner;

/**
 *
 * @author revit
 */
public class NumbersToWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String output = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 999: ");
        int num = input.nextInt();
        output = output + hundredsString(num/100);
        num = num - (num/100)*100;
        if (num > 10 && num < 20) {
            output = output + teensString(num);
        }
        else {
            output = output + tensString(num/10);
            num = num - (num/10)*10;
            output = output + onesString(num);
        }
        System.out.println(output);
    }
    
    public static String hundredsString(int hundredMultiple) {
        switch (hundredMultiple) {
            case 1:
                return "one-hundred ";
            case 2:
                return "two-hundred ";
            case 3:
                return "three-hundred ";
            case 4:
                return "four-hundred ";
            case 5:
                return "five-hundred ";
            case 6:
                return "six-hundred ";
            case 7:
                return "seven-hundred ";
            case 8:
                return "eight-hundred ";
            case 9:
                return "nine-hundred ";
            default:
                return "";
        }
    }
    
    public static String tensString(int tenMultiple) {
        switch (tenMultiple) {
            case 1:
                return "ten";
            case 2:
                return "twenty ";
            case 3:
                return "thirty ";
            case 4:
                return "forty ";
            case 5:
                return "fifty ";
            case 6:
                return "sixty ";
            case 7:
                return "seventy ";
            case 8:
                return "eighty ";
            case 9:
                return "ninety ";
            default:
                return "";
        }
    }
    
    public static String onesString(int oneMultiple) {
        switch (oneMultiple) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
    
    public static String teensString(int teen) {
        switch (teen) {
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }
}
