package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        matrix(scan.nextInt());
    }

    static void matrix (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
