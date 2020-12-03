/*
 * Author: Jamie
 * Date: October 27, 2020
 * Version: v1.1
 * Description: A queue class for storing URLs. It is static. In this class when 
 * an item is deleted, only the pointer is deleted and not the actual data similar 
 * to disk wiping
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

public class URLQueue implements URLQueueInterface {
    //INSTANCE VARIABLES
    private URL[] queue;
    private int front;
    private int back;
    
    //CONSTRUCTORS
    //THE DEFAULT SIZE IS 11
    public URLQueue(){
        this(11);
    }
    public URLQueue(int size){
        if (size > 0) {
            this.queue = new URL[size];
            this.front = -1;
            this.back = -1;
        }
        else {
            this.queue = new URL[11];
            this.front = -1;
            this.back = -1;
        }
    }

    //GETTERS
    public int getFront() {
        return this.front;
    }
    public int getBack() {
        return this.back;
    }
    
    //SETTERS
    public void setFront(int front) {
        this.front = front;
    }
    public void setBack(int back) {
        this.back = back;
    }
    
    //LOOKS AT THE FRONT OR THE BACK OF THE QUEUE AND RETRUNS THE URL VALUE
    //RETURNS NULL IF EMPTY
    @Override
    public URL peek(){
        if (isEmpty()) {
            return null;
        }
        return this.queue[this.front];
    }
    public URL peekBack(){
        if (isEmpty()) {
            return null;
        }
        return this.queue[this.back];
    }
    
    //PUTS THE PASSED URL AT THE BACK OF THE QUEUE IF THE URL ISN'T NULL AND THE
    //QUEUE ISN'T ALREADY FULL;
    @Override
    public void enqueue(URL value){
        if (value != null) {
            //EXCEPTION FOR WHEN THE QUEUE WAS PREVIOUSLY EMPTY
            if (isEmpty()) {
                this.front = 0;
                this.back = 0;
                queue[0] = value;
            }
            else if (!this.isFull()) {
                this.back = (this.back+1)%this.capacity();
                this.queue[back] = value;
            }
            //NOTHING HAPPENS IF THE QUEUE IS FULL
        }
    }
    
    //RETURNS THE URL AND THE FRONT, THEN REMOVES IT
    @Override
    public URL dequeue(){
        if (!this.isEmpty()) {
            int pl = front;
            //IF THE LAST URL WAS DEQUEUED, MAKES THE QUEUE EMPTY
            if (this.front == this.back){
                this.makeEmpty();
            }
            else{
                this.front = (front+1)%this.capacity();
            }
            return this.queue[pl];
        }
        //IF THE QUEUE IS EMPTY, DOES NOTHING
        return null;
    }
    
    //RETURNS THE SIZE OF THE QUEUE(HOW MANY URLS ARE CURRENTLY IN IT)
    @Override
    public int size(){
        if (this.isEmpty()){
            return 0;
        }
        if (this.front < this.back) {
            return this.back-this.front+1;
        }
        if (this.front > this.back) {
            return this.capacity()-(this.front-this.back)+1;
        }
        //THE BASE CASE IS IF THE FRONT AND BACK POIN TO THE SAME URL
        return 1;
    }
    
    //RETURNS THE MAXIMUM NUMBER OF URLS THE QUEUE CAN HOLD
    @Override
    public int capacity(){
        return this.queue.length;
    }
    
    //CHECKS IF THE QUEUE IS EMPTY
    @Override
    public boolean isEmpty(){
        return this.front == -1 && this.back == -1;
    }
    
    //CHECKS IF THE QUEUE IS FULL
    @Override
    public boolean isFull(){
        return this.size() == this.capacity();
    }
    
    //EMPTIES THE QUEUE
    @Override
    public void makeEmpty(){
        this.front = -1;
        this.back = -1;
    }
    
    //PRINTS THE QUEUE IN A STRING, SIMILAR TO AN ARRAYLIST TOSTRING
    //LABELS THE FRONT AND BACK
    //"DELETED" URLS WILL STILL APPEAR SO USE THE F AND B LABELS
    @Override
    public String toString(){
        if (!this.isEmpty()) {
            String pl = "[";
            for (int i = 0; i < this.capacity(); i++) {
                if (i == this.front) {
                    pl = pl + "F ";
                }
                if (i == this.back) {
                    pl = pl + "B ";
                }
                pl = pl + queue[i] + ", ";
            }
            pl = pl + "]";
            return pl;
        }
        return "Empty";
    }
}
