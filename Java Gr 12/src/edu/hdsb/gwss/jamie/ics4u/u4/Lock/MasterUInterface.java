/*
 * Author: Jamie
 * Date: October 22, 2020
 * Version: v1.0
 * Description: Interface for the MasterULock class. Includes all public methods.
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

public interface MasterUInterface {
    //CLASS CONSTANTS
    static final int COMBO_LENGTH = 4;
    static final int MAX_VALUE = 9;
    public void unlock(int n1, int n2, int n3, int n4);
    public void configure(int n1, int n2, int n3, int n4);
    @Override
    public String toString();
}
