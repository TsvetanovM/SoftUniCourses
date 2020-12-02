package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double income = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        double personal = Double.parseDouble(scan.nextLine());

        double moneySaved = income - personal - 0.3*income;
        double percentSaved = moneySaved/income*100;
        double totalSaved = moneySaved*months;

        System.out.printf("She can save %.2f%%%n", percentSaved);
        System.out.printf("%.2f", totalSaved);
    }
}
