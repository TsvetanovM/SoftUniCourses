package com.company;

import java.util.Scanner;

public class IfElseIf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());

        if (a <= 4) {
            System.out.println("Good");
        }
        else if (a<= 5.49) {
            System.out.println("Very good");
        }
        else {
            System.out.println("Excellent");
        }
    }
}
