/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;

/**
 *
 * @author revit
 */
public class TypeConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "From / To", "Boolean", "Char", "Int", "Long", "Double", "String" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "Boolean", "---", "N/A", "N/A", "N/A", "N/A", "s = String.valueOf(b)" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "Char", "N/A", "---", "i = (int) c", "l = (long) c", "d = (double) c", "s = String.valueOf(c)" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "Int", "N/A", "c = (char) i", "---", "l = i", "d = i", "s = String.valueOf(i)" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "Long", "N/A", "c = (char) l", "i = (int) l", "---", "d = l", "s = String.valueOf(l" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "Double", "N/A", "c = (char) d", "i = (int) d", "l = (long) d", "---", "s = String.valueOf(d)" );
        System.out.format( "%-9s | %-25s | %-25s | %-25s | %-25s | %-25s | %-30s\n", "String", "b = Boolean.valueOf(s)", "N/A", "i = Integer.parseInt(s)", "l = Long.parseLong(s);", "d = Double.parseDouble(s)", "---" );
        
        boolean b = true;
        int i = 65;
        String s = "24.1";
        char c = 'z';
        long l = 400000;
        double d = 78.1;
    }
    
}
