package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flower = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double price = 0;

        switch (flower){
            case "Roses":
                price = count * 5;
                if (count>80){
                    price = price * 0.9;
                }
                break;
            case "Dahlias":
                price = count * 3.80;
                if (count>90){
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price = count * 2.80;
                if (count>80){
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price = count * 3;
                if (count<120){
                    price = price * 1.15;
                }
                break;
            case "Gladiolus":
                price = count * 2.5;
                if (count<80){
                    price = price * 1.2;
                }
                break;
        }
        if (price<=budget){
        double leftover = budget - price;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, flower, leftover);
        }
        else {
            double moneyNeeded = price - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
        }
    }
}
