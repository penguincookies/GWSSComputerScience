/*
 * Author: Jamie
 * Date: October 29, 2020
 * Version: v1.1
 * Description: A linked list class for storing URL nodes. It is static.
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

/**
 *
 * @author revit
 */
public class URLLinkedList implements URLLinkedListInterface{
    
    //INSTANCE VARIABLES
    private Node head;
    private Node tail;
    
    //CONSTRUCTOR
    //THE LINKED LIST STARTS EMPTY
    public URLLinkedList(){
        //TIRED CALLING MAKEEMPTY() HERE INSTEAD, NETBEANS GAVE ME WARNINGS
        this.head = null;
        this.tail = null;
    }

    //GETTERS(NODE)
    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
    
    //GETTERS(URL)
    @Override
    public URL getFirst(){
        if (!this.isEmpty()) {
            return head.getValue();
        }
        return null;
    }
    @Override
    public URL getLast(){
        if (!this.isEmpty()) {
            return tail.getValue();
        }
        return null;
    }

    //SETTERS
    private void setHead(Node head) {
        this.head = head;
    }
    private void setTail(Node tail) {
        this.tail = tail;
    }
    
    //ADDS A NODE TO THE FRONT OF THE LIST
    @Override
    public void addFirst(URL value){
        if (value != null) {
            Node pl = new Node (value);
            if (!this.isEmpty()){
                pl.setNext(head);
                this.head.setPrevious(pl);
                this.head = pl;
            }
            //IF THE LIST WAS PREVIOUSLY EMPTY, THE NODE IS THE HEAD AND TAIL
            else {
                this.head = pl;
                this.tail = pl;
            }
        }
    }
    
    //ADDS A NODE TO THE END OF THE LIST
    @Override
    public void addLast(URL value){
        if (value != null) {
            Node pl = new Node (value);
            if (!this.isEmpty()) {
                pl.setPrevious(this.tail);
                this.tail.setNext(pl);
                this.tail = pl;
            }
            //IF THE LIST WAS PREVIOUSLY EMPTY, THE NODE IS THE HEAD AND TAIL
            else {
                this.head = pl;
                this.tail = pl;
            }
        }
    }
    
    //REMOVES THE HEAD OF THE LIST AND RETURNS IT
    @Override
    public URL removeFirst(){
        if (!this.isEmpty()) {
            Node pl = head;
            if (head != tail) {
                head = head.getNext();
                head.getPrevious().setNext(null);
                head.setPrevious(null);
            }
            //IF THIS WAS THE ONLY NODE IN THE LIST, THE LIST BECOMES EMPTY
            else if (head == tail) {
                this.makeEmpty();
            }
            return pl.getValue();
        }
        return null;
    }
    
    //REMOVES THE HEAD OF THE LIST AND RETURNS IT
    @Override
    public URL removeLast(){
        if (!this.isEmpty()) {
            Node pl = tail;
            if (head != tail) {
                tail = tail.getPrevious();
                tail.getNext().setPrevious(null);
                tail.setNext(null);
            }
            //IF THIS WAS THE ONLY NODE IN THE LIST, THE LIST BECOMES EMPTY
            else if (head == tail) {
                this.makeEmpty();
            }
            return pl.getValue();
        }
        return null;
    }
    
    //RETURNS THE CURRENT SIZE OF THE LIST
    //IS RECURSIVE, RECURSES AS LONG AS THERE IS A POINTER TO THE NEXT NODE
    @Override
    public int size(){
        int count = 0;
        if (!this.isEmpty()) {
            return this.size(head, count);
        }
        return count;
    }
    private int size(Node value, int counter){
        if (value == this.tail) {
            return counter + 1;
        }
        return this.size(value.getNext(), counter+1);
    }
    
    //CHECKS IF THE LIST IS EMPTY
    @Override
    public boolean isEmpty(){
        //IT IS MORE EFFICIENT TO CHECK JUST HEAD OR TAIL SINCE IF ONE IS NULL 
        //THE OTHER SHOULD BE AS WELL BUT YOU CAN NEVER BE TOO SAFE
        return (this.head==null && this.tail==null);
    }
    
    //"EMPTIES" THE LIST BY RESETTING THE HEAD AND TAIL TO NULL
    @Override
    public void makeEmpty(){
        this.head = null;
        this.tail = null;
    }
    
    //REMOVES THE FIRST INSTANCE OF THE ITEM IN THE LIST(IF IT EXISTS) AND THEN
    //RETURNS TRUE OR FALSE DEPENDING ON IF AN ITEM WAS DELETED OR NOT
    //IS RECURSIVE, RECURSES AS LONG AS THERE IS A POINTER TO THE NEXT NODE 
    @Override
    public boolean remove(URL value){
        if (value != null) {
            if (!this.isEmpty()) {
                if (value != head.getValue()) {
                    return this.remove(value, head.getNext());
                }
                //SPECIAL CASE FOR REMOVING HEAD SINCE YOU CAN'T REASSIGN A 
                //PREVIOUS POINTER IF IT IS NULL
                else {
                    this.removeFirst();
                    return true;
                }
            }
        }
        return false;
    }
    private boolean remove(URL value, Node node){
        if (value == node.getValue()) {
            //SPECIAL CASE FOR REMOVING TAIL SINCE YOU CAN'T REASSIGN A 
            //PREVIOUS POINTER IF IT IS NULL
            if (node.getNext() == null) {
                this.removeLast();
                return true;
            }
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            //DELETES THE DANGLING POINT
            node.setNext(null);
            node.setPrevious(null);
            return true;
        }
        if (node.getNext() != null) {
            //AS LONG AS THE NEXT POINTER ISN'T NULL, IT RECURSES
            return this.remove(value, node.getNext());
        }
        //IF AT THE TAIL AND NOTHING HAS BEEN DELETED, RETURNS FALSE
        return false;
    }
    
    //PRINTS THE LIST IN A STRING, SIMILAR TO AN ARRAYLIST TOSTRING
    //IS RECURSIVE, RECURSES AS LONG AS THERE IS A POINTER TO THE NEXT NODE 
    @Override
    public String toString(){
        if (this.isEmpty()) {
            return "[]";
        }
        return "[" + toString(this.head);
    }
    private String toString(Node value){
        //BASE CASE
        if (this.tail == value) {
            return value.toString() + "]";
        }
        return value.toString() + ", " + this.toString(value.getNext());
    }
}
