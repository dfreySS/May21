package com.ss.may21.week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LambdaOpsTest {
        @Test
        public void isOdd() {

            LambdaOps op = new LambdaOps();

            assertEquals("ODD", op.isOdd().check(1));
            assertEquals("EVEN", op.isOdd().check(2));
            assertNotEquals("ODD", op.isOdd().check(2));
            assertNotEquals("EVEN", op.isOdd().check(1));
        }

    @Test
    public void isPrime() {

        LambdaOps op = new LambdaOps();

        assertEquals("PRIME", op.isPrime().check(5));
        assertEquals("COMPOSITE", op.isPrime().check(4));
        assertNotEquals("PRIME", op.isPrime().check(10));
        assertNotEquals("COMPOSITE", op.isPrime().check(17));
    }

    @Test
    public void isPalindrome() {

        LambdaOps op = new LambdaOps();

        assertEquals("PALINDROME", op.isPalindrome().check(12321));
        assertEquals("NOT", op.isPalindrome().check(1234));
        assertNotEquals("PALINDROME", op.isPalindrome().check(1234));
        assertNotEquals("NOT", op.isPalindrome().check(12321));
    }
}
