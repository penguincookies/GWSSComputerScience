/*
 * Author: Jamie
 * Date: October 21, 2020
 * Version: v1.1
 * Description: Dudley Lock class. Features:
 * combination length: 3
 * maximum integer value: 59
 * non-configurable
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

import java.util.ArrayList;

public class DudleyLock extends Lock implements DudleyInterface{
    //CONSTRUCTOR
    public DudleyLock() {
        super(MAX_VALUE, COMBO_LENGTH);
        System.out.println("DL() Constructor");
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
        System.out.println("Dudley Unlock()");
    }
    
    @Override
    public String toString(){
        return "This lock is a Dudley Lock. It's serial number is " + getSerialNumber();
    }
}
