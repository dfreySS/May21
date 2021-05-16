package com.ss.may21.p4;
import java.util.Vector;

/**
 * Write a program with one thread (the producer) that produces items (in this case, simple ints).
 * Another thread (the consumer) consumes items.
 * For communication purposes, both threads have access to a bounded buffer which is basically an array.
 *
 * @author Daniel Frey
 */

public class Assignment3 {
    public static void main (String[] args) {
        Vector buffer = new Vector();
        final int SIZE = 4;
        Thread pThread = new Thread(new ProducerConsumer.Producer(buffer, SIZE), "Producer");
        Thread cThread = new Thread(new ProducerConsumer.Consumer(buffer, SIZE), "Consumer");

        pThread.start();
        cThread.start();
    } // main


} // Assignment3