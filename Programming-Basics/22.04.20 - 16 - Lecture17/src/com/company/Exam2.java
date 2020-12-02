package com.company;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double towelPrice = Double.parseDouble(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double umbrellaPrice = 2/3.0*towelPrice;
        double flippersPrice = 0.75*umbrellaPrice;
        double bagPrice = (1/3.0)*(towelPrice+flippersPrice);
        double totalPrice = (towelPrice+umbrellaPrice+flippersPrice+bagPrice);
        double fullDiscount = discount/100.0*totalPrice;
        totalPrice = totalPrice-fullDiscount;

        if (totalPrice<=budget){
            System.out.printf("Annie's sum is %.2f lv. She has %.2f lv. left.", totalPrice, budget - totalPrice);
        }
        else {
            System.out.printf("Annie's sum is %.2f lv. She needs %.2f lv. more.", totalPrice, totalPrice-budget);
        }
    }
}
