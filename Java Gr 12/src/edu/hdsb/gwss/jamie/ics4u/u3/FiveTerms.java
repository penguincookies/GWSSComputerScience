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
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sequenceOne(5));
        System.out.println(sequenceTwo(5));
    }
    
    public static int sequenceOne(int term) {
        if(term < 1){
            return -1;
        }
        
        switch(term){
            case 1:
                return 1;
            case 2:
                return 3;
            default:
                return sequenceOne(term-1) + sequenceOne(term-2);
        }
    }
    
    public static double sequenceTwo (int term){
        if (term < 1) {
            return -1;
        }
        if(term == 1){
            return 2;
        }
        else{
            return Math.sqrt((3*sequenceTwo(term-1))+4);
        }
    }
    
}
