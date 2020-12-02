package com.company;

import java.util.Scanner;

public class consoleinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.print("Koi dali poznavam? ");
        System.out.println(input);
        System.out.print("Spored teb? ");
        System.out.println("Ne, a ti?");
        System.out.print("Tupanar");
    }
}
