/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 4U-Jamie
 */
public class BookWriterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BookRecord b1 = new BookRecord("The Great Gatsby", "Scott Fitzgerald", 1925, 218, 813.52, 'n', false);
        BookRecord b2 = new BookRecord("Of Mice and Men", "John Steinbeck", 1937, 107, 813.52, 'g', false);
        BookRecord b3 = new BookRecord("A Brief History of Time", "Stephen Hawking", 1988, 256, 523.1, 'p', false);
        BookRecord b4 = new BookRecord("In the Shadow of Man", "Jane Goodall", 1971, 297, 599.884, 'n', true);
        
        RandomAccessFile raf = new RandomAccessFile("testRecord.dat", "rw");
        
        raf.seek(0);
        
        writeRAF(b1, raf);
        writeRAF(b2, raf);
        writeRAF(b3, raf);
        writeRAF(b4, raf);
    }
    
    public static void writeRAF(BookRecord b, RandomAccessFile raf) throws IOException {
        raf.writeChars(b.getTitle());
        raf.writeChars(b.getAuthor());
        raf.writeInt(b.getYearPublished());
        raf.writeInt(b.getPageCount());
        raf.writeDouble(b.getDewey());
        raf.writeChar(b.getCondition());
        raf.writeBoolean(b.isHardcover());
        System.out.println("Length: " + raf.length());
    }
    
}
