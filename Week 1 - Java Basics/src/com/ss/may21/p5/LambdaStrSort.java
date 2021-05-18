package com.ss.may21.p5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingInt;

/**
 * Basic lambdas. Make an array containing a few Strings. Sort it by:
 *   • length (i.e., shortest to longest)
 *       (Hint: this exact solution was shown in the lecture)
 *   • reverse length (i.e., longest to shortest)
 *       (Hint: minor variation of the first bullet)
 *   • alphabetically by the first character only
 *       (Hint: charAt(0) returns the numeric code for the first character)
 *   • Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
 *       (Hint: remember that the body of a lambda is allowed to have curly braces and a return statement.
 *       See the first two lambda examples in the notes.)
 *   • Redo the previous problem, but use a static helper method so that your lambda looks like this:
 *       Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
 *
 * @author Daniel Frey
 */

// driver class
public class LambdaStrSort {
    public static void main(String[] args) {
        List<String> strArray = Arrays.asList("First string.", "Second string.", "Third String.", "Spot 4", "Spot five.");
        List<String> tempArr;    // temp array for showing difference between sorted and original

        System.out.println("Original String Array:\n" + strArray);

        // sort by length- shortest to longest
        //strArray.sort((s1, s2) -> s1.length() - s2.length());
        tempArr = strArray.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        System.out.println("\nSort - short to long:\n" + tempArr);

        // sort by length- longest to shortest
        //strArray.sort((s1, s2) -> s2.length() - s1.length());
        tempArr = strArray.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .collect(Collectors.toList());
        System.out.println("\nSort - long to short:\n" + tempArr);

        // sort by first char- alphabetically
        //strArray.sort(comparingInt(s -> s.charAt(0)));
        tempArr = strArray.stream()
                .sorted(comparingInt(s -> s.charAt(0)))
                .collect(Collectors.toList());
        System.out.println("\nSort - alphabetically first char:\n" + tempArr);

        // sort by contains "e" first
        // convert to lower case and then see if it contains "e"
        // then evaluate as 0/1 for boolean t/f
        //strArray.sort(comparingInt(s -> s.toLowerCase().contains("e") ? 0 : 1));
        tempArr = strArray.stream()
                .sorted(comparingInt(s -> s.toLowerCase().contains("e") ? 0 : 1))
                .collect(Collectors.toList());
        System.out.println("\nSort - \"e\" first:\n" + tempArr);

        tempArr = strArray.stream()
                .sorted(comparingInt(s -> containsE(s)))
                .collect(Collectors.toList());
        System.out.println("\nSort - \"e\" first using static method:\n" + tempArr);
    } // main


    // static helper function
    // method to sort by contains "e"
    public static int containsE(String s1) {
        // returns 0 if string contains "e", otherwise returns 1
        return s1.toLowerCase().contains("e") ? 0 : 1;
    }
} // LambdaStrSort
