package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double h = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());

        double wcm = w * 100 - 100;
        double count1 = wcm/70;
        count1 = Math.floor(count1);
        double hcm = h*100;
        double count2 = hcm/120;
        count2 = Math.floor(count2);

        double finalcount = count1*count2 - 3;

        System.out.printf("%.0f", finalcount);

    }
}
