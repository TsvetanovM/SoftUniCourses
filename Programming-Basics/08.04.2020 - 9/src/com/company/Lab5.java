package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int fishermen = Integer.parseInt(scan.nextLine());
        double price = 0;

        switch (season){
            case "Spring":
            price = 3000;
            break;
            case "Summer":
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }
        if (fishermen<=6){
            price = price*0.9;
        }
        else if (fishermen<=11){
            price = price * 0.85;
        }
        else {
            price = price * 0.75;
        }
        if (fishermen % 2==0 && !season.equals("Autumn")){
            price = price * 0.95;
        }
        if (price <= budget){
            price = budget - price;
            System.out.printf("Yes! You have %.2f leva left.", price);
        }
        else {
            price = price - budget;
            System.out.printf("Not enough money! You need %.2f leva.", price);
        }
    }
}
