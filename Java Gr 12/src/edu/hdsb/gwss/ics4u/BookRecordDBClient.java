/*
 * Author: Jamie
 * Date: November 8, 2020
 * Version: v1.1
 * Description: A client to test and demonstrate BookRecordDB.java
 */
package edu.hdsb.gwss.ics4u;

import edu.hdsb.gwss.jamie.ics4u.u7.BookRecord;
import edu.hdsb.gwss.jamie.ics4u.u7.BookRecordDB;
import java.io.IOException;

public class BookRecordDBClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BookRecord b1 = new BookRecord("The Great Gatsby", "Scott Fitzgerald", 1925, 218, 813.52, 'n', false);
        BookRecord b2 = new BookRecord("Of Mice and Men", "John Steinbeck", 1937, 107, 813.52, 'g', false);
        BookRecord b3 = new BookRecord("A Brief History of Time", "Stephen Hawking", 1988, 256, 523.1, 'p', false);
        BookRecord b4 = new BookRecord("In the Shadow of Man", "Jane Goodall", 2000, 297, 599.884, 'n', true);
        
        System.out.println("Opening the file");
        System.out.println("----------------");
        BookRecordDB.Open();
        //THE CLIENT CAN HANDLE A FILE THAT'S ALREADY WRITTEN TO
        if (BookRecordDB.getLength() != 0) {
            System.out.println("Clearing any previous data from the file");
            System.out.println("----------------------------------------");
            BookRecordDB.Wipe();
        }
        assert BookRecordDB.getLength() == 0;
        assert BookRecordDB.getNumberOfRecords() == 0;
        System.out.println("Saving one record and reading it");
        System.out.println("----------------------------------------");
        BookRecordDB.Save(b1);
        assert BookRecordDB.getLength() == BookRecord.RECORD_LENGTH; 
        assert BookRecordDB.isOpen();
        assert BookRecordDB.get(1).equals(b1);
        assert BookRecordDB.getNumberOfRecords() == 1;
        System.out.println("Saving three more records and reading them");
        System.out.println("--------------------------------=---------------");
        BookRecordDB.Save(b2);
        BookRecordDB.Save(b3);
        BookRecordDB.Save(b4);
        assert BookRecordDB.getLength() == BookRecord.RECORD_LENGTH*4;
        assert BookRecordDB.get(1).equals(b1);
        assert BookRecordDB.get(2).equals(b2);
        assert BookRecordDB.get(3).equals(b3);
        assert BookRecordDB.get(4).equals(b4);
        assert BookRecordDB.getNumberOfRecords() == 4;
        System.out.println("Trying to get a non-existent dbid");
        System.out.println("---------------------------------");
        assert BookRecordDB.get(6) == null;
        System.out.println("Searching by secondary keys");
        System.out.println("---------------------------");
        assert BookRecordDB.get("The Great Gatsby", "Scott Fitzgerald", 1925).equals(b1);
        assert BookRecordDB.get("I Will Survive", "Me First and the Gimme Gimmes", 2014) == null;
        assert BookRecordDB.get("A Brief History of Time", "Stephen Hawkin", 1987) == null;
        System.out.println("Using save() to update");
        System.out.println("----------------------");
        b1.setAuthor("Michael Jackson");
        BookRecordDB.Save(b1);
        assert BookRecordDB.getLength() == BookRecord.RECORD_LENGTH*4;
        assert BookRecordDB.get(1).getAuthor().equals(b1.getAuthor());
        b3.setYearPublished(2040);
        BookRecordDB.Save(b3);
        assert BookRecordDB.getLength() == BookRecord.RECORD_LENGTH*4;
        assert BookRecordDB.get(3).getYearPublished() == 2040;
        System.out.println("Using the DBID constructor for BookRecord");
        System.out.println("-----------------------------------------");
        BookRecord b5 = new BookRecord(2);
        b5 = BookRecordDB.get(b5.getDbid());
        assert b5.equals(b2);
        System.out.println("Closing the DB and making sure nothing else can happen");
        System.out.println("------------------------------------------------------");
        BookRecordDB.Close();
        assert BookRecordDB.get(2) == null;
        assert BookRecordDB.Save(b4) == null;
        assert BookRecordDB.isOpen() == false;
        System.out.println("Opening the DB and wiping it");
        System.out.println("----------------------------");
        BookRecordDB.Open();
        BookRecordDB.Wipe();
        assert BookRecordDB.getLength() == 0;
        BookRecordDB.Close();
    }
    
}
