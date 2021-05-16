package com.ss.may21.p4;

/**
 * Implement a Singleton with double-checked locking.
 *
 * @author Daniel Frey
 */

// driver class
public class Assignment1 {
    public static void main (String[] args) {
        SingletonDC dcLockingInstance;
        dcLockingInstance = SingletonDC.getInstanceDC();
    }
}

