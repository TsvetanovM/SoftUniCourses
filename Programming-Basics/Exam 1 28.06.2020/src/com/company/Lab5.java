package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int beeCount = Integer.parseInt(scan.nextLine());
        int bearHP = Integer.parseInt(scan.nextLine());
        int bearAttack = Integer.parseInt(scan.nextLine());
        boolean bearDefeated = false;

        for (int i = 1; i<Integer.MAX_VALUE; i++){
            if (i%2!=0){
                beeCount = beeCount - bearAttack;
            }
            else {
                bearHP -= beeCount*5;
            }
            if (beeCount<100){
                break;
            }
            if (bearHP<=0) {
                bearDefeated = true;
                break;
            }
        }
        if (bearDefeated){
            System.out.println("Beehive won! Bees left " + beeCount + ".");
        }
        else {
            if (beeCount < 0){
                beeCount = 0;
            }
            System.out.println("The bear stole the honey! Bees left " + beeCount + ".");
        }
    }
}
