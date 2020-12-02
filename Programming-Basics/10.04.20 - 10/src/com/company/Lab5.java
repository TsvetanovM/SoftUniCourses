package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int length = input.length();

        for (int i = 0; i<length; i++){
            char a = input.charAt(i);
            System.out.println(a);
        }
    }
}
