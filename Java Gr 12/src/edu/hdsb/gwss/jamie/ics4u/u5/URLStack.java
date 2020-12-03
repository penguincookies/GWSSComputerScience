/*
 * Author: Jamie
 * Date: October 26, 2020
 * Version: v1.0
 * Description: A Stack class made for storing URLs. In this class when an item
 * is deleted, only the pointer is deleted and not the actual data similar to 
 * disk wiping
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

public class URLStack implements URLStackInterface{
    //INSTANCE VARIABLES
    private URL[] stack;
    private int top;
    
    //CONSTRUCTORS
    //THE DEFAULT SIZE IS 11
    public URLStack() {
        this(11);
    }
    public URLStack(int size) {
        if (size > 0) {
            this.stack = new URL[size];
            this.top = -1;
        }
        else {
            this.stack = new URL[size];
            this.top = -1;
        }
    }

    //GETTER
    private int getTop() {
        return this.top;
    }

    //SETTER
    private void setTop(int top) {
        this.top = top;
    }
    
    //LOOKS AT THE TOP ITEM AND RETURNS IT
    @Override
    public URL peek() {
        if (!isEmpty()) {
            return stack[this.top];
        } 
        return null;
    }
    
    //RETURNS THE TOP ITEM AND THEN "DELETES" IT
    @Override
    public URL pop() {
        if (!isEmpty()) {
            this.top = this.top-1;
            return stack[this.top+1];
        } 
        return null;
    }
    
    //PUTS THE PASSED VALUE ONTO THE TOP OF THE STACK
    @Override 
    public void push( URL value ){
        if(!isFull()){
            this.top++;
            this.stack[top] = value;
        }
    }
    
    //RETURNS HOW MANY ITEMS ARE CURRENTLY IN THE STACK
    @Override
    public int size(){
        return this.top + 1;
    }
    
    //RETURNS THE MAXIMUM NUMBER OF ITEMS THE STACK CAN HOLD
    @Override
    public int capacity(){
        return this.stack.length;
    }
    
    //IS THE STACK EMPTY?
    @Override
    public boolean isEmpty(){
        return this.top == -1;
    }
    
    //IS THE STACK FULL?
    @Override 
    public boolean isFull(){
        return this.top+1 == this.stack.length;
    }
    
    //"WIPES" THE STACK
    @Override 
    public void makeEmpty(){
        this.top = -1;
    }
    
    //RETURNS A STRING REPRESENTING THE STACK(FORMATTED LIKE ARRAYLIST TOSTRING())
    @Override
    public String toString(){
        String pl = "[";
        for (int i = 0; i < this.size(); i++) {
            if (i != this.size()-1) {
                pl = pl + this.stack[i] + ", ";
            }
            else {
                pl = pl + this.stack[i];
            }
        }
        pl = pl + "]";
        return pl;
    }
}
