package com.ss.may21;

import java.io.*;

/**
 * Write a Java program that counts the number of times a particular character, such as 'e', appears in a file.
 * The character can be specified at the command line.
 *
 * @author Daniel Frey
 */

public class Assignment3 {
    public static void main (String[] args) {
        if (args.length > 0) {
            FindInFile find = new FindInFile();
            String txtToFind = String.join(" ", args);  // combine str array to str separated by space
            final String FILE_NAME = "input.txt";
            int count = find.countInFile(txtToFind, "input.txt");

            System.out.println("\"" + txtToFind + "\" occurs " + count + " times.");
        }
        else {
            System.out.println("Insufficient args.");
        }
    }
}

// finds num occurrences of char/str in file
class FindInFile {
    private Integer count;

    // constructor
    public FindInFile () {
        this.count = 0; // init count to 0
    }

    // loops through the file to find occurrences of text to find
    public int countInFile (String findTxt, String fileName) {
        String fileLine; // line from file
        int currPos; // current position index from findTxt

        // loop through file lines finding all occurrences in each line
        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(fileName))))) {
            while ((fileLine = inStream.readLine()) != null)   {
                currPos = fileLine.indexOf(findTxt);
                while (currPos != -1) {    // indexOf() returns -1 when not found
                    count++;
                    // new position is the starting index of the current occurrence + length of the text to find
                    currPos = fileLine.indexOf(findTxt, currPos + findTxt.length());
                } // inner while
            } // outer while
        }catch (IOException ioException) {
            System.err.println("Error: " + ioException.getMessage());
        }
        return count;
    } // countInFile
} // FindInFile

