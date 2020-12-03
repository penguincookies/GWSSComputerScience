/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

import java.util.Scanner;

/**
 *
 * @author revit
 */
public class TryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Only the first exception caught will run
        try {
            int impossible = 5/1;
            //int impossible = 5/0;
            System.out.println("This code will only run if the code above is good");
            impossible = Integer.parseInt(input.nextLine());
        } catch (ArithmeticException ae) {
            System.out.println("Exception: " + ae);
        } catch (NumberFormatException nfe) {
            System.out.println("Exception: " + nfe);
        } catch (Exception e) {
            System.out.println("Other Exception");
        } finally {
            System.out.println("This code runs, exception or not");
        }
    }
    
}
