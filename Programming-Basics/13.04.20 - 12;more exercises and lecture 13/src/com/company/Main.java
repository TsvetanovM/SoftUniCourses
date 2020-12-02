package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        double inheritance = Double.parseDouble(scan.nextLine());
        int endYear = Integer.parseInt(scan.nextLine());
        int age = 18;
        double moneyNeeded = 0;

        for (int i=1800; i<=endYear; i++){
            if (i%2==0){
                moneyNeeded+=12000;
            }
            else {
                inheritance+= 12000+50*age;
            }
            age+=1;
            }
        if (inheritance<moneyNeeded){
            double notEnough = moneyNeeded-inheritance;
            System.out.printf("He will need %.2f dollars to survive.",notEnough);
        }
        else {
            double moneyLeft = inheritance-moneyNeeded;
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        }
    }
}
