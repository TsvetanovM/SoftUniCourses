package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s");

        String result = "";

        for (String s : input) {
            for (int j = 0; j < s.length(); j++) {
                result += s;
            }
        }
        System.out.println(result);
    }
}
