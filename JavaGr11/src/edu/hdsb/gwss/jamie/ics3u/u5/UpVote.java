/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class UpVote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int lineNum = 0;
        int poundNum = 0;
        
        //OBJECTS
        Scanner input = new Scanner(System.in);
        
        System.out.println("The program will point an arrow.");
        System.out.print("How many lines tall should the arrow be: ");
        lineNum = input.nextInt();
        
        
        for (int i  = lineNum; i > 0; i--){
            for (int s = i; s > 0; s--){
                System.out.print(" ");
            }
            poundNum += 2;
            for (int n  = poundNum; n > 0; n--){
            System.out.print("&");
            }
            System.out.println("");   
        }
        
        for (int i = 2; i > 0; i--){
            for (int s = lineNum; s > 0; s--){
                System.out.print(" ");
            }
            System.out.println("&&");
        }
        
    }
    
}
