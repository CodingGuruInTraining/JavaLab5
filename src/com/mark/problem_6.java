package com.mark;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This program is corrected to include exception handling.
 */
public class problem_6 {
    public static void main(String[] args) {
        // Exception handler
        try {
            LinkedList languages = new LinkedList();
            languages.push("Python");
            languages.push("Java");
            languages.push("C#");

            while (true) {
                String oneLanguage = (String)languages.pop();
                System.out.println(oneLanguage);
            }
        }
        // Catches error thrown.
        catch (NoSuchElementException err) {
            System.out.println("The list is empty");
        }
    }
}
