package com.ss.may21.week1;

import java.util.Arrays;
import java.util.List;

/**
 * Assignment 4: Functional
 * Given a list of strings, return a list where each string has all its "x" removed.
 * noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
 * noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
 * noX(["x"]) → [""]
 *
 * @author Daniel Frey
 */

public class StringRemoveX {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("ax", "bb", "cx", "xxx");
        System.out.println("Input: " + strList);
        System.out.println(noX(strList));
    }

    // doubles a list of integers, mult by 2
    public static List<String> noX(List<String> list) {
        list.replaceAll(s -> s.replaceAll("x", ""));
        return list;
    }
}