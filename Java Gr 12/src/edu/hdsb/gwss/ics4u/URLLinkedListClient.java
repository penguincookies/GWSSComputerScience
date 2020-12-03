/*
 * Author: Jamie
 * Date: October 29, 2020
 * Version: v1.1
 * Description: A client to test and demonstrate URLLinkedList.java
 */
package edu.hdsb.gwss.ics4u;

import edu.hdsb.gwss.jamie.ics4u.u5.URLLinkedList;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author revit
 */
public class URLLinkedListClient {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException{
        URL geek = new URL("https://www.geeksforgeeks.org");
        URL dilbert = new URL("https://dilbert.com/");
        URL tube = new URL("https://www.youtube.com/");
        URL book = new URL("https://www.facebook.com/");
        
        System.out.println("Check initialized variables");
        System.out.println("---------------------------");
        URLLinkedList LL = new URLLinkedList();
        assert LL.size() == 0;
        assert LL.isEmpty() == true;
        assert LL.getFirst() == null;
        assert LL.getLast() == null;
        assert LL.removeFirst() == null;
        assert LL.removeLast() == null;
        assert LL.toString() == "[]";
        System.out.println("Add something to the front of the list");
        System.out.println("--------------------------------------");
        LL.addFirst(dilbert);
        assert LL.size() == 1;
        assert LL.isEmpty() == false;
        assert LL.getFirst() == dilbert;
        assert LL.getLast() == dilbert;
        System.out.println("Add something to the front again");
        System.out.println("--------------------------------");
        LL.addFirst(tube);
        assert LL.size() == 2;
        assert LL.getFirst() == tube;
        assert LL.getLast() == dilbert;
        System.out.println("Add something to the end of the list");
        System.out.println("------------------------------------");
        LL.addLast(geek);
        assert LL.size() == 3;
        assert LL.getFirst() == tube;
        assert LL.getLast() == geek;
        assert LL.getHead().getNext().getValue() == dilbert;
        System.out.println("Add duplicate items to the list");
        System.out.println("-------------------------------");
        LL.addLast(tube);
        LL.addLast(geek);
        assert LL.size() == 5;
        System.out.println("remove() removes the first instance of an item");
        System.out.println("----------------------------------------------");
        assert LL.remove(geek) == true;
        assert LL.size() == 4;
        assert LL.getLast() == geek;
        System.out.println("Trying to remove a value that doesn't exist");
        System.out.println("-------------------------------------------");
        assert LL.remove(null) == false;
        assert LL.remove(book) == false;
        assert LL.size() == 4;
        assert LL.getFirst() == tube;
        assert LL.getLast() == geek;
        System.out.println("Trying to add a null value to the front and back");
        System.out.println("------------------------------------------------");
        LL.addFirst(null);
        LL.addLast(null);
        assert LL.size() == 4;
        assert LL.getFirst() == tube;
        assert LL.getLast() == geek;
        System.out.println("Removing the front of the list");
        System.out.println("------------------------------");
        assert LL.removeFirst() == tube;
        assert LL.getFirst() == dilbert;
        assert LL.size() == 3;
        System.out.println("Removing the back of the list");
        System.out.println("-----------------------------");
        assert LL.removeLast() == geek;
        assert LL.getLast() == tube;
        assert LL.size() == 2;
        System.out.println("Remove everything and check if the list is empty");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < 2; i++) {
            assert LL.removeFirst() != null;
        }
        assert LL.size() == 0;
        assert LL.isEmpty() == true;
        assert LL.getFirst() == null;
        assert LL.getLast() == null;
        assert LL.removeFirst() == null;
        assert LL.removeLast() == null;
        System.out.println("Check if makeEmpty() actually clears the list");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 100; i++) {
            LL.addFirst(dilbert);
        }
        assert LL.size() == 100;
        LL.makeEmpty();
        assert LL.size() == 0;
        assert LL.isEmpty() == true;
        assert LL.getFirst() == null;
        assert LL.getLast() == null;
        assert LL.removeFirst() == null;
        assert LL.removeLast() == null;
    }
    
}
