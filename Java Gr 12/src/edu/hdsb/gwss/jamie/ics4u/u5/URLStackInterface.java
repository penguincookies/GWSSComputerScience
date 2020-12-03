/**
 * URL Stack Interface.
 *
 * @author Wm.Muir
 * @version 2020-21.Q1
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

public interface URLStackInterface {

    /**
     * Looks at the URL Object at the top of this stack without removing it.
     *
     * @return the URL at the top of this stack, or NULL if empty.
     */
    public URL peek();

    /**
     * Pops (remove) the URL Object at the top of this stack and returns the URL
     * object as the value of this function.
     *
     * @return the URL Object at the top of this stack, or NULL if empty.
     */
    public URL pop();

    /**
     * Pushes (adds) the URL Object onto the top of this stack.
     * @param value the URL to be put on the stack.
     */
    public void push( URL value );

    /**
     * Returns the number of URL Objects in the stack.
     *
     * @return the number of URL Objects in the stack, or ZERO if empty.
     */
    public int size();

    /**
     * Returns the current capacity of the Stack.
     *
     * @return the capacity of the stack; a fixed size.
     */
    public int capacity();

    /**
     * Tests if this stack is empty.
     *
     * @return true if there are no URL Objects, false if there is at least one.
     */
    public boolean isEmpty();

    /**
     * Tests if the Stack is full.
     *
     * @return true if the stack is full, false otherwise.
     */
    public boolean isFull();

    /**
     * The Stack will be empty after this method call.
     */
    public void makeEmpty();

}
