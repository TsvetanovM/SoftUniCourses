package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(",\\s");
        String text = scan.nextLine();
        for (String word : bannedWords) {
            String replacement = "";
            for (int i = 0; i < word.length(); i++) {
                replacement += "*";
            }
            text = text.replace(word, replacement);
        }

        System.out.println(text);
    }
}
