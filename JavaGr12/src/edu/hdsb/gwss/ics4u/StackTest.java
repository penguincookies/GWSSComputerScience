/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u;

import java.net.URL;
import edu.hdsb.gwss.jamie.ics4u.u5.URLStack;
import java.net.MalformedURLException;

public class StackTest {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        //URL url = new URL("https://www.geeksforgeeks.org/assertions-in-java/");
        //URL dilbert = new URL( "https://dilbert.com/" );
        URLStack u = new URLStack(5);
        System.out.println("Is it empty? " + u.isEmpty());
        System.out.println(u.pop());
        u.push(new URL("https://www.geeksforgeeks.org/assertions-in-java/"));
        u.push(new URL ("https://dilbert.com/"));
        System.out.println("Size: " + u.size());
        System.out.println("Capacity: " + u.capacity());
        System.out.println("Is it full? " + u.isFull());
        System.out.println("Is it empty? " + u.isEmpty());
        System.out.println("Peek: " + u.peek());
        System.out.println("Pop: " + u.pop());
        System.out.println("Peek: " + u.peek());
        System.out.println("Size: " + u.size());
        u.pop();
        System.out.println("Is it empty? " + u.isEmpty());
        u.push(new URL("https://www.geeksforgeeks.org/assertions-in-java/"));
        u.push(new URL ("https://dilbert.com/"));
        u.push(new URL("https://www.geeksforgeeks.org/assertions-in-java/"));
        u.push(new URL ("https://dilbert.com/"));
        u.push(new URL ("https://dilbert.com/"));
        System.out.println("Is it full? " + u.isFull());
        System.out.println(u.toString());
    }
    
}
