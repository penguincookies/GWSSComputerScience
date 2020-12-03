/*
 * Author: Jamie
 * Dation: v1.0
 * Description:e: October 26, 2020
 * Version: v1.0
 * Description: A client to test and demonstrate BrowserHistory.java
 */
package edu.hdsb.gwss.ics4u;

import java.net.URL;
import edu.hdsb.gwss.jamie.ics4u.u5.BrowserHistory;
import java.net.MalformedURLException;

/**
 *
 * @author revit
 */
public class BrowserHistoryClient {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        URL geek = new URL("https://www.geeksforgeeks.org/assertions-in-java/");
        URL dilbert = new URL("https://dilbert.com/");
        URL tube = new URL("https://www.youtube.com/");
        
        System.out.println("Using both constructors");
        System.out.println("-----------------------");
        BrowserHistory bh1 = new BrowserHistory();
        BrowserHistory bh2 = new BrowserHistory(5);
        assert bh1.getCapacity() == 11;
        assert bh2.getCapacity() == 5;
        System.out.println("Fills the back");
        System.out.println("-----------------");
        for (int i = 0; i <= bh1.getCapacity(); i++) {
            bh1.visit(tube);
            assert bh1.getBackSize() == i;
        }
        assert bh1.getBackSize() == bh1.getCapacity();
        System.out.println("Go forward until back is empty");
        System.out.println("------------------------------");
        for (int i = bh1.getCapacity()-1; i >= 0; i--) {
            bh1.back();
            assert bh1.getBackSize() == i;
            assert bh1.getForwardSize() == bh1.getCapacity()-i;
        }
        assert bh1.getForwardSize() == bh1.getCapacity();
        assert bh1.getBackSize() == 0;
        System.out.println("Fills the back so both stacks are full");
        System.out.println("--------------------------------------");
        for (int i = 1; i <= bh1.getCapacity(); i++) {
            bh1.visit(tube);
            assert bh1.getBackSize() == i;
        }
        assert bh1.isBackFull();
        assert bh1.isForwardFull();
        System.out.println("Empties both histories");
        System.out.println("----------------------");
        bh1.clearForward();
        bh1.clearBack();
        assert bh1.getBackSize() == 0;
        assert bh1.getForwardSize() == 0;
        assert bh1.getCurrentURL() == tube;
        System.out.println("Moving back and forth");
        System.out.println("---------------------");
        bh1.visit(dilbert);
        bh1.visit(tube);
        bh1.visit(geek);
        bh1.back();
        assert bh1.getCurrentURL() == tube;
        assert bh1.getBackSize() == 2;
        assert bh1.getForwardSize() == 1;
        bh1.back();
        assert bh1.getCurrentURL() == dilbert;
        assert bh1.getBackSize() == 1;
        assert bh1.getForwardSize() == 2;
        bh1.forward();
        assert bh1.getCurrentURL() == tube;
        assert bh1.getBackSize() == 2;
        assert bh1.getForwardSize() == 1;
        System.out.println("Testing null URLs");
        System.out.println("-----------------");
        bh1.visit(null);
        System.out.println("Trying to go forward/back onto an empty history");
        System.out.println("-----------------------------------------------");
        bh1.clearForward();
        bh1.clearBack();
        assert bh1.forward() == null;
        assert bh1.back() == null;
        assert bh1.getCurrentURL() == tube;
    }
    
}
