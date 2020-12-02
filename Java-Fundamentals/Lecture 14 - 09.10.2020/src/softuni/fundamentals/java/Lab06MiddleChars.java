package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06MiddleChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        middleCharacters(scan.nextLine());
    }

    public static void middleCharacters (String input) {
        int middleChar = input.length()/2;
        if (input.length()%2==0) {
            System.out.println(input.charAt(middleChar-1)+""+input.charAt(middleChar));
        }
        else {
            System.out.println(input.charAt(middleChar));
        }
    }
}
