package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        vowelsCount(scan.nextLine());
    }

    static void vowelsCount(String string) {
        int vowelCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char currentLetter = string.charAt(i);
        switch (currentLetter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'U':
            case 'O':
                vowelCount++;
            }
        }
        System.out.println(vowelCount);
    }
}
