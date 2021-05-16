package com.ss.may21;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write a Java program to append text to an existing file.
 *
 * @author Daniel Frey
 */

// driver class
public class Assignment2 {
    public static void main (String[] arg) {
        AppendFile newAppend = new AppendFile();
        newAppend.appendText("This text has been appended 2.");
    }
}

// Appends a given file with specified text
class AppendFile {
    private final String FILE_NAME;

    // constructor if no file name supplied
    public AppendFile () {
        this.FILE_NAME = "Append.txt";
    }

    // constructor
    public AppendFile (String fileName) {
        this.FILE_NAME = fileName;
    }

    // appends the given text
    public void appendText (String text) {
        // check file exist
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            output.println(text);
        } catch (IOException ioe) {
            System.out.println("The file does not exist.");
        }
    }
}
