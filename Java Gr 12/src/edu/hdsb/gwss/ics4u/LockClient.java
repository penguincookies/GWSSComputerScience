/*
 * Author: Jamie
 * Date: October 21, 2020
 * Version: v1.1
 * Description: A client to test the Lock class and all of its subclasses
 */
package edu.hdsb.gwss.ics4u;

import edu.hdsb.gwss.jamie.ics4u.u4.Lock.AndroidLock;
import edu.hdsb.gwss.jamie.ics4u.u4.Lock.DudleyLock;
import edu.hdsb.gwss.jamie.ics4u.u4.Lock.MasterLock;
import edu.hdsb.gwss.jamie.ics4u.u4.Lock.MasterULock;
import java.util.Scanner;

public class LockClient {

    public static void main(String[] args) throws NullPointerException{
        Scanner input = new Scanner(System.in);
        //CONTRUCTOR TRACE STATEMENTS WILL FOLLOW
        System.out.println("Constructors:");
        System.out.println("-------------");
        DudleyLock d = new DudleyLock();
        MasterULock u = new MasterULock();
        AndroidLock a = new AndroidLock(0, 0, 7);
        MasterLock m = new MasterLock();
        MasterLock m2 = new MasterLock();
        
        //DEMONSTRATING A NON-CONFIGURABLE LOCK
        System.out.println("");
        System.out.println("You can only get a lock's combo once");
        System.out.println("------------------------------------");
        System.out.println(d.getCombo());
        d.getCombo();
        d.lock();
        d.getCombo();
        System.out.println("");
        System.out.println("Unlock the lock(enter one digit at a time");
        System.out.println("------------------------------------------------------");
        d.unlock(input.nextInt(), input.nextInt(), input.nextInt());
        
        //DEMONSTRATING THE 3-STRIKE SECURITY FEATURE
        System.out.println("");
        System.out.println("If a lock is unsuccesfully unlocked after three tries,");
        System.out.println("it becomes permanently locked forever;");
        System.out.println("------------------------------------------------------");
        System.out.println(m.getCombo());
        m.lock();
        m.unlock(0, 0, 0);
        m.unlock(0, 0, 0);
        m.unlock(0, 0, 0);
        m.unlock(0, 0, 0);
        m.unlock(0, 0, 0);
        
        
        //DEMONSTRATING A CONFIGURABLE LOCK
        System.out.println("");
        System.out.println("With a no combination, the lock won't work");
        System.out.println("------------------------------------------");
        System.out.println(u.getCombo());
        //INSTANTIATING A CONFIGURABLE LOCK WILL NOT ALSO SET A COMBO
        u.lock();
        u.unlock(0, 0, 0, 0);
        System.out.println("");
        System.out.println("Configuring the lock with bad data won't work");
        System.out.println("---------------------------------------------");
        //AN ERRONEOUS COMBO(PASS AN INT GREATER THAN 9)
        u.configure(6, 7, 18, 0);
        //A VALID COMBO
        u.configure(1, 5, 3, 5);
        //NOTE HOW YOU CAN'T GET A COMBO IF YOU'VE CONFIGURED A LOCK
        System.out.println(u.getCombo());
        System.out.println("");
        System.out.println("Locking and unlocking are self explanaroty");
        System.out.println("------------------------------------------");
        System.out.println("Is the lock locked? " + u.isLocked());
        u.lock();
        u.unlock(1, 5, 3, 5);
        System.out.println("");
        
        //DEMONSTRATING A CONFIGURABLE LOCK
        System.out.println("Using a lock that was configured when instantiated");
        System.out.println("--------------------------------------------------");
        a.lock();
        a.unlock(0, 0, 7);
        a.lock();
        System.out.println("");
        System.out.println("A lock must be unlocked in order to configure it");
        System.out.println("------------------------------------------------");
        a.configure(7, 0, 0);
        
        //.EQUALS()
        System.out.println("The .equals method will only return true if the");
        System.out.println("passed lock's serial numbers match(AKA, they're the");
        System.out.println("same exact lock)");
        System.out.println(m.equals(m2));
        System.out.println(u.equals(u));
    }
    
}
