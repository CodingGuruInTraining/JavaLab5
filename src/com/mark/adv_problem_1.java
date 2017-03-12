package com.mark;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This program generates a sales report...
 */
public class adv_problem_1 {
    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new FileReader("coffee.txt"))) {
            ArrayList<String[]> all_drinks = readDrinkInfo(buffReader);
            HashMap<String, Integer> salesData = askSales(all_drinks);
            if (salesData != null) {
                makeSalesReport(all_drinks,salesData);
            }
        }
        catch (IOException err) {
            System.out.println("Unable to read/find file.");
        }
    }

    public static ArrayList<String[]> readDrinkInfo(BufferedReader buffReader) throws IOException {
        try {
            ArrayList<String[]> all_drinks = new ArrayList<String[]>();
            String drink_line = buffReader.readLine();
            while (drink_line != null) {
                String[] drink_info = drink_line.split(";");
                all_drinks.add(drink_info);
                drink_line = buffReader.readLine();
            }
            buffReader.close();
            return all_drinks;
        }
        catch (IOException err) {
            System.out.println("There is a problem reading the file.");
            return null;
        }
    }

    public static HashMap askSales(ArrayList<String[]> all_drinks) {
        Scanner numScanner = new Scanner(System.in);
        HashMap<String, Integer> salesData = new HashMap<>();
        for (int i = 0; i < all_drinks.size(); i++) {
            System.out.println("How many " + all_drinks.get(i)[0] + " drinks were sold today?");
            String sales_query = numScanner.nextLine();
            int sales_num = 0;
            if (sales_query.matches("-?\\d+(\\d+)?")) {
                sales_num = Integer.parseInt(sales_query);
                salesData.put(all_drinks.get(i)[0], sales_num);
            }
            else {
                System.out.println("Invalid input attempted.");
                return null;
            }
        }
        numScanner.close();
        return salesData;
    }

    public static void makeSalesReport(ArrayList<String[]> all_drinks, HashMap salesData) throws IOException {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("sales-report.txt"))) {
//            FileWriter writer = new FileWriter("sales-report.txt");
//            BufferedWriter buffWriter = new BufferedWriter(writer);

            Date today = new Date();
            DateFormat formatDate = new SimpleDateFormat("MMMM dd, yyyy");
            String todayStr = formatDate.format(today);
            buffWriter.write(String.format("Sales Report for: %s\n", todayStr));

            for (Integer i = 0; i < all_drinks.size(); i++) {
                String drink = all_drinks.get(i)[0];
                int sold = (int) salesData.get(drink);
                double costPer = Double.parseDouble(all_drinks.get(i)[1]);
                double cost = costPer * sold;
                double pricePer = Double.parseDouble(all_drinks.get(i)[2]);
                double earned = pricePer * sold;
                double profit = earned - cost;

                String drinkStr = drink + ":";
                String soldStr = "Sold " + sold + ",";
                String costStr = String.format("Expenses $%.2f,", cost);
                String earnedStr = String.format("Revenue $%.2f,", earned);
                String profitStr = String.format("Profit $%.2f", profit);
                buffWriter.write(String.format("%-14s %-2s %-14s %-14s %s\n",
                        drinkStr, soldStr, costStr, earnedStr, profitStr));
            }
            buffWriter.close();
            System.out.println("Report successfully created.");
        }
        catch (IOException err) {
            System.out.println("Unable to write to file.");
        }
    }
}

//helpful sites:
//http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java