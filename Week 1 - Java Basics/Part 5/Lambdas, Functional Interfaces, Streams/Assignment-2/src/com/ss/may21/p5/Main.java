package com.ss.may21.p5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Using Java 8 features write a method that returns a comma separated string based on a given list of integers.
 * Each element should be preceded by the letter 'e' if the number is even,
 * and preceded by the letter 'o' if the number is odd.
 * For example, if the input list is (3,44), the output should be 'o3,e44'.
 */

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(intCommaStr(list));
    }

    // method to return a comma-separated string based on given list of integers
    public static String intCommaStr(List<Integer> intList) {
        // returns string with 'e' or 'o' prepended if even or odd
        // check if even or odd then prepend letter
        // make a string using commas
        return intList.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(", "));
    }
}
