package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int meters = scan.nextInt();
        double kilometers = meters/1000.0;
        System.out.printf("%.2f", kilometers);
    }
}
