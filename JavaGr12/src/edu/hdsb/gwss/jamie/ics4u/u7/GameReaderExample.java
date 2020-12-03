/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

import java.io.RandomAccessFile;

/**
 *
 * @author revit
 */
public class GameReaderExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        RandomAccessFile raf = new RandomAccessFile( "game_info.dat", "rw" );
        
        //empty container
        GameRecordExample g = new GameRecordExample();
        
        char word[] = new char[GameRecordExample.LENGTH_NAME];
        for (int i = 0; i < GameRecordExample.LENGTH_NAME; i++) {
            word[i] = raf.readChar();
        }
        g.setGameName(new String(word));
        
        word = new char[GameRecordExample.LENGTH_GENRE];
        for( int i = 0; i < GameRecordExample.LENGTH_GENRE; i++ ) {
            word[i] = raf.readChar();
        }
        g.setGenre(new String( word ) );

        g.setYearPublished( raf.readInt() );

        System.out.println( g.toString() );
        
        word = new char[GameRecordExample.LENGTH_NAME];
        for (int i = 0; i < GameRecordExample.LENGTH_NAME; i++) {
            word[i] = raf.readChar();
        }
        g.setGameName(new String(word));
        
        word = new char[GameRecordExample.LENGTH_GENRE];
        for( int i = 0; i < GameRecordExample.LENGTH_GENRE; i++ ) {
            word[i] = raf.readChar();
        }
        g.setGenre(new String( word ) );

        g.setYearPublished( raf.readInt() );

        System.out.println( g.toString() );
        
        //reset pointer
        raf.seek(0);
        
        word = new char[GameRecordExample.LENGTH_NAME];
        for (int i = 0; i < GameRecordExample.LENGTH_NAME; i++) {
            word[i] = raf.readChar();
        }
        g.setGameName(new String(word));
        
        word = new char[GameRecordExample.LENGTH_GENRE];
        for( int i = 0; i < GameRecordExample.LENGTH_GENRE; i++ ) {
            word[i] = raf.readChar();
        }
        g.setGenre(new String( word ) );

        g.setYearPublished( raf.readInt() );

        System.out.println( g.toString() );
    }
    
}
