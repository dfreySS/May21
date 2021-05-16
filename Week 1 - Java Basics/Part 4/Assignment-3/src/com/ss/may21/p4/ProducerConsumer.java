package com.ss.may21.p4;

import java.util.Vector;

/**
 * Write a program with one thread (the producer) that produces items (in this case, simple ints).
 * Another thread (the consumer) consumes items.
 * For communication purposes, both threads have access to a bounded buffer which is basically an array.
 *
 * @author Daniel Frey
 */
// class contains both a Producer and a Consumer sub class
public class ProducerConsumer {
    static class Producer implements Runnable {
        private final Vector sharedBuffer;  // buffer for both producer and consumer
        private final int SIZE; // size of buffer

        // constructor, init values
        public Producer(Vector sharedBuffer, int size) {
            this.sharedBuffer = sharedBuffer;
            this.SIZE = size;
        }

        @Override
        public void run() {
            // attempt to produce more than allowed
            // force Producer to wait
            for (int i = 0; i < 7; i++) {
                System.out.println("Produced: " + i);
                try {
                    produce(i);
                } catch (Exception e) {
                    System.out.println("Error.");
                }
            }
        } // run

        // produce a number and put into buffer
        private void produce(int i){
            // while buffer is full, wait
            while (sharedBuffer.size() == SIZE) {
                synchronized (sharedBuffer) {
                    System.out.println("Buffer full. " + Thread.currentThread().getName()
                            + " is waiting , size: " + sharedBuffer.size());

                    try {
                        sharedBuffer.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error.");
                    }
                }
            } // while

            // produce and notify consumer it is able to consume
            synchronized (sharedBuffer) {
                sharedBuffer.add(i);
                sharedBuffer.notifyAll();
            }
        } // produce
    } // Producer

    // Class to Consume from a buffer
    static class Consumer implements Runnable {

        private final Vector sharedBuffer;
        private final int SIZE;

        // constructor
        public Consumer(Vector sharedBuffer, int size) {
            this.sharedBuffer = sharedBuffer;
            this.SIZE = size;
        }

        @Override
        public void run() {
            // always check if anything to consume
            while (true) {
                try {
                    System.out.println("Consumed: " + consume());
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    System.out.println("Error.");
                }
            }
        } // run

        // Consumes from shared buffer
        private int consume() {
            //wait if the queue is empty
            while (sharedBuffer.isEmpty()) {
                synchronized (sharedBuffer) {
                    // buffer empty, nothing to consume, wait
                    // print current status
                    System.out.println("Buffer empty. " + Thread.currentThread().getName()
                            + " is waiting , size: " + sharedBuffer.size());

                    try {
                        sharedBuffer.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error.");
                    }
                }
            } // while

            // consume from buffer and notify producer to produce
            synchronized (sharedBuffer) {
                sharedBuffer.notifyAll();
                return (Integer) sharedBuffer.remove(0);
            }
        } // consume
    } // Consumer
} // ProducerConsumer
