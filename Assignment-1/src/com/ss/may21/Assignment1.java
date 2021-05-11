package com.ss.may21;


/**
 * Write a Java program that prints out the following patterns::
 *      1)
 *      *
 *      **
 *      ***
 *      ****
 *      .........
 *      2)
 *      ..........
 *      ****
 *      ***
 *      **
 *      *
 *      3)
 *           *
 *          ***
 *         *****
 *        *******
 *      ...........
 *      4)
 *      ............
 *        *******
 *         *****
 *          ***
 *           *
 *
 * @author Daniel Frey
 */

// driver class
public class Assignment1
{
    public static void main(String[] args)
    {
        final int START_NUM = 1;
        // starting point, init class instance
        SpecificOutput pattern = new SpecificOutput(START_NUM);
    } // main
} // Assignment1

// class to output specific pattern of stars
class SpecificOutput
{
    private int count;  // problem counter
    private int MAX_ROWS;   // max num of rows of star output

    // constructor
    public SpecificOutput()
    {
        this.count = 0;
    }

    // constructor that specifies starting problem number
    public SpecificOutput(int startNum)
    {
        this.count = startNum;
    }

    // starts building the specific output
    public void buildOutput()
    {
        for (this.count; this.count < 5; this.count++)
        {
            // print problem number
            System.out.println(this.count + ")");

            // determin which problem to output
            switch (this.count)
            {
                case 1:
                    increaseLeftPyramid();
                    break;
                case 2:
                    decreaseLeftPyramid();
                    break;
                case 3:
                    increaseCenterPyramid();
                    break;
                case 4:
                    decreaseCenterPyramid();
                    break;
                default:
            }
        }
    } // buildOutput

    // creates a pyramid of stars in increasing order, left aligned
    private void increaseLeftPyramid()
    {
        // loop through rows of stars
        for(int row = 1; row <= MAX_ROWS; row++)
        {
            System.out.println("*".repeat(row));
        } // for

        // line of periods
        System.out.println(dottedLine(9));
    } // increaseDown

    // creates a pyramid of stars in decreasing order, left aligned
    private void decreaseLeftPyramid()
    {
        // line of periods
        System.out.println(dottedLine(10));

        // loop through rows of stars
        for(int row = MAX_ROWS; row >= 1; row--)
        {
            System.out.println("*".repeat(row));
        } // for
    } // decreaseDown

    // creates a pyramid of stars in increasing order, center aligned
    private void increaseCenterPyramid()
    {
        int numSpaces = 5;

        // loop through rows of stars
        for(int row = 1; row <= MAX_ROWS; row = row + 2)
        {
            // output leading spaces then stars
            System.out.println(" ".repeat(numSpaces) + "*".repeat(row));
            numSpaces--;
        }

        // line of periods
        System.out.println(dottedLine(11));
    } // increaseCenterPyramid

    // creates a pyramid of stars in decreasing order, center aligned
    private void decreaseCenterPyramid()
    {
        // line of periods
        System.out.println(dottedLine(12));

        int numSpaces = 2;

        // loop through rows of stars
        for(int row = MAX_ROWS; row >= 1; row = row - 2)
        {
            // output leading spaces then stars
            System.out.println(" ".repeat(numSpaces) + "*".repeat(row));
            numSpaces++;
        }
    } // decreaseCenterPyramid

    // increments the problem counter by 1
    private void incrementCounter()
    {
        this.count++;
    } // incrementCounter

    // returns a string of '.' chars of specified length
    private String dottedLine(int length)
    {
        return ".".repeat(length);
    } // dottedLine
} // SpecificOutput