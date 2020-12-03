/*
 * Author: Jamie
 * Date: Apr 8, 2020
 * Version: v1.0
 * Description: Meese population tracker.
 */
package edu.hdsb.gwss.jamie.ics3u.u5;

/**
 *
 * @author revit
 */
public class MooseHerd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int yearsSupervised = 0;
        double yearFactor, meeseCount;
        
        System.out.println("The program will calculate the population of moose");
        System.out.println("in an area per year. This is assuming that 20 meese");
        System.out.println("were there to begin with. Once the population reaches");
        System.out.println("80, the meese will no longer require supervision.");
        System.out.println("-----------------------------------------------------\n");
        
        System.out.format( "%-3s | %-3s\n", "Y", "M" );
        
        
        for (int i = 1; i <= 25; i++){
            yearFactor = Math.pow (0.83, i);
            meeseCount = 220 / (1 + (10 * yearFactor));
            if (meeseCount < 80){
                yearsSupervised++;
            }
            System.out.format( "%3s | %3s\n", i, (int)meeseCount );
            
        }
        
        System.out.println("\nThe meese will need to be supervised for "
                + yearsSupervised + " years.");
        
    }
    
}
