package com.ss.may21;

/**
 * Construct a 2D array and find the max number and show its position in the array.
 *
 * @author: Daniel Frey
 */

// driver class
public class Assignment2
{
    public static void main (String[] args)
    {
        String[][] testArray = {
                {"3", "2", "5"},
                {"1", "10", "4"},
                {"9", "1", "6"},
        };

        Max2DArray test = new Max2DArray(testArray);
        System.out.println(test.findMaxVal());
    }
} // Assignment 2


class Max2DArray
{
    private String[][] array; // array to find max

    // constructor
    public Max2DArray (String[][] array)
    {
        this.array = array;
    }

    // validate input
    private boolean validInput()
    {
        // loop through 2d array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
            {
                if (!isNumeric(array[i][j])) {
                    return false;
                }
            }
        }
        // return true if all numeric
        return true;
    } // validInput

    // find max
    public StringBuilder findMaxVal()
    {
        Integer maxVal;   // max val for array set as the
        Integer[] maxPos = new Integer[2];
        StringBuilder resultStr = new StringBuilder();

        // if valid input then continue
        if (!validInput()) {
            resultStr.append("Input contains invalid integer digits.");
        }
        else {
            maxVal = Integer.parseInt(array[0][0]);
            // loop through array finding the max val
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    int arrayVal = Integer.parseInt(array[i][j]);
                    // compare current value to current max
                    if (arrayVal > maxVal) {
                        maxVal = arrayVal;
                        maxPos[0] = i;
                        maxPos[1] = j;
                    }
                }
            }
            // construct result string
            resultStr.append("Max value: " + maxVal + " at [" + maxPos[0] + ", " + maxPos[1] + "].");
        }

        return resultStr;
    } // findMaxVal

    // helper method to check if string is numeric
    private static boolean isNumeric(String value)
    {
        // attempt to parseInt and catch error
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.print("Error. ");
        }
        return false;
    } // isNumeric
} // Max2DArray
