package com.ss.may21.p5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of Strings, write a method that returns a list of all strings that
 * start with the letter 'a' (lower case) and have exactly 3 letters.
 * TIP: Use Java 8 Lambdas and Streams API's.
 */

public class Main {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("123", "abc", "ABC", "a1b2c3", "aaa");
        System.out.println(startAThreeLetters(strList));
    }

    // method that returns list of strings that start with 'a' and has only 3 letters
    public static List<String> startAThreeLetters (List<String> strList) {
        // returns list of strings that only start with 'a' and exactly 3 letters
        return strList.stream()
                .filter(str -> (str.startsWith("a") && str.length() == 3))
                .collect(Collectors.toList());
    }
}
