package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int print = n >> p & 1;
        System.out.println(print);
    }
}
