/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

/**
 *
 * @author revit
 */
public class GameRecordExample {
    
    //CLASS CONSTANTS
    public static final int LENGTH_NAME = 20;
    public static final int LENGTH_GENRE = 10;
    //ints take up 4 bytes
    //chars take up 2 bytes each
    public static final int RECORD_LENGTH = 64;
    
    //INSTANCE VARIABLES
    private String gameName;
    private String genre;
    private int yearPublished;
    private int dbID;
    
    public GameRecordExample() {
        this.dbID = -1;
    }
    public GameRecordExample(int dbid) {
        this.dbID = dbid;
    }
    public GameRecordExample(String name, String genre, int year) {
        this.setGameName(name);
        this.setGenre(genre);
        this.yearPublished = year;
    }
    
    public String getGameName() {
        return this.gameName;
    }
    
    public void setGameName(String gameName) {
        StringBuilder temp = new StringBuilder();
        
        if (gameName != null) {
            temp.append(gameName);
        }
        else {
            temp.append("");
        }
        
        temp.setLength(LENGTH_NAME);
        this.gameName = temp.toString();
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        StringBuilder temp = new StringBuilder();
        
        if (genre != null) {
            temp.append(genre);
        }
        else {
            temp.append("");
        }
        
        temp.setLength(LENGTH_GENRE);
        this.genre = temp.toString();
    }
    
    public int getYearPublished() {
        return this.yearPublished;
    }
    
    public void setYearPublished(int year) {
        this.yearPublished = year;
    }
    
    public int getDatabaseID() {
        return this.dbID;
    }
    
    public void setDatabaseID(int dbid) {
        this.dbID = dbid;
    }
    
    @Override
    public String toString() {
        return "GameRecord(Name: " + this.gameName + ", Genre: " + this.genre +
                ", Year Published: " + this.yearPublished + ")";
    }
}
