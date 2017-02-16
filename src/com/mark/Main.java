package com.mark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// This program writes some lines to a text file and then reads
// the same lines.

public class Main {

    public static void main(String[] args) throws IOException {
        // Creates FileWriter and BufferedWriter objects.
        FileWriter writer = new FileWriter("lab5_problem1.txt");
        BufferedWriter buffWriter = new BufferedWriter(writer);
        // Writes lines to text file.
        buffWriter.write("Mark Fox\n");
        buffWriter.write("green\n");
        buffWriter.write("2545\n");
        // Closes object.
        buffWriter.close();
        // Creates FileReader and BufferedReader objects.
        FileReader reader = new FileReader("lab5_problem1.txt");
        BufferedReader buffReader = new BufferedReader(reader);
        // Reads first line of text file.
        String line = buffReader.readLine();
        // Continue reading lines until nothing is returned.
        while (line != null) {
            // Displays line.
            System.out.println(line);
            line = buffReader.readLine();
        }
        // Closes object.
        buffReader.close();
    }
}
