/*
 * Author: Jamie
 * Date: October 21, 2020
 * Version: v1.1
 * Description: Android Lock class. Features:
 * combination length: 3
 * maximum integer value: 9
 * configurable
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

import java.util.ArrayList;

public class AndroidLock extends Lock implements AndroidInterface {
    //CONSTRUCTORS
    public AndroidLock() {
        super();
        System.out.println("AL() Constructor");
    }
    public AndroidLock(int n1, int n2, int n3) {
        this();
        super.configure(n1, n2, n3, MAX_VALUE);
        System.out.println("MU() Constructor + Configuration");
    }

    //GETTERS
    public static int getCOMBO_LENGTH() {
        return COMBO_LENGTH;
    }
    public static int getMAX_VALUE() {
        return MAX_VALUE;
    }
    
    @Override
    public void unlock(int n1, int n2, int n3){
        ArrayList pl = new ArrayList();
        pl.add(n1);
        pl.add(n2);
        pl.add(n3);
        super.unlock(pl);
        System.out.println("Android Unlock()");
    }
    
    @Override
    public void configure(int n1, int n2, int n3){
        this.configure(n1, n2, n3, MAX_VALUE);
        System.out.println("Android Configure()");
    }
    
    @Override
    public String toString(){
        return "This lock is an Android Lock. It's serial number is " + getSerialNumber();
    }
    
}
