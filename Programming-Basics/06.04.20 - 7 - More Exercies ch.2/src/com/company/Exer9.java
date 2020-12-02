package com.company;

import java.util.Scanner;

public class Exer9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //•	Бензин – 2.22 лева за един литър,
        //•	Дизел – 2.33 лева за един литър
        //•	Газ – 0.93 лева за литър
        //следните намаления за литър гориво: 18 ст. за литър бензин, 12 ст. за литър дизел и 8 ст. за литър газ.
        //Ако шофьора е заредил между 20 и 25 литра включително, той получава 8 процента отстъпка от крайната цена,
        // при повече от 25 литра гориво, той получава 10 процента отстъпка от крайната цена.
        String FuelType = scan.nextLine();
        double FuelAmount = Double.parseDouble(scan.nextLine());
        String ClubCard = scan.nextLine();
        double FuelPrice = 0;

        switch (FuelType) {
            case "Diesel":
                if (ClubCard.equals("Yes")) {
                    FuelPrice = FuelAmount * 2.21;
                } else {
                    FuelPrice = FuelAmount * 2.33;
                }
                break;
            case "Gasoline":
                if (ClubCard.equals("Yes")) {
                    FuelPrice = FuelAmount * 2.04;
                } else {
                    FuelPrice = FuelAmount * 2.22;
                }
                break;
            case "Gas":
                if (ClubCard.equals("Yes")) {
                    FuelPrice = FuelAmount * 0.85;
                } else {
                    FuelPrice = FuelAmount * 0.93;
                }
                break;
        }
        if (FuelAmount>25){
            FuelPrice = FuelPrice*0.9;
        }
        else if (FuelAmount>=20){
            FuelPrice = FuelPrice * 0.92;
        }
        System.out.printf("%.2f lv.", FuelPrice);

    }
}
