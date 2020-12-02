package com.company;

import java.util.Scanner;

public class Exam6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = Integer.parseInt(scan.nextLine());
        String playerName = "";
        String dessertType = "";
        int numberOfDesserts = 0;
        double totalPrice = 0;
        int totalDesserts = 0;

        for (int i =1; i<=numberOfPlayers; i++){
            int totalCookies = 0;
            int totalWaffles = 0;
            int totalCakes = 0;
            playerName = scan.nextLine();
            dessertType = scan.nextLine();
            while (!dessertType.equals("Stop baking!")){
                numberOfDesserts = Integer.parseInt(scan.nextLine());
                switch (dessertType){
                    case "cookies":
                        totalCookies+=numberOfDesserts;
                        totalDesserts+=numberOfDesserts;
                        totalPrice+= numberOfDesserts*1.5;
                        break;
                    case "waffles":
                        totalWaffles+=numberOfDesserts;
                        totalDesserts+=numberOfDesserts;
                        totalPrice+= numberOfDesserts*2.3;
                        break;
                    case "cakes":
                        totalCakes+=numberOfDesserts;
                        totalDesserts+=numberOfDesserts;
                        totalPrice+= numberOfDesserts*7.8;
                        break;
                }
                dessertType = scan.nextLine();
            }
            System.out.printf("%s baked %d cookies, %d cakes and %d waffles.%n", playerName, totalCookies, totalCakes, totalWaffles);
        }
        System.out.printf("All bakery sold: %d%n", totalDesserts);
        System.out.printf("Total sum for charity: %.2f lv.", totalPrice);
    }
}
