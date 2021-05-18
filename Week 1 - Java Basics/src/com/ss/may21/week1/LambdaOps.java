package com.ss.may21.week1;

import java.math.BigInteger;

/**
 * Assignment 1: Lambdas
 * Write the following methods that return a lambda expression performing a specified action:
 *
 * PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
 * PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
 * PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
 *
 * Input Format
 * Input is handled for you by the locked stub code in your editor.
 *
 * Output Format
 * The locked stub code in your editor will print  lines of output.
 *
 * Sample Input
 * The first line contains an integer,  (the number of test cases).
 * The subsequent lines each describe a test case in the form of  space-separated integers:
 * The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome).
 * The second integer denotes the number to be checked.
 * 5
 * 1 4
 * 2 5
 * 3 898
 * 1 3
 * 2 12
 *
 * Sample Output
 * EVEN
 * PRIME
 * PALINDROME
 * ODD
 * COMPOSITE
 *
 * @author Daniel Frey
 */

public class LambdaOps {
    // return if odd or even
    public PerformOperation isOdd() {
        return i -> (i % 2 != 0) ? "ODD" : "EVEN";
    }

    // return if prime or composite
    public PerformOperation isPrime() {
        // BigInteger.ispProbablePrime() with 1 certainty - true = probably prime, false = composite
        return i -> ((BigInteger.valueOf(i).isProbablePrime(1)) ? "PRIME" : "COMPOSITE");
    }

    // return if palindrome or not
    public PerformOperation isPalindrome() {
        // make a string from the integer, reverse it
        return i -> i == Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString()) ? "PALINDROME" : "NOT";
    }

} // LambdaOps

// interface for PerformOperation
interface PerformOperation {
    String check(Integer i);
}
