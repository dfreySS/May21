package com.ss.may21.week1;

/**
 * Given an array of ints, is it possible to choose a group of some of the ints,
 * such that the group sums to the given target, with this additional constraint:
 *      if there are numbers in the array that are adjacent and the identical value,
 *      they must either all be chosen, or none of them chosen.
 *      For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be
 *      chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
 *
 * groupSumClump(0, [2, 4, 8], 10) → true
 * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
 * groupSumClump(0, [2, 4, 4, 8], 14) → false
 *
 * @author Daniel Frey
 */

public class SumClump {
    public static void main (String[] args) {
        groupSumClump(0, new int[]{2, 4, 8}, 10);
        groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14);
        groupSumClump(0, new int[]{2, 4, 4, 8}, 14);
    } // main

    // tells if possible to choose group of ints that sum to given target
    // successive duplicates must use all or none
    public static boolean groupSumClump(int startPos, int[] intArr, int target) {
        // find the extent of duplicate numbers
        dupReplaceSum(intArr);

        // if startPos extends beyond the length of array
        if (startPos >= intArr.length)
            // this will only eval true if target is 0, which means no numbers = 0
            return target == 0;

        // start at the next position, but keep a 'running sum' of updated target
        if (groupSumClump(startPos + 1, intArr, target - intArr[startPos]))
            return true;

        // continue on if possible with next position without using current position
        if (groupSumClump(startPos + 1, intArr, target))
            return true;
        else
            // not possible
            return false;
    } // groupSumClump

    // checks the extent of the successive duplicate numbers
    // and adds them so that it is easier to groupSumClump
    private static void dupReplaceSum(int[] intArr) {
        // loop through entire array
        for (int i = 0; i < intArr.length; i++) {
            // if current num == prev num
            if (i > 0 && intArr[i] == intArr[i - 1]) {
                // overwrite prev with sum of adding both duplicates
                intArr[i - 1] += intArr[i];

                // re-writing as 0 keeps the array the same length since 0 is insignificant
                // if next one is not a match, overwrite current to 0
                if ((i + 1 < intArr.length) && (intArr[i] != intArr[i + 1]))
                    intArr[i] = 0;
                // reached end of array, not possible to have more numbers
                else if (i == intArr.length - 1)
                    intArr[i] = 0;
            } // if
        } // for
    } // dupReplaceSum
} // SumClump
