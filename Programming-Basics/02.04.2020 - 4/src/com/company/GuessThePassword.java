package com.company;

import java.util.Scanner;

public class GuessThePassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String attempt = scan.nextLine();
        String pass = "s3cr3t!P@ssw0rd";
        if (pass.equals(attempt)) {
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
