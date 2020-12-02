package com.company;

import java.util.Scanner;

public class MoreExercisesLab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int goal = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int counter = 1;
        double totalCash = 0;
        double totalCard = 0;
        int cashCounter = 0;
        int cardCounter = 0;

        while (!input.equals("End")){
            int current = Integer.parseInt(input);
            if ((counter%2==1&&current<=100)||(counter%2==0&&current>=10)){
                System.out.println("Product sold!");
                goal-=current;
                if (counter%2==1){
                    cashCounter++;
                    totalCash+=current;
                }
                else {
                    totalCard+=current;
                    cardCounter++;
                }
            }
            else {
                System.out.println("Error in transaction!");
            }
            if (goal<=0){
                break;
            }
            counter++;
            input = scan.nextLine();
        }
        if (goal>0){
            System.out.println("Failed to collect required money for charity.");
        }
        else {
            System.out.printf("Average CS: %.2f%n", totalCash/cashCounter);
            System.out.printf("Average CC: %.2f%n", totalCard/cardCounter);
        }
    }
}
