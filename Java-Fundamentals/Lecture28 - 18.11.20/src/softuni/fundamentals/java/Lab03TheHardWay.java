package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab03TheHardWay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String text = scan.nextLine();
        String result = text;
        int nextWordIndex = text.indexOf(word);
        while (nextWordIndex != -1) {
            int currentIndex = 0;
            List<String> substrings = new ArrayList<>();

            while (nextWordIndex != -1) {
                String substr = result.substring(currentIndex, nextWordIndex);
                substrings.add(substr);
                currentIndex = nextWordIndex + word.length();
                nextWordIndex = result.indexOf(word, currentIndex);
            }
            substrings.add(result.substring(currentIndex));
            result = String.join("", substrings);
            nextWordIndex = result.indexOf(word);
        }
        System.out.println(result);
    }
}
