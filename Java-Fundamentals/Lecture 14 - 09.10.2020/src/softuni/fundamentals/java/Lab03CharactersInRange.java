package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        charsInBetween(scan.nextLine().charAt(0), scan.nextLine().charAt(0));
    }

    static void charsInBetween (char a, char b) {
        int lastCharacter = Math.max(a, b);
        int firstCharacter = Math.min(a, b);
        for (int i = firstCharacter+1; i < lastCharacter; i++) {
            System.out.print((char) i + " ");
        }
    }
}
