/*
 * Author: Jamie
 * Dation: v1.0
 * Description:e: October 26, 2020
 * Version: v1.0
 * Description: A class for storing browser history. It uses the URLStack class.
 */
package edu.hdsb.gwss.jamie.ics4u.u5;
import java.net.URL;
/**
 *
 * @author 4U-Jamie
 */
public class BrowserHistory implements BrowserHistoryInterface{
    private URLStack forwardHistory;
    private URLStack backHistory; 
    private URL currentURL;
    
    //CONSTUCTORS
    //THE DEFAULT SIZE IS 11
    public BrowserHistory() {
        this(11);
    }
    public BrowserHistory(int size) {
        forwardHistory = new URLStack(size);
        backHistory = new URLStack(size);
        currentURL = null;
    }

    //GETTERS
    public URLStack getForward() {
        return forwardHistory;
    }
    public URLStack getBack() {
        return backHistory;
    }
    public URL getCurrentURL() {
        return currentURL;
    }
    public int getCapacity() {
        return backHistory.capacity();
    }
    public int getForwardSize() {
        return forwardHistory.size();
    }
    public int getBackSize() {
        return backHistory.size();
    }
    public boolean isForwardFull(){
        return forwardHistory.isFull();
    }
    public boolean isBackFull(){
        return backHistory.isFull();
    }
    
    //SETTERS
    private void setForward(URLStack forward) {
        this.forwardHistory = forward;
    }
    private void setBack(URLStack back) {
        this.backHistory = back;
    }
    private void setCurrentURL(URL currentURL) {
        this.currentURL = currentURL;
    }
    
    //THE PASSED URL BECOMES THE NEW CURRENT URL AND THE OLD CURRENT URL GETS
    //MOVED TO THE TOP OF THE BACK HISTORY
    @Override
    public void visit(URL website){
        if (website != null){
            if (currentURL != null) {
                backHistory.push(currentURL);
            }
            this.setCurrentURL(website);
        }
    }
    
    //THE CURRENT URL IS PUSHED TO THE TOP OF THE BACK HISTORY AND THE TOP OF THE
    //FORWARD HISTORY BECOMES THE NEW CURRENT URL
    @Override
    public URL forward(){
        if (forwardHistory.peek() != null) {
            backHistory.push(currentURL);
            currentURL = forwardHistory.peek();
            return forwardHistory.pop();
        }
        return null;
    }
    
    //THE CURRENT URL IS PUSHED TO THE TOP OF THE FORWARD HISTORY AND THE TOP OF THE
    //BACK HISTORY BECOMES THE NEW CURRENT URL
    @Override
    public URL back(){
        if (backHistory.peek() != null) {
            forwardHistory.push(currentURL);
            currentURL = backHistory.peek();
            return backHistory.pop();
        }
        return null;
    }
    
    //EMPTIES THE FORWARD HISTORY STACK
    public void clearForward(){
        forwardHistory.makeEmpty();
    }
    
    //EMPTIES THE BACK HISTORY STACK
    public void clearBack(){
        backHistory.makeEmpty();
    }
    
    //PRINTS THE ITEMS IN AN ORGANIZED MANNER THAT DISPLAYS THE CURRENT URL, BACK
    //HISTORY, AND FORWARD HISTORY ON THEIR OWN LINES
    @Override
    public String toString() {
        return "Back\n" + backHistory.toString() + "\nForward\n" + forwardHistory.toString() + "\nCurrent URL: " + currentURL.toString();
    }
}
