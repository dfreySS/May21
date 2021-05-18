package com.ss.may21.p2;

import java.util.Arrays;

/**
 * Take multiple values from the command line and show the result of adding all of them.
 *
 * @author Daniel Frey
 */

// driver class
class Assignment1
{
    public static void main(String[] args)
    {
        // class instance
        AddCmd userInput = new AddCmd(args);

        System.out.println("You entered: " + Arrays.toString(args));

        // if input is good, add
        if (userInput.checkInput())
        {
            System.out.println("Result of adding: " + userInput.addInput());
        }

    } // main
} // LambdaStrSort

// class to take values from command line, add then display result
class AddCmd
{
    private Integer result; // result of adding args from cmd line
    private final String[] INPUT; // array split input from cmd line

    // constructor
    public AddCmd(String[] args)
    {
        // init vars
        this.INPUT = args;
        this.result = 0;
    }

    // check that the args only numeric and whitespace
    public boolean checkInput()
    {
        for (String val : this.INPUT)
        {
            if (!isNumeric(val))
            {
                return false;
            }
        }

        // return true if all numeric
        return true;
    }

    // helper method to check if string is numeric
    private static boolean isNumeric(String string)
    {
        // attempt to parseInt and catch error
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    } // isNumeric

    // adds the input from the string array
    public Integer addInput()
    {
        // if input is good, add
        if (checkInput())
        {
            // add values
            for (String val : INPUT)
            {
                // already checked for isNumeric at this point, redundant to do so again
                result = result + Integer.parseInt(val);
            }
        }

        return result;
    }

} // AddCmd
