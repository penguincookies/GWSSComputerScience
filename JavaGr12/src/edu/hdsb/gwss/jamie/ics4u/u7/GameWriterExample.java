/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

import java.io.RandomAccessFile;

public class GameWriterExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //CREATES 4 NEW GAMERECORDS
        GameRecordExample g1 = new GameRecordExample("Halo", "FPS", 2001);
        GameRecordExample g2 = new GameRecordExample("Super Mario Bros", "Platformer", 1985);
        GameRecordExample g3 = new GameRecordExample("Wii Sports", "Sport", 2006);
        GameRecordExample g4 = new GameRecordExample("Final Fantasy 7", "RPG", 1997);
        
        RandomAccessFile raf = new RandomAccessFile( "game_info.dat", "rw" );
        
        raf.seek(0);
        
        raf.writeChars(g1.getGameName());
        raf.writeChars(g1.getGenre());
        raf.writeInt(g1.getYearPublished());
        System.out.println("Length: " + raf.length());
        
        raf.writeChars(g2.getGameName());
        raf.writeChars(g2.getGenre());
        raf.writeInt(g2.getYearPublished());
        System.out.println("Length: " + raf.length());
        
        raf.writeChars(g3.getGameName());
        raf.writeChars(g3.getGenre());
        raf.writeInt(g3.getYearPublished());
        System.out.println("Length: " + raf.length());
        
        raf.writeChars(g4.getGameName());
        raf.writeChars(g4.getGenre());
        raf.writeInt(g4.getYearPublished());
        System.out.println("Length: " + raf.length());
        
        raf.close();
    }
    
}
