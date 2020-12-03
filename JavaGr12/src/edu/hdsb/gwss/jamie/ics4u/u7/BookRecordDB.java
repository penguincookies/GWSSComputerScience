/*
 * Author: Jamie
 * Date: November 4, 2020
 * Version: v1.1
 * Description: A database for storing instances of BookRecord.java
 * ADD GETNUMBEROFRECORDS() METHOD
 */
package edu.hdsb.gwss.jamie.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BookRecordDB {
    
    //CLASS OBJECT
    private static RandomAccessFile raf;
    //CLASS VARIABLE
    //BY SETTING OPEN TO BE FALSE BY DEFAULT, A NUL FILE WILL AWAYS BE CLOSED
    //SO I CAN USE if(open) TO CHECK FOR NULL FILES INSTEAD OF CATCHING 
    //NULLPOINTEREXCEPTIONS
    private static boolean open = false;
    
    //GETTERS
    public static boolean isOpen() {
        return open;
    }
    public static long getLength() throws IOException {
        try {
            return raf.length();
        } catch (IOException ioe) {
            System.out.println("File can't be found or isn't open");
            return -1;
        }
    }
    public static long getNumberOfRecords() throws IOException {
        try {
            return raf.length()/BookRecord.RECORD_LENGTH;
        } catch (IOException ioe) {
            System.out.println("File can't be found or isn't open");
            return -1;
        }
    }
    
    //OPENS THE FILE
    //IT WILL ALWAYS BE READ-WRITE BUT I STILL TRY TO CATCH FOR IOEXCEPTIONS
    //IN THE OTHER METHODS IN CASE THERE IS A HARDWARE ERROR OR SOMETHING
    public static void Open() {
        //ONLY INSTANTIATES THE FILE IF IT'S NOT OPEN ALREADY
        try {
            if (!open) {
                raf = new RandomAccessFile("book_info.dat", "rw");
                open = true;
            }
            else {
                System.out.println("Already Open");
            }
        //TECHNICALLY THIS ERROR SHOULD NEVER HAPPEN
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
            System.out.println("Invalid file path set for file");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
        }
    }
    
    //CLOSES THE FILE
    public static void Close() {
        //ONLY CLOSES THE FILE IF IT WAS PREVIOUSLY OPEN
        try {
            if (open) {
                raf.close();
                open = false;
            }
            else {
                System.out.println("Already Closed");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't close the file");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
        }
    }
    
    //"WIPES" THE FILE BY CHANGING THE LENGTH TO 0 AND IGNORING ALL EXISTING 
    //DATA IN IT
    public static void Wipe() {
        try {
            if (open) {
                raf.setLength(0);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't wipe, file is probably set to read-only");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
        }
    }
    
    //TAKES NEW DATA AND ADDS OR SAVES IT TO THE LIST
    public static BookRecord Save(BookRecord b) {
        try {
            if (open) {
                //CHECKS IF THE FILE CONTAINS ALL VALID DATA
                if (b.validity()) {
                    //UPDATES AN EXISTING DATABASE ID
                    if (b.getDbid() == -1) {
                        raf.seek(raf.length());
                        writeRAF(b);
                        b.setDbid(raf.length()/BookRecord.RECORD_LENGTH);
                        return b;
                    }
                    //ADDS THE NEW ITEM TO THE END OF THE DATABASE AND ASSIGNS 
                    //IT A NEW DATABASE ID
                    raf.seek((b.getDbid()-1)*BookRecord.RECORD_LENGTH);
                    writeRAF(b);
                    return b;
                }
                System.out.println("Invalid data");
                return null;
            }
            System.out.println("File isn't open!");
            return null;
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't save, file is probably set to read-only");
            return null;
        } catch (NullPointerException npe) {
            System.out.println(npe);
            System.out.println("Can't save, file isn't found; make sure to open it");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
            return null;
        }
    }
    
    //RETRIEVES A BOOKRECORD BASED ON THE PASSED DATABASE ID
    public static BookRecord get(long dbid) {
        try {
            if (open) {
                //CHECKS IF THE PASSED DATABASE ID IS VALID
                if (raf.length()/BookRecord.RECORD_LENGTH < dbid) {
                    return null;
                }
                if (0 >= dbid) {
                    return null;
                }
                //IF THE ID IS VALID, SEEKS THE ID'S LOCATION AND READS
                raf.seek((dbid-1)*BookRecord.RECORD_LENGTH);
                return readRAF(dbid);
            }
            System.out.println("File isn't open!");
            return null;
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't save, file is probably set to write-only");
            return null;
        } catch (NullPointerException npe) {
            System.out.println(npe);
            System.out.println("Can't save, file isn't found; make sure to open it");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
            return null;
        }
    }
    
    //RETRIEVES A BOOKRECORD BASED ON SOME PASSED SECONDARY KEYS(A QUERY)
    public static BookRecord get(String title, String author, int yearPublished) {
        try {
            if (open) {
                //FOR EACH RECORD IN THE DATABASE, CHECKS TO SEE IF THEIR SECONDARY
                //KEYS MATCH THE ONES PASSED
                for (int i = 0; i < (raf.length()/BookRecord.RECORD_LENGTH); i++) {
                    raf.seek(i*BookRecord.RECORD_LENGTH);
                    if (readString(BookRecord.TITLE_LENGTH).trim().equals(title)) {
                        if (readString(BookRecord.AUTHOR_LENGTH).trim().equals(author)) {
                            if (raf.readInt() == yearPublished) {
                                raf.seek(i*BookRecord.RECORD_LENGTH);
                                return readRAF(i+1);
                            }
                        }
                    }
                }
                return null;
            }
            else {
                System.out.println("File isn't open!");
                return null;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't retrieve, file is probably write-only");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
            return null;
        }
    }
    
    //HELPER METHOD, WRITES A RECORD TO DATABASE
    //ONLY CALLED UPON AFTER THE VALIDITY OF THE PASSED DATA IS VERIFIED
    private static void writeRAF(BookRecord b) {
        try {
            raf.writeChars(b.getTitle());
            raf.writeChars(b.getAuthor());
            raf.writeInt(b.getYearPublished());
            raf.writeInt(b.getPageCount());
            raf.writeDouble(b.getDewey());
            raf.writeChar(b.getCondition());
            raf.writeBoolean(b.isHardcover());
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't write, file is probably read-only");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
        }
    }
    
    //HELPER METHOD, READS A RECORD FROM THE DATABASE
    //ONLY CALLED UPON AFTER IT'S CONFIRMED THAT THE RECORD IT'S TRYING TO READ EXISTS
    private static BookRecord readRAF(long dbid) {
        try {
            BookRecord pl = new BookRecord();
            pl.setTitle(readString(BookRecord.TITLE_LENGTH));
            pl.setAuthor(readString(BookRecord.AUTHOR_LENGTH));
            pl.setYearPublished(raf.readInt());
            pl.setPageCount(raf.readInt());
            pl.setDewey(raf.readDouble());
            pl.setCondition(raf.readChar());
            pl.setHardcover(raf.readBoolean());
            pl.setDbid(dbid);
            return pl;
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't read, file is probably write-only");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
            return null;
        }
    }
    
    //HELPER METHOD, READS A STRING FROM THE DATABASE(BASED ON THE PASSED LENGTH)
    //ONLY CALLED UPON AFTER IT'S CONFIRMED THAT THE RECORD IT'S TRYING TO READ EXISTS
    private static String readString(int stringLength) {
        try {
            char[] word = new char[stringLength];
            for (int i = 0; i < stringLength; i++) {
                word[i] = raf.readChar();
            }
            return new String (word);
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("Can't read, file is probably write-only");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Some other exception has occurred");
            return null;
        }
    }
}
