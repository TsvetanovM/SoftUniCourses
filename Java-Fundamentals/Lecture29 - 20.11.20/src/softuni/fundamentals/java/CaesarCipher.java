package softuni.fundamentals.java;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String entry = scan.nextLine();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < entry.length(); i++) {
            char current = (char) (entry.charAt(i)+3);
            encrypted.append(current);
        }

        System.out.println(encrypted.toString());
    }
}
