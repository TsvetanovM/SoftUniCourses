package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06TriplesOfLL {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 97; i < 97+n; i++) {
            for (int j = 97; j < 97+n; j++) {
                for (int k = 97; k < 97+n; k++) {
                    char a = (char) i;
                    char b = (char) j;
                    char c = (char) k;
                    System.out.printf("%c%c%c%n", a, b, c);
                }
            }
        }
    }
}
