/*
 * Author: Jamie
 * Date: October 27, 2020
 * Version: v1.0
 * Description: A client to test and demonstrate URLQueue.java
 */
package edu.hdsb.gwss.ics4u;

import edu.hdsb.gwss.jamie.ics4u.u5.URLQueue;
import java.net.MalformedURLException;
import java.net.URL;

public class URLQueueClient {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        URL geek = new URL("https://www.geeksforgeeks.org/assertions-in-java/");
        URL dilbert = new URL("https://dilbert.com/");
        URL tube = new URL("https://www.youtube.com/");
        URLQueue q = new URLQueue(6);
        URLQueue q2 = new URLQueue();
        System.out.println("Check initialized variables");
        System.out.println("---------------------------");
        assert q.capacity() == 6;
        assert q.size() == 0;
        assert q.getBack() == -1;
        assert q.getFront() == -1;
        assert q.isEmpty() == true;
        assert q2.capacity() == 11;
        System.out.println("Enqueues, then enqueues again");
        System.out.println("-----------------------------");
        q.enqueue(tube);
        assert q.getFront() == 0;
        assert q.getBack() == 0;
        q.enqueue(dilbert);
        assert q.getFront() == 0;
        assert q.getBack() == 1;
        System.out.println("Fills the queue");
        System.out.println("---------------");
        q.enqueue(dilbert);
        q.enqueue(tube);
        q.enqueue(geek);
        q.enqueue(dilbert);
        assert q.isFull();
        System.out.println("Enques into a full queue(only for it to fail");
        System.out.println("--------------------------------------------");
        q.enqueue(geek);
        assert q.isFull();
        assert q.peek() == tube;
        assert q.peekBack() == dilbert;
        System.out.println("Wrap the back of the queue");
        System.out.println("--------------------------");
        q.dequeue();
        q.enqueue(geek);
        assert q.getFront() == 1;
        assert q.getBack() == 0;
        assert q.isFull() == true;
        System.out.println("More wrapping around");
        System.out.println("--------------------");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(dilbert);
        assert q.getFront() == 4;
        assert q.getBack() == 1;
        assert q.size() == 4;
        assert q.peek() == geek;
        assert q.peekBack() == dilbert;
        System.out.println("Passes a null URL");
        System.out.println("-----------------");
        q.enqueue(null);
        assert q.getFront() == 4;
        assert q.getBack() == 1;
        assert q.size() == 4;
        System.out.println("Dequeue all items and checks if empty");
        System.out.println("-------------------------------------");
        for (int i = 0; i < 4; i++) {
            q.dequeue();
        }
        assert q.dequeue() == null;
        assert q.isEmpty() == true;
        assert q.toString().equals("Empty");
    }
    
}
