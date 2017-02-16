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

            int maxCrates = calculateMax(allCrates);
            ArrayList<Integer> housesWithMost = calculateHouseWithMostRecycling(allCrates, maxCrates);

        }
        catch (IOException err) {
            System.out.println("Can't read file.");
        }
    }

    public static int calculateMax(ArrayList<Integer> cratesPerHouse) {
        // Defines max variable.
        int max = 0;
        // Loops through array and compares item to max variable.
        // Sets item as new max if greater than current max.
        for (int x : cratesPerHouse) {
            if (x > max) {
                max = x;
            }
        }
        // Returns max variable.
        return max;
    }

    public static ArrayList calculateHouseWithMostRecycling(ArrayList<Integer> cratesPerHouse, int max) {
        // Creates new ArrayList object.
        ArrayList<Integer> housesWithMost = new ArrayList<>();
        // Loops through provided array and checks if each item
        // is equal to the provided max value. Matches are added
        // to the ArrayList.
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            if (cratesPerHouse.get(x) == max) {
                housesWithMost.add(x);
            }
        }
        // return ArrayList.
        return housesWithMost;
    }
}
