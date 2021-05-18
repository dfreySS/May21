package com.ss.may21.p3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write a Java program to append text to an existing file.
 *
 * @author Daniel Frey
 */

// Appends a given file with specified text
public class AppendFile {
    public static void main (String[] arg) {
        AppendFile newAppend = new AppendFile();
        newAppend.appendText("This text has been appended 2.");
    }

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
