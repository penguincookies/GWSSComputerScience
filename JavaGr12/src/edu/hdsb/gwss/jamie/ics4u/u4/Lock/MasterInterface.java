/*
 * Author: Jamie
 * Date: October 22, 2020
 * Version: v1.0
 * Description: Interface for the MasterLock class. Includes all public methods.
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

public interface MasterInterface {
    //CLASS CONSTANTS
    static final int COMBO_LENGTH = 3;
    static final int MAX_VALUE = 39;
    public void unlock(int n1, int n2, int n3);
    @Override
    public String toString();
}
