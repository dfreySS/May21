package com.ss.may21.p3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a Java program to get a list of all file/directory names
 * (including in subdirectories) under a given directory.
 *
 * @author Daniel Frey
 */

// class to find
public class DirectoryNames {
    public static void main (String[] args) {
        DirectoryNames.listFilesUsingFilesList("./out");
    } // main

    public static void listFilesUsingFilesList (String directory) {
        Path start = Paths.get(directory);  // get location of given directory

        // walk through directory gathering names of files
        try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
            List<String> collect = stream   // create a list of strings
                    .map(String::valueOf)
                    .collect(Collectors.toList());  // append to list

            collect.forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println("The directory does not exist.");
        }
    } // listFilesUsingFilesList
} // DirectoryNames