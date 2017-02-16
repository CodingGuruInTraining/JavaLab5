package com.mark;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  This program prompts User for values of a street's recycling
 *  habits and then determines which house sets out the most
 *  recyclables. These values are written to a text file.
 */

public class problem_2 {
    // Creates Scanner object.
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Creates FileWriter and BufferedWriter objects.
        FileWriter writer = new FileWriter("lab5_problem2.txt");
        BufferedWriter buffWriter = new BufferedWriter(writer);

        // Defines static number of houses.
        int numberOfHouses = 8;
        // Runs function that prompts User for input.
        int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);
        // Runs function to sum up the User's inputs.
        int totalCrates = calculateTotal(cratesPerHouse);
        // Runs function to determine the max.
        int maxCrates = calculateMax(cratesPerHouse);
        // Runs function to determine the min.
        int minCrates = calculateMin(cratesPerHouse);
        // Runs function to determine the house(s) with the most crates.
        ArrayList<Integer> housesWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse, maxCrates);
        // Loops through array and writes how many crates each house used.
        for (int x = 0; x < cratesPerHouse.length; x++) {
            buffWriter.write("House " + x + " recycled " + cratesPerHouse[x] + " crate(s)\n");
        }
        // Writes the total number of crates.
        buffWriter.write("\nTotal crates recycled = " + totalCrates + "\n\n");

        // Determines if multiple houses have the max count.
        if (housesWithMostRecycling.size() > 1) {
            // Starts writing for multiple houses.
            buffWriter.write("Houses that recycled the most:\n");

            // Loops through ArrayList and writes each house along with the max value.
            for (int x = 0; x < (housesWithMostRecycling.size()); x++) {
                buffWriter.write("House " + housesWithMostRecycling.get(x) + ": " + maxCrates + " crates\n");
            }
        }
        else {
            // Writes a single house and its number of crates.
            buffWriter.write("House that recycled the most:\n");
            buffWriter.write("House " + housesWithMostRecycling.get(0) + ": " + maxCrates + " crates\n");
        }
        // Closes Scanner and Writer objects.
        numberScanner.close();
        buffWriter.close();
    }
    // Ask user for number of crates for each house. Store in array and return this array.
    public static int[] getRecyclingPerHouse(int houses) {
        // Creates empty array the size of provided houses.
        int[] data = new int[houses];
        // Loops through array length, prompts User, and collects input.
        for (int x = 0; x < data.length; x++) {
            System.out.println("How many recycling crates are " +
                    "set out for House #" + x + "?");
            int input = numberScanner.nextInt();
            // Adds input to array.
            data[x] = input;
        }
        // Returns array.
        return data;
    }
    //Add up all of the numbers in the array and return that
    public static int calculateTotal(int[] cratesPerHouse) {
        // Creates accumulator variable.
        int total = 0;
        // Loops through array and sums the content.
        for (int x : cratesPerHouse) {
            total += x;
        }
        // Returns total variable.
        return total;
    }
    //Which is the largest number in the array?
    public static int calculateMax(int[] cratesPerHouse) {
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
    //Which is the smallest number in the array?
    public static int calculateMin(int[] cratesPerHouse) {
        // Defines min variable with the first array item.
        // The min will be at least one of these items.
        int min = cratesPerHouse[0];
        // Loops through array and compares item to min variable.
        // Sets item as new min if less than current min.
        for (int x : cratesPerHouse) {
            if (x < min) {
                min = x;
            }
        }
        // Returns min variable.
        return min;
    }
    //Use the array to figure out which house number - or array element number - has the most recycling
    public static ArrayList calculateHouseWithMostRecycling(int[] cratesPerHouse, int max) {
        // Creates new ArrayList object.
        ArrayList<Integer> housesWithMost = new ArrayList<>();
        // Loops through provided array and checks if each item
        // is equal to the provided max value. Matches are added
        // to the ArrayList.
        for (int x = 0; x < cratesPerHouse.length; x++) {
            if (cratesPerHouse[x] == max) {
                housesWithMost.add(x);
            }
        }
        // return ArrayList.
        return housesWithMost;
    }
}
//Template used from minneapolis-edu GitHub.