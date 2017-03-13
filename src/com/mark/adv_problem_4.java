package com.mark;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program uses System Properties to identify certain
 * properties of the current machine and writes them to
 * a file.
 */
public class adv_problem_4 {
    public static void main(String[] args) {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("mySystem.txt"))) {
            String osName = System.getProperty("os.name");
            String osVersion = System.getProperty("os.version");
            String osArchitecture = System.getProperty("os.arch");
            String userName = System.getProperty("user.name");
            String line = System.getProperty("line.separator");

            System.out.println(osName);
            System.out.println(osVersion);
            System.out.println(osArchitecture);
            System.out.println(userName);
            buffWriter.close();
        }
        catch (IOException err) {
            System.out.println("That file already exists.");
        }

    }
}
