package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double change = Double.parseDouble(scan.nextLine());
        double actualChange = change * 100;
        int totalCoins = 0;
        double a = 0;

        while (actualChange!=0){
            if (actualChange/200>=1){
                a = Math.floor(actualChange/200);
                totalCoins+=a;
                actualChange = actualChange%200;
            }
            else if (actualChange/100>=1){
                a = Math.floor(actualChange/100);
                totalCoins+=a;
                actualChange = actualChange%100;
            }
            else if (actualChange/50>=1){
                a = Math.floor(actualChange/50);
                totalCoins+=a;
                actualChange = actualChange%50;
            }
            else if (actualChange/20>=1){
                a = Math.floor(actualChange/20);
                totalCoins+=a;
                actualChange = actualChange%20;
            }
            else if (actualChange/10>=1){
                a = Math.floor(actualChange/10);
                totalCoins+=a;
                actualChange = actualChange%10;
            }
            else if (actualChange/5>=1){
                a = Math.floor(actualChange/5);
                totalCoins+=a;
                actualChange = actualChange%5;
            }
            else if (actualChange/2>=1){
                a = Math.floor(actualChange/2);
                totalCoins+=a;
                actualChange = actualChange%2;
            }
            else {
                a = actualChange;
                totalCoins+=a;
                break;
            }
        }
        System.out.println(totalCoins);
    }
}
