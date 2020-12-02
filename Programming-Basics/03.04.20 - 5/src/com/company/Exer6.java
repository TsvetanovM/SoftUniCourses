package com.company;

import java.util.Scanner;

public class Exer6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Dekor = D - 10% of Budget = B; If Statisti - S > 150, 10%discount ot price - p na obleklata;
        double b = Double.parseDouble(scan.nextLine());
        int s = Integer.parseInt(scan.nextLine());
        double singleprice = Double.parseDouble(scan.nextLine());

        double d = b/10;
        double price = s * singleprice;

        if (s>150) {
            price = price*0.9;
        }
        double total = d+price;
        if (b>=total){
            total = b - total;
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", total);
        }
        else {
            total = total - b;
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", total);
        }
    }
}
