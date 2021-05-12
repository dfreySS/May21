package com.ss.may21;

import java.util.Random;    // random number
import java.util.Scanner;   // user input
import java.lang.Math;      // abs()

/**
 * User is asked to guess a number 1-100. (Program chooses randomly.)
 *      If the guess is within 10 of the correct answer, plus or minus, output the correct answer and exit.
 *          (If the answer is 63, user must guess 53-73.)
 *      If the number is not within 10 of the correct answer, ask the user to keep guessing.
 *      If the user does not succeed within 5 attempts, display, "Sorry," along with the answer and exit.
 *
 * @author: Daniel Frey
 **/

// driver class
public class Assignment2
{
    public static void main(String[] args)
    {
        // starting point, init class instance
        RandomNumberGuess game = new RandomNumberGuess();
        game.startGuessing();
    }
} // Assignment2

/**
 * Class that prompts user for input for guessing random number 1-100.
 * Within 10+- is correct
 * Limit 5 guesses
 */
class RandomNumberGuess
{
    private final int NUM_MIN = 1;
    private final int NUM_MAX = 100;
    private final int MAX_DIFF = 10;    // max difference between rand num and user guess for correct
    private int numGuess = 0; // number of guesses
    private final int MAX_GUESS = 5;
    private int userGuess;  // input guess from user
    private Random rand = new Random();
    private final int RAND_NUM = rand.nextInt(NUM_MAX) + NUM_MIN;   //generate rand num range NUM_MIN:NUM_MAX

    // constructor for class
    public RandomNumberGuess()
    {

    }

    // starts the prompt for guessing
    public void startGuessing()
    {
        // prompt user to start guessing
        System.out.print("Enter your guess for a number between " + NUM_MIN + " and " + NUM_MAX + ": ");

        boolean check;  // user answer in range

        // loop max 5 times/guesses
        do
        {
            this.getInput();

            check = checkGuess();

            // increment guess counter
            this.numGuess++;

            // output message
            System.out.print(determineOutput(check));
        }
        while((this.numGuess != MAX_GUESS) || (!check));

    } // startGuessing

    // get user input
    public void getInput()
    {
        Scanner userInput = new Scanner(System.in); // scanner obj for user input

        // obtain user input
        this.userGuess = userInput.nextInt();
    } // getInput

    // check if user guess is within desired range
    private boolean checkGuess()
    {
        boolean inRange = false;

        // calculate difference between random number and user input
        int difference = Math.abs(this.RAND_NUM - this.userGuess);

        // if in range or not in range
        if (difference <= this.MAX_DIFF)
        {
            inRange = true;
        }
        // else false

        return inRange;
    } // checkGuess

    private String determineOutput(boolean inRange)
    {
        String message;

        // if guess was in range
        if (inRange)
        {
            // output correct answer
            message = String.format("Correct answer: %d\n", this.RAND_NUM);
        }
        else if(this.numGuess == MAX_GUESS)
        {
            // say sorry, give answer
            message = String.format("Sorry! Correct answer: %d\n", this.RAND_NUM);
        }
        else
        {
            // ask for more input
            message = "Incorrect. Please guess again: ";
        }

        return message;
    }
} // RandomNumberGuess


