package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char firstLetter = s.charAt(0);
            char secondLetter = s.charAt(s.length()-1);
            String numbers = s.substring(1, s.length()-1);
            double number = Double.parseDouble(numbers);
            number = useLetter(firstLetter, number, "first");
            number = useLetter(secondLetter, number, "last");
            sum += number;
        }

        System.out.printf("%.2f", sum);
    }

    static double useLetter(char letter, double number, String position) {
        if (Character.isLowerCase(letter)){
            int a = letter - 96;
            if (position.equals("first")) {
                return number*a;
            }
            else {
                return number+a;
            }
        }
        else {
            int b = letter - 64;
            if (position.equals("first")) {
                return number/b;
            }
            else {
                return number-b;
            }
        }
    }
}