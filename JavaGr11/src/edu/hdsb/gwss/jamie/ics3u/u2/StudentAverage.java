/*
 * Author: Jamie
 * Date: Feb 23, 2020
 * Version: v0.1
 * Description: Takes a student's 4 marks and calculates the average and the 
 * formats it into a table.
 */
package edu.hdsb.gwss.jamie.ics3u.u2;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author revit
 */
public class StudentAverage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize variables
        int mark1, mark2, mark3, mark4;
        double average;
        String name;
        Scanner findName = new Scanner(System.in);
        Scanner findMark = new Scanner(System.in);
        NumberFormat percent = NumberFormat.getPercentInstance();
        
        //Gets input
        System.out.println("Enter name");
        name = findName.nextLine();
        System.out.println("Enter first mark");
        mark1 = findMark.nextInt();
        System.out.println("Enter second mark");
        mark2 = findMark.nextInt();
        System.out.println("Enter third mark");
        mark3 = findMark.nextInt();
        System.out.println("Enter fourth mark");
        mark4 = findMark.nextInt();
        
        //Output
        average = (mark1 + mark2 + mark3 + mark4)/4.0;
        System.out.println(name + "'s Marks");
        System.out.format("%-7s | %3s\n", "Mark 1", mark1 + "%");
        System.out.format("%-7s | %3s\n", "Mark 2", mark2 + "%");
        System.out.format("%-7s | %3s\n", "Mark 3", mark3 + "%");
        System.out.format("%-7s | %3s\n", "Mark 4", mark4 + "%");
        System.out.format("%-7s | %3s\n", "Average", Math.round(average) + "%");
        
    }
    
}
