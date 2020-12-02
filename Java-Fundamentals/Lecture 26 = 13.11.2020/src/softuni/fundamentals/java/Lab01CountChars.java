package softuni.fundamentals.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab01CountChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();

        Map<Character, Integer> counter = new LinkedHashMap<>();

        for (char ch:input) {
            if (ch==' '){
                continue;
            }
            counter.putIfAbsent(ch, 0);
            int previousCount = counter.get(ch);
            counter.put(ch, previousCount+1);
        }

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
