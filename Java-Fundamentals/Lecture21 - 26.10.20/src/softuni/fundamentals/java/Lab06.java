package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int mask = 7 << p;
        int result = n^mask;
        System.out.println(
                result
        );
    }
}
