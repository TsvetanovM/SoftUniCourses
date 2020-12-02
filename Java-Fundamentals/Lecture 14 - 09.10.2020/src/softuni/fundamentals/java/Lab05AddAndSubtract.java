package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(subtract(sum(scan.nextInt(), scan.nextInt()), scan.nextInt()));
    }

    static int sum(int a, int b) {
        return a+b;
    }

    static int subtract(int a, int b) {
        return  a-b;
    }
}
