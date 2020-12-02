package com.company;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double studioPrice = 0;
        double apartmentPrice = 0;

        switch (month){
            case "May":
            case "October":
                studioPrice = 50 * nights;
                apartmentPrice = 65 * nights;
                break;
            case "June":
            case "September":
                studioPrice = 75.2 * nights;
                apartmentPrice = 68.7 * nights;
                break;
            case "July":
            case "August":
                studioPrice = 76*nights;
                apartmentPrice = 77*nights;
                break;
        }
        if ((month.equals("May")||month.equals("October"))&&nights>7&&nights<=14){
            studioPrice = studioPrice * 0.95;
        }
        if ((month.equals("May")||month.equals("October"))&&nights>14){
            studioPrice = studioPrice * 0.7;
        }
        if ((month.equals("June")||month.equals("September"))&&nights>14){
            studioPrice = studioPrice * 0.8;
        }
        if (nights>14){
            apartmentPrice = 0.9*apartmentPrice;
        }
        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", apartmentPrice, studioPrice);
    }
}
