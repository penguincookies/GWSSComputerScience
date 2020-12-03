/*
 * Author: Jamie
 * Date: October 22, 2020
 * Version: v1.0
 * Description: Interface for the AndroidLock class. Includes all public methods.
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

public interface AndroidInterface {
    //CLASS CONSTANTS
    static final int COMBO_LENGTH = 3;
    static final int MAX_VALUE = 9;
    public void unlock(int n1, int n2, int n3);
    public void configure(int n1, int n2, int n3);
    @Override
    public String toString();
}
