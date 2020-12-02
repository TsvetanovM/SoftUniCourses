package com.company;

import java.util.Scanner;

public class Exer7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double strawberryPrice = Double.parseDouble(scan.nextLine());
        double bananas = Double.parseDouble(scan.nextLine());
        double oranges = Double.parseDouble(scan.nextLine());
        double raspberries = Double.parseDouble(scan.nextLine());
        double strawberries = Double.parseDouble(scan.nextLine());

        double raspberryPrice = strawberryPrice/2;
        double total = strawberries*strawberryPrice+raspberries*raspberryPrice+oranges*(raspberryPrice*0.6)+bananas*(raspberryPrice*0.2);

        System.out.printf("%.2f", total);
    }
}
