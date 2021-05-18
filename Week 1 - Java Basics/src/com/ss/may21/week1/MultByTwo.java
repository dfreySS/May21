package com.ss.may21.week1;

import java.util.Arrays;
import java.util.List;

/**
 * Assignment 3: Functional
 * Given a list of integers, return a list where each integer is multiplied by 2.
 * doubling([1, 2, 3]) → [2, 4, 6]
 * doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
 * doubling([]) → []
 *
 * @author Daniel Frey
 */

public class MultByTwo {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 27, 4, 1846);
        System.out.println("Input: " + intList);
        System.out.println(doubling(intList));
    }

    // doubles a list of integers, mult by 2
    public static List<Integer> doubling(List<Integer> list) {
        list.replaceAll(i -> i * 2);
        return list;
    }
}
