package com.ss.may21.p4;

/**
 * @author Daniel Frey
 */

// Singleton class implemented with double-checked locking
public class SingletonDC {
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
    }
}
