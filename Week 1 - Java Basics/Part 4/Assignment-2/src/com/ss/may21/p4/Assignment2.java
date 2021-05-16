package com.ss.may21.p4;

/**
 * Write a program to create a deadlock between two threads.
 *
 * @author Daniel Frey
 */

public class Assignment2 {
    // strings used in deadlock
    public static final String MY_STR = "This is my string.";
    public static final String NOT_STR = "This will not be your string but MY string.";

    public static void main (String[] args) {
        // threads for deadlock
        DLThreadOne t1 = new DLThreadOne();
        DLThreadTwo t2 = new DLThreadTwo();

        // start threads
        t1.start();
        t2.start();
    } // main

    // thread class 1
    private static class DLThreadOne extends Thread {
        public void run() {
            synchronized (MY_STR) {
                System.out.println("Thread 1 has lock on MY_STR.");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                } // try catch
                System.out.println("Thread 1 waiting for NOT_STR.");
                synchronized (NOT_STR) {
                    System.out.println("Thread 1 has both MY_STR and NOT_STR.");
                }
            }
        }
    }

    // thread class 2
    private static class DLThreadTwo extends Thread {
        public void run() {
            synchronized (NOT_STR) {
                System.out.println("Thread 2 has lock on NOT_STR.");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                } // try catch
                System.out.println("Thread 2 waiting for MY_STR.");
                synchronized (MY_STR) {
                    System.out.println("Thread 2 has both MY_STR and NOT_STR.");
                }
            }
        }
    }
} // Assignment2


