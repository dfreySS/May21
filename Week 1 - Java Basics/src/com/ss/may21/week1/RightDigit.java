package com.ss.may21.week1;

import java.util.Arrays;
import java.util.List;

/**
 * Assignment 2: Functional
 * Given a list of non-negative integers, return an integer list of the rightmost digits.(Note: use %)
 * rightDigit([1, 22, 93]) → [1, 2, 3]
 * rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
 * rightDigit([10, 0]) → [0, 0]
 */

public class RightDigit {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 27, 4, 1846);
        System.out.println("Input: " + intList);
        System.out.println(rightDigit(intList));
    }

    public static List<Integer> rightDigit(List<Integer> list) {
        // go through list using % 10 to get the right-most digit
        list.replaceAll(i -> i % 10);
        return list;
    }
}
