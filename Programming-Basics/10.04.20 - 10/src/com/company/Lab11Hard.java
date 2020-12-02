package com.company;

import java.util.Scanner;

public class Lab11Hard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());
        double wmPrice = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());
        double savedMoney = 0;

        for (double i = 1; i<=age; i++){
            if (i%2==0){
                savedMoney+= 10*(i/2)-1;
            }
            else {
                savedMoney+= toyPrice;
            }
        }
        if (savedMoney<wmPrice){
           double difference = wmPrice-savedMoney;
            System.out.printf("No! %.2f", difference);
        }
        else {
            double difference = savedMoney - wmPrice;
            System.out.printf("Yes! %.2f", difference);
        }
    }
}
