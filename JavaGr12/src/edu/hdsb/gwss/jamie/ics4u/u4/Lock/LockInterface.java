/*
 * Author: Jamie
 * Date: October 21, 2020
 * Version: v1.0
 * Description: Interface for the Lock class. Includes all public methods.
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

import java.util.ArrayList;

//Methods declared inside interface are implicitly public. And all variables declared in the interface are implicitly public static final (constants).
public interface LockInterface {
    static final int MIN_VALUE = 0;
    public ArrayList getCombo();
    public int getSerialNumber();
    public boolean isLocked();
    public boolean isHasChecked();
    public void lock();
    public boolean equals(Lock lock);
    @Override
    public String toString();
}
