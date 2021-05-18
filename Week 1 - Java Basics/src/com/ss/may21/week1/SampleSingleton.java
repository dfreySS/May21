package com.ss.may21.week1;

import java.sql.Connection;

/**
 *  Fix the Singleton Class
 *
 *      - remove static declaration in method
 *      - make instance volatile
 *      - private constructor to prevent instances being made
 *      - check if instance is null
 *      - synchronize in block
 *      - double check
 *
 *
 * @author Daniel Frey
 */

public class SampleSingleton {

    private static Connection conn = null;

    volatile private static SampleSingleton instance = null;

    public static SampleSingleton getInstanceDC() {
        // first check, no locking
        if (instance == null) {
            synchronized (SampleSingleton.class)
            {
                // second check, with locking
                if (instance == null) {
                    instance = new SampleSingleton();
                }
            }
        }
        return instance;
    } // getInstanceDC
}
