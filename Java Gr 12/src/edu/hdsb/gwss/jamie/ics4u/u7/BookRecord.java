/*
 * Author: Jamie
 * Date: November 4, 2020
 * Version: v1.1
 * Description: A record/container to store data about a given book. Stores:
 * the title
 * the author
 * the year it was published
 * the number of pages it has
 * its Dewey decimal number
 * its condition
 * whether or not its hardcover
 * The record can also store a database ID for compatibility with BookRecordDB.java
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

public class BookRecord {
    
    //CLASS CONSTANTS
    public static final int TITLE_LENGTH = 25;
    public static final int AUTHOR_LENGTH = 20;
    //ints are 4 bytes each
    //doubles are 8 bytes each
    //chars are 2 bytes each 
    //booleans are 1 byte each
    public static final int RECORD_LENGTH = 109;
    
    //INSTANCE VARIABLES
    private String title;
    private String author;
    private int yearPublished;
    private int pageCount;
    private double dewey;
    //n FOR NEW, g FOR GOOD, p FOR POOR
    private char condition;
    private boolean hardcover;
    //THE DEFAULT DBID SIGNIFIES THAT IT HASN'T BEEN ADDED TO THE DATABASE YET
    private long dbid = -1;
    
    //CONSTRUCTORS
    public BookRecord() {
    }
    public BookRecord(long dbid) {
        this.dbid = dbid;
    }
    public BookRecord(String title, String author, int yearPublished, int pageCount, double dewey, char condition, boolean hardcover) {
        this.setTitle(title);
        this.setAuthor(author);
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
        this.dewey = dewey;
        this.condition = condition;
        this.hardcover = hardcover;
    }

    //GETTERS AND SETTERS
    //THE STRINGS HAVE DIFFERENT SETTERS SO THAT THEY ARE EXACTLY THE DESIRED LENGTH
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        StringBuilder temp = new StringBuilder();
        
        if (title != null && title.length() > 1) {
            temp.append(title);
        }
        else {
            temp.append("");
        }
        
        temp.setLength(TITLE_LENGTH);
        this.title = temp.toString();
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        StringBuilder temp = new StringBuilder();
        
        if (author != null && author.length() > 1) {
            temp.append(author);
        }
        else {
            temp.append("");
        }
        
        temp.setLength(AUTHOR_LENGTH);
        this.author = temp.toString();
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        if (yearPublished > 0) {
            this.yearPublished = yearPublished;
        }
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        if (pageCount > 0) {
            this.pageCount = pageCount;
        }
    }
    public double getDewey() {
        return dewey;
    }
    public void setDewey(double dewey) {
        if (dewey >= 0 && dewey < 1000) {
            this.dewey = dewey;
        }
    }
    public char getCondition() {
        return condition;
    }
    public void setCondition(char condition) {
        this.condition = condition;
    }
    public boolean isHardcover() {
        return hardcover;
    }
    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }
    public long getDbid() {
        return dbid;
    }
    protected void setDbid(long dbid) {
        if (dbid > 0) {
            this.dbid = dbid;
        }
    }
    
    //PRINTS EACH INSTANCE VARIABLE(EXCEPT THE DBID) IN A USER FRIENDLY MANNER
    @Override 
    public String toString() {
        return "Title: " + this.title + "\n" +
               "By " + this.author + "\n" + 
               "Published in " + this.yearPublished + "\n" +
               "Pages: " + this.pageCount + "\n" +
               "Dewey Decimal Number: " + this.dewey + "\n" + 
               "Condition: " + this.condition + "\n" + 
               "Hardcover: " + this.hardcover + "\n" +
               "DBID: " + this.dbid;
    }

    //DEAFAULT .EQUALS WASN'T WORKING SO I HAD TO MAKE ONE MYSELF
    public boolean equals(BookRecord value) {
        if (this.title.equals(value.title)) {
            if (this.author.equals(value.author)) {
                if (this.yearPublished == value.yearPublished) {
                    if (this.pageCount == value.pageCount) {
                        if (this.dewey == value.dewey) {
                            if (this.condition == value.condition) {
                                if (this.hardcover == value.hardcover) {
                                    if (this.dbid == value.dbid) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    //MOSTLY A HELPER METHOD, CHECKS THE VALIDITY OF A DATA IN THE RECORD SO THAT
    //INVALID OBJECTS WILL NEVER BE PASSED TO THE DATABASE TO BE SAVED
    public boolean validity() {
        try {
            assert this.title != null;
            assert this.author != null;
            assert this.yearPublished > 0;
            assert this.pageCount > 0;
            assert this.dewey >= 0 && this.dewey < 1000;
            assert this.condition == 'n' || this.condition == 'g' || this.condition == 'p';
            return true;
        } catch (AssertionError ae) {
            System.out.println("Invalid data, print record to show");
            return false;
        } catch (Exception e) {
            System.out.println("Other Exception");
            return false;
        }
    }
}