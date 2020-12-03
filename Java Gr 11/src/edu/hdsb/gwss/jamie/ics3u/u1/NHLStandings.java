/*
 * Author: Jamie
 * Date: Feb 07, 2020
 * Version: v0.1
 * Description: Table of current NHL standings
 */
package edu.hdsb.gwss.jamie.ics3u.u1;
/**
 *
 * @author A Jamie Y
 */
public class NHLStandings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Eastern Confernce Standings NHL");
        System.out.println("");
        System.out.format( "%-20s | %-2s | %-2s | %-2s | %-3s\n", "Team", "W", "L", "GP", "Pts" );
        System.out.format( "%-20s | %2s | %2s | %2s | %3s\n", "Boston Bruins", "33", "10", "55", "78" );
        System.out.format( "%-20s | %2s | %2s | %2s | %3s\n", "Washington Capitals", "36", "13", "54", "77" );
        System.out.format( "%-20s | %2s | %2s | %2s | %3s\n", "Tampa Bay Lightning", "34", "15", "54", "73" );
        System.out.format( "%-20s | %2s | %2s | %2s | %3s\n", "Pittsburgh Penguins", "33", "15", "53", "71" );
       /* System.out.println(""); 
        System.out.println("Team                    W   L   GP  Pts");
        System.out.println("Boston Bruins           33  10  55  78");
        System.out.println("Washington Captials                36  13  54  77");
        System.out.println("tampa Bay Lightning               34  15  54  73");
        System.out.println("Pittsburgh Penguins                33  15  53  71");
        */
    }

}
