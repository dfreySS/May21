package com.ss.may21.p4;

/**
 * Create unit tests for the Line Class (see video).
 *     Create a file called LineTest.java.
 *     Create tests for the getSlope, getDistance, and parallelTo methods.
 *     Because of rounding errors, it is bad practice to test double values for exact equality.
 *     To get around this, you can pass a small value (such as .0001) to assertEquals to be used as a delta.
 *
 * @author Daniel Frey
 */

// Singleton class implemented with double-checked locking
public class SingletonDC {
    public static void main (String[] args) {
        System.out.println(SingletonDC.getInstanceDC());
    } // main

    // make variable volatile for thread safety
    volatile private static SingletonDC instance = null;

    // private constructor to prevent multiple instances
    private SingletonDC() {

    }

    // singleton with double-checked locking
    public static SingletonDC getInstanceDC() {
        // first check, no locking
        if (instance == null) {
            synchronized (SingletonDC.class)
            {
                // second check, with locking
                if (instance == null) {
                    instance = new SingletonDC();
                }
            }
        }
        return instance;
    } // getInstanceDC
} // SingletonDC
