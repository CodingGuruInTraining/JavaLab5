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
        // Exception handler with BufferedWriter object created inside it.
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("mySystem.txt"))) {
            // Retrieves certain System Properties and stores in strings.
            String osName = System.getProperty("os.name");
            String osVersion = System.getProperty("os.version");
            String osArchitecture = System.getProperty("os.arch");
            String userName = System.getProperty("user.name");
            String line = System.getProperty("line.separator");

            // Writes properties to a file.
            buffWriter.write("Some of the current system's properties include:" + line);
            buffWriter.write("OS Name: " + osName + line);
            buffWriter.write("OS Version: " + osVersion + line);
            buffWriter.write("OS Architecture: " + osArchitecture + line);
            buffWriter.write("User Name: " + userName + line);

            // Closes writer object.
            buffWriter.close();
        }
        catch (IOException err) {
            // Exception for problems with the file and/or location.
            System.out.println("That file already exists.");
        }
    }
}

//helpful site:
//        http://www.ibm.com/support/knowledgecenter/ssw_i5_54/rzaha/sysprop2.htm