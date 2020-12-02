package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double winterHoneyRequired = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        double totalHoney = 0;

        while (!input.equals("Winter has come")){
            double currentBee = 0;
            for (int i = 0; i<6; i++){
                currentBee += Double.parseDouble(scan.nextLine());
            }
            totalHoney += currentBee;
            if (currentBee < 0){
                System.out.println(input + " was banished for gluttony");
            }
            if (totalHoney>=winterHoneyRequired){
                break;
            }
            input = scan.nextLine();
        }
        if (totalHoney>=winterHoneyRequired) {
            System.out.printf("Well done! Honey surplus %.2f.", totalHoney-winterHoneyRequired);
        }
        else {
            System.out.printf("Hard Winter! Honey needed %.2f.", winterHoneyRequired-totalHoney);
        }
    }
}
