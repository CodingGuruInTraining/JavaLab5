package com.mark;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This program tests creating a new directory and adding a
 * new file to it.
 */
public class adv_problem_2 {
    public static void main(String[] args) {
        // Exception handler.
        try {
            // Captures the path of the current location of the program.
            // This was modified as part adv_problem_3.
            String fullPath = System.getProperty("user.dir");
            // Creates less wordy variable for adding the appropriate separator
            // based on the system in use (hopefully).
            String sep = File.separator;
            // Creates a new File object.
            Path newFile = Paths.get(fullPath + sep + "data" + sep + "sample.txt");
            // Creates a new directory if one does not exist.
            Files.createDirectories(newFile.getParent());
            // Adds the File object to the new directory.
            Files.createFile(newFile);

        }
        catch (IOException err) {
            // Error occurs when trying to create a file with the same name.
            System.out.println("That file already exists.");
        }
    }
}

//helpful sites:
//        http://stackoverflow.com/questions/2833853/create-whole-path-automatically-when-writing-to-a-new-file
//        http://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
//        http://stackoverflow.com/questions/2417485/file-separator-vs-slash-in-paths
