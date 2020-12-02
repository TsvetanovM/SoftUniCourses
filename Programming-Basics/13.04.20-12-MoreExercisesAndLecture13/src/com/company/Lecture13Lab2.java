package com.company;

import java.util.Scanner;

public class Lecture13Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = scan.nextLine();
        String input = scan.next();

        while (!password.equals(input)){
            input = scan.nextLine();
        }
        System.out.printf("Welcome %s!", username);
    }
}
