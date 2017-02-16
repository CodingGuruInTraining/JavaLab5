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

//            ArrayList<Integer> allHouses = new ArrayList<>();
//            ArrayList<Integer> allCrates = new ArrayList<>();

            ArrayList<int[]> housesAndCrates = new ArrayList<>();

            for (String item : allLines) {
                String[] temp = item.split(" ");
                int house = Integer.parseInt(temp[1]);
                int crates = Integer.parseInt(temp[3]);
                int[] tempArr = new int[2];
                tempArr[0] = house;
                tempArr[1] = crates;
                housesAndCrates.add(tempArr);
//                allHouses.add(house);
//                allCrates.add(crates);
            }

            int maxCrates = calculateMax(housesAndCrates);
            ArrayList<Integer> housesWithMost = calculateHouseWithMostRecycling(housesAndCrates, maxCrates);
            String houseStr = "";
            for (int x = 0; x < housesWithMost.size() - 1; x++) {
                houseStr += housesWithMost.get(x) + ", ";
            }
            houseStr += housesWithMost.get(housesWithMost.size() - 1);

            System.out.print("Houses with the most crates: " + houseStr);
        }
        catch (IOException err) {
            System.out.println("Can't read file.");
        }
    }

    public static int calculateMax(ArrayList<int[]> cratesPerHouse) {
        // Defines max variable.
        int max = 0;
        int temp;

        // Loops through array and compares item to max variable.
        // Sets item as new max if greater than current max.
        for (int x = 0; x < cratesPerHouse.size(); x++) {
//        for (int[] x : cratesPerHouse) {

            temp = cratesPerHouse.get(x)[1];
            if (temp > max) {
                max = temp;
//            if (x[1] > max) {
//                max = x[0];
            }
        }
        // Returns max variable.
        return max;
    }

    public static ArrayList calculateHouseWithMostRecycling(ArrayList<int[]> cratesPerHouse, int max) {
        // Creates new ArrayList object.
        ArrayList<Integer> housesWithMost = new ArrayList<>();
//        int temp;
        // Loops through provided array and checks if each item
        // is equal to the provided max value. Matches are added
        // to the ArrayList.
        for (int x = 0; x < cratesPerHouse.size(); x++) {
//            temp = cratesPerHouse.get(x)[1];
            if (cratesPerHouse.get(x)[1] == max) {
                housesWithMost.add(cratesPerHouse.get(x)[0]);
            }
        }
        // return ArrayList.
        return housesWithMost;
    }
}
