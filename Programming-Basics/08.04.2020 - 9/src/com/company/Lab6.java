package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double moneySpent = 0;

        if (budget<=100){
            switch (season){
                case "winter":
                    moneySpent = 0.7*budget;
                    System.out.printf("Somewhere in Bulgaria%nHotel - %.2f", moneySpent);
                    break;
                case "summer":
                    moneySpent = 0.3*budget;
                    System.out.printf("Somewhere in Bulgaria%nCamp - %.2f", moneySpent);
                    break;
            }
        }
        else if (budget<=1000){
            switch (season){
                case "winter":
                    moneySpent = 0.8*budget;
                    System.out.printf("Somewhere in Balkans%nHotel - %.2f", moneySpent);
                    break;
                case "summer":
                    moneySpent = 0.4 * budget;
                    System.out.printf("Somewhere in Balkans%nCamp - %.2f", moneySpent);
                    break;
            }
        }
        else {
            moneySpent = 0.9*budget;
            System.out.printf("Somewhere in Europe%nHotel - %.2f", moneySpent);
        }

    }
}
