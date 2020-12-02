package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab09Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scan.nextLine();
        }
    }

    static boolean isPalindrome (String number) {
        String reversed = "";
        for (int i = number.length()-1; i>=0; i--) {
            reversed += number.charAt(i);
        }
        return reversed.equals(number);
    }
}
