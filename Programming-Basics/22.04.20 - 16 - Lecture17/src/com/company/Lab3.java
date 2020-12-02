package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cruiseType = scan.nextLine();
        String cabinType = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double pricePerNight = 0;

        switch (cruiseType){
            case "Mediterranean":
                switch (cabinType){
                    case "standard cabin":
                        pricePerNight = 27.5;
                        break;
                    case "cabin with balcony":
                        pricePerNight = 30.2;
                        break;
                    case "apartment":
                        pricePerNight = 40.5;
                        break;
                }
                break;
            case "Adriatic":
                switch (cabinType){
                    case "standard cabin":
                        pricePerNight = 22.99;
                        break;
                    case "cabin with balcony":
                        pricePerNight = 25;
                        break;
                    case "apartment":
                        pricePerNight = 34.99;
                        break;
                }
                break;
            case "Aegean":
                switch (cabinType){
                    case "standard cabin":
                        pricePerNight = 23;
                        break;
                    case "cabin with balcony":
                        pricePerNight = 26.6;
                        break;
                    case "apartment":
                        pricePerNight = 39.8;
                        break;
                }
                break;
        }
        double totalPrice = pricePerNight*nights*4;
        if (nights>7){
            totalPrice = 0.75*totalPrice;
        }
        System.out.printf("Annie's holiday in the %s sea costs %.2f lv.", cruiseType, totalPrice);
    }
}
