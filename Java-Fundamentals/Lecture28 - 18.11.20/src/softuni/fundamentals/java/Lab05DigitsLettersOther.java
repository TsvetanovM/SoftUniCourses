package softuni.fundamentals.java;

import java.util.Date;
import java.util.Scanner;

public class Lab05DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)){
                digits.append(current);
            }
            else if (Character.isLetter(current)){
                letters.append(current);
            }
            else {
                other.append(current);
            }
        }
        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(other.toString());
    }
}
