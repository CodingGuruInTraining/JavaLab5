package com.mark;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This program generates a sales report after receiving input from
 * the User. Prices and costs are located in a separate file and the
 * report is written to a new file.
 */
public class adv_problem_1 {
    public static void main(String[] args) {
        // Exception handler with a new BufferedReader inside it.
        try (BufferedReader buffReader = new BufferedReader(new FileReader("coffee.txt"))) {
            // Retrieving the prices and costs from file.
            ArrayList<String[]> all_drinks = readDrinkInfo(buffReader);
            // Retrieving user inputs.
            HashMap<String, Integer> salesData = askSales(all_drinks);
            // Null returns indicate incorrect inputs.
            if (salesData != null) {
                // Runs function to create report file.
                makeSalesReport(all_drinks,salesData);
            }
        }
        catch (IOException err) {
            // The file could not be found and/or read.
            System.out.println("Unable to read/find file.");
        }
    }

    public static ArrayList<String[]> readDrinkInfo(BufferedReader buffReader) {
        // Exception handler
        try {
            // Creates ArrayList and reads first line of file.
            ArrayList<String[]> all_drinks = new ArrayList<String[]>();
            String drink_line = buffReader.readLine();
            // Continues reading lines and adding its data to ArrayList
            // until there are no more lines.
            while (drink_line != null) {
                String[] drink_info = drink_line.split(";");
                all_drinks.add(drink_info);
                drink_line = buffReader.readLine();
            }
            // Closes reader and returns ArrayList.
            buffReader.close();
            return all_drinks;
        }
        catch (IOException err) {
            // The file could not be read.
            System.out.println("There is a problem reading the file.");
            return null;
        }
    }

    public static HashMap askSales(ArrayList<String[]> all_drinks) {
        // Creates Scanner object and HashMap.
        Scanner numScanner = new Scanner(System.in);
        HashMap<String, Integer> salesData = new HashMap<>();
        // Loops through ArrayList and prompts User for input.
        for (int i = 0; i < all_drinks.size(); i++) {
            // Index 0 should contain the drink name.
            System.out.println("How many " + all_drinks.get(i)[0] + " drinks were sold today?");
            // Captures input.
            String sales_query = numScanner.nextLine();
            int sales_num = 0;
            // Checks if the input was not an integer.
            if (sales_query.matches("-?\\d+(\\d+)?")) {
                // Converts input to integer and adds to HashMap.
                sales_num = Integer.parseInt(sales_query);
                salesData.put(all_drinks.get(i)[0], sales_num);
            }
            else {
                // User entered bad information.
                System.out.println("Invalid input attempted.");
                return null;
            }
        }
        // Closes Scanner and returns HashMap.
        numScanner.close();
        return salesData;
    }

    public static void makeSalesReport(ArrayList<String[]> all_drinks, HashMap salesData) {
        // Exception handler with new BufferedWriter created inside it.
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("sales-report.txt"))) {

            // Determines current date, formats it accordingly, and writes
            // to file as first line.
            Date today = new Date();
            DateFormat formatDate = new SimpleDateFormat("MMMM dd, yyyy");
            String todayStr = formatDate.format(today);
            buffWriter.write(String.format("Sales Report for %s:\n", todayStr));

            // Loops through ArrayList, captures values, and performs
            // calculations.
            for (Integer i = 0; i < all_drinks.size(); i++) {
                String drink = all_drinks.get(i)[0];
                int sold = (int) salesData.get(drink);
                double costPer = Double.parseDouble(all_drinks.get(i)[1]);
                double cost = costPer * sold;
                double pricePer = Double.parseDouble(all_drinks.get(i)[2]);
                double earned = pricePer * sold;
                double profit = earned - cost;

                // Creates strings of values and adds formatting to them.
                // I was unable to get formats added to all variables with
                // a single builder so this was plan B.
                String drinkStr = drink + ":";
                String soldStr = "Sold " + sold + ",";
                String costStr = String.format("Expenses $%.2f,", cost);
                String earnedStr = String.format("Revenue $%.2f,", earned);
                String profitStr = String.format("Profit $%.2f", profit);
                buffWriter.write(String.format("%-14s %-2s %-14s %-14s %s\n",
                        drinkStr, soldStr, costStr, earnedStr, profitStr));
            }
            // Closes writer and displays success message.
            buffWriter.close();
            System.out.println("Report successfully created.");
        }
        catch (IOException err) {
            // There was a problem writing to the file.
            System.out.println("Unable to write to file.");
        }
    }
}

//helpful sites:
//http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java