package com.mark;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This program tests...
 */
public class adv_problem_2 {
    public static void main(String[] args) {
        try {

            String fullPath = Paths.get(".").toAbsolutePath().normalize().toString();
            String sep = File.separator;
            Path newFile = Paths.get(fullPath + sep + "data" + sep + "sample.txt");
            Files.createDirectories(newFile.getParent());
            Files.createFile(newFile);

        }
        catch (IOException err) {
            System.out.println("That file already exists.");
        }
    }
}


//helpful sites:
//        http://stackoverflow.com/questions/2833853/create-whole-path-automatically-when-writing-to-a-new-file
//        http://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
//        http://stackoverflow.com/questions/2417485/file-separator-vs-slash-in-paths
