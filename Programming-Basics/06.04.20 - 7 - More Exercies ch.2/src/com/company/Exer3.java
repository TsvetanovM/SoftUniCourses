package com.company;

import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // X - loze plosht m2; 40% - vino, 1m2 = y kg loze; 1l vino = 2.5kg loze; Z liters - jelano kolichestvo vino;
        int X = Integer.parseInt(scan.nextLine());
        double Y = Double.parseDouble(scan.nextLine());
        int Z = Integer.parseInt(scan.nextLine());
        int R = Integer.parseInt(scan.nextLine());

        double vinoplosht = X*0.4;
        double grozde = vinoplosht * Y;
        double vino = grozde/2.5;

        if (vino>=Z){
            double ostatuk = vino - Z;
            double nakalpak = ostatuk/R;
            ostatuk = Math.ceil(ostatuk);
            nakalpak = Math.ceil(nakalpak);
            vino = Math.floor(vino);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.", vino, ostatuk, nakalpak);
        }
        else {
            double nedostatuk = Z - vino;
            nedostatuk = Math.floor(nedostatuk);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", nedostatuk);
        }
    }
}
