package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gameLength = Integer.parseInt(scan.nextLine());
        double gameScore = 0;
        double tier1 = 0;
        double tier2 = 0;
        double tier3 = 0;
        double tier4 = 0;
        double tier5 = 0;
        double invalidNumbers = 0;

        for (int i = 1; i<=gameLength; i++){
            int number = Integer.parseInt(scan.nextLine());
            if (number>=0&&number<=9){
                gameScore+= number*0.2;
                tier1+=1;
            }
            else if (number>9&&number<=19){
                gameScore+= number*0.3;
                tier2+=1;
            }
            else if (number>19&&number<30){
                gameScore+=number*0.4;
                tier3+=1;
            }
            else if (number>29&&number<40){
                gameScore+=50;
                tier4+=1;
            }
            else if (number>39&&number<51){
                gameScore+=100;
                tier5+=1;
            }
            else {
                gameScore/=2;
                invalidNumbers+=1;
            }
        }
        System.out.printf("%.2f%n", gameScore);
        tier1 = tier1/gameLength*100;
        tier2 = tier2/gameLength*100;
        tier3 = tier3/gameLength*100;
        tier4 = tier4/gameLength*100;
        tier5 = tier5/gameLength*100;
        invalidNumbers = invalidNumbers/gameLength*100;
        System.out.printf("From 0 to 9: %.2f%%%nFrom 10 to 19: %.2f%%%nFrom 20 to 29: %.2f%%%nFrom 30 to 39: %.2f%%%nFrom 40 to 50: %.2f%%%nInvalid numbers: %.2f%%",tier1, tier2, tier3, tier4, tier5, invalidNumbers);
    }
}
