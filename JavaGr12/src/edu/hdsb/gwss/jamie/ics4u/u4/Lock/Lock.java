/*
 * Author: Jamie
 * Date: October 21, 2020
 * Version: v1.1
 * Description: A parent lock class. Inlcudes methods for locking/unlocking, 
 * configuring a new combo, and equals(). toString() methods are contained in
 * the children classes
 */
package edu.hdsb.gwss.jamie.ics4u.u4.Lock;

import java.util.ArrayList;

public abstract class Lock implements LockInterface{
    //NOT A CONSTANT, CANNOT IMPLEMENT STATIC VARIABLE IN INTERFACE
    private static int numOfLocks = 0;
    //INSTANCE VARIABLES
    private int serialNumber;
    private int unsuccessfulAttempts = 0;
    protected int comboLength;
    protected ArrayList combo = new ArrayList();
    protected boolean locked = false;
    private boolean hasChecked = false;
    
    //CONSTRUCTORS
    //FOR THE CONFIGURABLE LOCKS
    //AFTER INSTANTIATING THE LOCK, LEAVES IT UNLOCKED SO IT CAN BE CONFIGURED
    public Lock() {
        numOfLocks++;
        serialNumber = numOfLocks;
        locked = false;
        System.out.println("Lock() Constructor(no combo).");
    }
    //FOR THE NON-CONFIGURABLE LOCKS
    public Lock(int max, int length){
        numOfLocks++;
        serialNumber = numOfLocks;
        locked = false;
        for (int i = 0; i < length; i++) {
            combo.add((int)((Math.random()*(max+1))+MIN_VALUE));
        }
        System.out.println("Lock() Constructor.");
    }

    //GETTERS
    public static int getNumOfLocks(){
        return numOfLocks;
    }
    @Override
    public int getSerialNumber() {
        return serialNumber;
    }
    @Override
    //ONLY ALLOWS THE USER TO CHECK THE CODE OF A LOCK ONCE
    //FOR INTERNAL USAGE USE this.combo
    //RE-CONFIGURING THE COMBO WILL NOT RESET hasChecked
    public ArrayList getCombo() {
        if (!locked) {
            if (hasChecked == false) {
                hasChecked = true;
                return combo;
            }
            System.out.println("You've already checked.");
            return null;
        }
        System.out.println("Unlock the lock to check.");
        return null;
    }
    @Override
    public boolean isLocked() throws NullPointerException {
        return locked;
    }
    @Override
    public boolean isHasChecked() {
        return hasChecked;
    }

    
    //SETTERS
    private static void setNumOfLocks(int numOfLocks) {
        Lock.numOfLocks = numOfLocks;
    }
    private void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    private void setCombo(ArrayList combo) {
        this.combo = combo;
    }
    private void setLocked(boolean l) {
        this.locked = l;
    }
    protected void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }
    
    //LOCKS THE LOCK
    @Override
    public void lock() {
        if (combo.size() < 1) {
            System.out.println("Can't lock! Set a combo.");
        }
        else if (!locked) {
            this.setLocked(true);
            System.out.println("Locked.");
        }
        else {
            System.out.println("Already locked.");
        }
        System.out.println("Lock()");
    }
    
    //UNLOCKS THE LOCK BY COMPARING ARRAYLISTS
    //IF THREE CONSECUTIVE UNSUCCESSFUL ATTEMPTS ARE MADE TO UNLOCK A LOCK, IT 
    //WILL BECOME PERMANENTLY LOCKED
    protected void unlock(ArrayList pl){
        if (combo.size() < 1) {
            System.out.println("Can't unlock. Set a combo.");
        }
        else if(unsuccessfulAttempts < 3){
            if (locked) {
                unsuccessfulAttempts++;
                if (combo.equals(pl)) {
                    locked = false;
                    System.out.println("Unlocked!");
                    unsuccessfulAttempts = 0;
                }
                else {
                    System.out.println("Wrong code.");
                }
            }
            else {
                System.out.println("Already unlocked.");
            }
        }
        else {
            System.out.println("Too many unsuccessful attempts, you're locked out.");
        }
        System.out.println("Unlock()");
    }
    
    //CONFIGURE METHODS FOR CONFIGURABLE LOCKS
    //TO AVOID DUPLICATE CODE, CONFIGURE(3 PARAMETERS)PASSES UNLOCK(4 PARAMETERS) 
    //A TEMP AND THE DELETES IT AFTERWARDS 
    //TO MAKE SURE BAD DATA ISN'T PASSED BY THE CLIENT, ALL NUMBERS ARE PASSED 
    //TO A METHOD THAT MAKES SURE THEY AREN'T BELOW 0 OR ABOVE THE MAXIMUM LIMIT
    //YOU CAN ONLY CONFIGURE IF THE LOCK IS UNLOCKED
    protected void configure(int n1, int n2, int n3, int max){
        combo.add(0);
        this.configure(n1, n2, n3, 0, max);
        combo.remove(3);
        System.out.println("Configure() 3 Digits");
    }
    protected void configure(int n1, int n2, int n3, int n4, int max){
        if (!locked){
            if (checkDigit(n1, max) && checkDigit(n2, max) && checkDigit(n3, max) && checkDigit(n4, max)) {
                combo.removeAll(combo);
                combo.add(n1);
                combo.add(n2);
                combo.add(n3);
                combo.add(n4);
            }
            else {
                System.out.println("Invalid input.");
            }
        }
        else {
            System.out.println("Unlock the lock in order to configure.");
        }
        this.hasChecked = true;
        System.out.println("Configure() 4 Digits");
    }
    
    //HELPER METHOD TO CHECK FOR VALID INPUT
    private boolean checkDigit(int digit, int max){
        System.out.println("checkDigit()");
        if (MIN_VALUE <= digit && digit <= max) {
            return true;
        }
        return false;
    }
    
    //EQUALS METHOD(ONLY RETRUNS TRUE IF THE SERIAL NUMBERS ARE IDENTICAL)
    @Override
    public boolean equals(Lock lock){
        if(this.getSerialNumber() == lock.getSerialNumber()){
            System.out.println("They're the same!");
            return true;
        }
        System.out.println("They're not the same.");
        System.out.println("Equals()");
        return false;
    }
}
