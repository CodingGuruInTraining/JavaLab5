package com.mark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hl4350hb on 2/15/2017.
 */
public class problem_3 {
    public static void main(String[] args) {

        try (BufferedReader buffReader = new BufferedReader(new FileReader("recyclingreport-mainstreet.txt"))){
            // Creates FileReader and BufferedReader objects.
            FileReader reader = new FileReader("recyclingreport-mainstreet.txt");
            buffReader = new BufferedReader(reader);

            ArrayList<String> allLines = new ArrayList<String>();
            String line = buffReader.readLine();
            while (line != null) {
                allLines.add(line);
                line = buffReader.readLine();
            }

            for (String item : allLines) {

            }
        }
        catch (IOException err) {
            System.out.println("Can't read file.");
        }
        finally {
            buffReader.close();
        }
    }
}
