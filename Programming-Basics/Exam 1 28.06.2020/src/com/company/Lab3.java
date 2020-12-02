package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowerType = scan.nextLine();
        int flowersCount = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        double finalHoney = 0.0;

        if (season.equals("Spring")){
            switch (flowerType){
                case "Sunflower":
                case "Mint":
                    finalHoney = flowersCount*10;
                    break;
                case "Daisy":
                case "Lavender":
                    finalHoney = flowersCount*12;
                    break;
            }
            if (flowerType.equals("Daisy") || flowerType.equals("Mint")){
                finalHoney *= 1.1;
            }
        }
        else if (season.equals("Summer")){
            switch (flowerType){
                case "Sunflower":
                case "Daisy":
                case "Lavender":
                    finalHoney = flowersCount*8;
                    break;
                case "Mint":
                    finalHoney = flowersCount*12;
                    break;
            }
            finalHoney *= 1.1;
        }
        else {
            switch (flowerType){
                case "Sunflower":
                    finalHoney = flowersCount*12;
                    break;
                case "Daisy":
                case "Lavender":
                case "Mint":
                    finalHoney = flowersCount*6;
                    break;
            }
            finalHoney *= 0.95;
        }
        System.out.printf("Total honey harvested: %.2f", finalHoney);
    }
}
