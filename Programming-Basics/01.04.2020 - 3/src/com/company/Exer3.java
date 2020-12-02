package com.company;

import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double deposit = Double.parseDouble(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        double interest = Double.parseDouble(scan.nextLine());

        double total = deposit + length*((deposit*(interest/100))/12);

        System.out.println(total);
    }
}
