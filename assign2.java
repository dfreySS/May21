import java.util.Random

/**
 * User is asked to guess a number 1-100. (Program chooses randomly.)
 *      If the guess is within 10 of the correct answer, plus or minus, output the correct answer and exit.
 *          (If the answer is 63, user must guess 53-73.)
 *      If the number is not within 10 of the correct answer, ask the user to keep guessing.
 *      If the user does not succeed within 5 attempts, display, "Sorry," along with the answer and exit.
**/

/**
 * Random Number Guess
 *      The program generates a number
 *      User guesses number
 *          If within 10 = correct, answer output and exit
 *          If not within 10, give 5 attemps
 *              Then say "Sorry" with answer and exit
 * author: Daniel Frey
 */

public class Assignment2
{
    public static void main(Strings[] args)
    {
        
    }
}

public class RandomNumberGuess{
    int numMin = 1;
    int numMax = 100;
    Random rand = new Random();

    //generate random number from 1-100
    int randNum = rand.nextInt(numMax) + numMin;


}

