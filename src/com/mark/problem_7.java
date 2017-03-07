package com.mark;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This program is corrected and avoids using exception handling.
 */
public class problem_7 {
    public static void main(String[] args) {
            LinkedList languages = new LinkedList();
            languages.push("Python");
            languages.push("Java");
            languages.push("C#");
            // Changed while's condition to check the list's size.
            while (languages.size() > 0) {
                String oneLanguage = (String)languages.pop();
                System.out.println(oneLanguage);
            }
            System.out.println("The list is empty");
    }
}
