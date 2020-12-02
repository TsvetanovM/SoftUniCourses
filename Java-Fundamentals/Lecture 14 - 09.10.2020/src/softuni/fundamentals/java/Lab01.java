package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        smallestNumber(scan.nextInt(), scan.nextInt(), scan.nextInt());
    }

    static void smallestNumber (int a, int b, int c) {
        int smallestNumber = 0;
        if (a<=b) {
            smallestNumber = Math.min(a, c);
        }
        else {
            smallestNumber = Math.min(b, c);
        }
        System.out.println(smallestNumber);
    }
}
