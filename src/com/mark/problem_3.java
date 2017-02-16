package com.mark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This program reads in lines from a text file, captures specific
 * substrings from each line, and determines which houses have
 * the most crates.
 */
public class problem_3 {
    public static void main(String[] args) {
        // Adds exception handler with resource.
        try (BufferedReader buffReader = new BufferedReader(new FileReader("recyclingreport-mainstreet.txt"))){
            // Creates ArrayList to hold all lines from file.
            ArrayList<String> allLines = new ArrayList<>();
            // Reads first line.
            String line = buffReader.readLine();
            // Loops through the rest of the lines until null is
            // returned.
            while (line != null) {
                allLines.add(line);
                line = buffReader.readLine();
            }
            // Closes Reader object.
            buffReader.close();
            // Creates ArrayList to HOUSE the arrays of houses and crates.
            ArrayList<int[]> housesAndCrates = new ArrayList<>();
            // Loops through first ArrayList and splits each line.
            for (String item : allLines) {
                String[] temp = item.split(" ");
                // Grabs the second and fourth substrings and converts
                // their values to integers.
                int house = Integer.parseInt(temp[1]);
                int crates = Integer.parseInt(temp[3]);
                // Stores both converted values in a new array.
                int[] tempArr = new int[2];
                tempArr[0] = house;
                tempArr[1] = crates;
                // Adds array to ArrayList.
                housesAndCrates.add(tempArr);
            }
            // Runs function to determine the max number of crates.
            int maxCrates = calculateMax(housesAndCrates);
            // Runs function to determine all the houses with the max
            // number of crates.
            ArrayList<Integer> housesWithMost = calculateHouseWithMostRecycling(housesAndCrates,
                    maxCrates);
            // Loops through returned ArrayList and adds its values
            // to a new string variable along with a separator.
            String houseStr = "";
            for (int x = 0; x < housesWithMost.size() - 1; x++) {
                houseStr += housesWithMost.get(x) + ", ";
            }
            // Adds the last item without a separator.
            houseStr += housesWithMost.get(housesWithMost.size() - 1);
            // Displays the house numbers with the most crates.
            System.out.print("Houses with the most crates: " + houseStr);
        }
        // Catch for IO exceptions.
        catch (IOException err) {
            // Displays a simple message.
            System.out.println("Can't read file.");
        }
    }

    public static int calculateMax(ArrayList<int[]> cratesPerHouse) {
        // Defines max variable.
        int max = 0;
        // Creates temporary integer variable.
        int temp;

        // Loops through ArrayList and compares second array item to
        // max variable. Sets item as new max if greater than current max.
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            temp = cratesPerHouse.get(x)[1];
            if (temp > max) {
                max = temp;
            }
        }
        // Returns max variable.
        return max;
    }

    public static ArrayList calculateHouseWithMostRecycling(ArrayList<int[]> cratesPerHouse, int max) {
        // Creates new ArrayList object.
        ArrayList<Integer> housesWithMost = new ArrayList<>();
        // Loops through provided ArrayList and checks if each item
        // is equal to the provided max value. Matches are added
        // to the new ArrayList.
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            // Houses are index 0; crates are index 1.
            if (cratesPerHouse.get(x)[1] == max) {
                housesWithMost.add(cratesPerHouse.get(x)[0]);
            }
        }
        // return ArrayList.
        return housesWithMost;
    }
}
