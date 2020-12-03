/*
 * Author: Jamie
 * Date: October 29, 2020
 * Version: v1.0
 * Description: A Node wrapper class for URLs. Used in URLLinkedList.java.
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

/**
 *
 * @author revit
 */
public class Node implements NodeInterface{
    
    //INSTANCE VARIABLES
    private URL node;
    private Node previous;
    private Node next;
    
    //CONSTRUCTORS
    public Node(){
        this(null);
    }
    public Node (URL value){
        this.node = value;
        previous = null;
        next = null;
    }

    //GETTERS
    @Override
    public Node getPrevious() {
        return this.previous;
    }
    @Override
    public Node getNext() {
        return this.next;
    }
    @Override
    public URL getValue(){
        return this.node;
    }
    
    //SETTERS
    @Override
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    @Override
    public void setNext(Node next) {
        this.next = next;
    }
    public void setValue(URL value) {
        this.node = value;
    }
    
    @Override
    public String toString(){
        return this.node.toString();
    }
}
