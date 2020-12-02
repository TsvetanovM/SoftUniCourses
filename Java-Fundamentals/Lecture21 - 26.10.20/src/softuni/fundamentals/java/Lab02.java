package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int a = n >> 1 & 1;
        System.out.println(a);
    }
}
