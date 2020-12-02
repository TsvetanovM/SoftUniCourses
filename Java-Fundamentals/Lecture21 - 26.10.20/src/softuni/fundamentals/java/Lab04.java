package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int m = 1 << p;
        m = ~m;
        int print = n & m;
        System.out.println(print);
    }
}
