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

            ArrayList<String> allLines = new ArrayList<>();
            String line = buffReader.readLine();
            while (line != null) {
                allLines.add(line);
                line = buffReader.readLine();
            }
            buffReader.close();

            ArrayList<Integer> allHouses = new ArrayList<>();
            ArrayList<Integer> allCrates = new ArrayList<>();

            for (String item : allLines) {
                String[] temp = item.split(" ");
                int house = Integer.parseInt(temp[1]);
                int crates = Integer.parseInt(temp[3]);
                allHouses.add(house);
                allCrates.add(crates);
            }




        }
        catch (IOException err) {
            System.out.println("Can't read file.");
        }
    }
}
