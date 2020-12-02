package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double VacationMoney = Double.parseDouble(scan.nextLine());
        double currentMoney = Double.parseDouble(scan.nextLine());
        String today = "";
        double moneyToday = 0;
        int spendingCounter = 0;
        int daysCounter = 0;

        while (currentMoney<VacationMoney){
            today = scan.nextLine();
            moneyToday = Integer.parseInt(scan.nextLine());
            if (today.equals("spend")){
                spendingCounter++;
                if (moneyToday>currentMoney){
                    currentMoney=0;
                }
                else {
                    currentMoney-=moneyToday;
                }
            }
            else if (today.equals("save")){
                currentMoney+=moneyToday;
                spendingCounter = 0;
            }
            daysCounter++;
            if (spendingCounter==5) {
                System.out.println("You can't save the money.");
                System.out.println(daysCounter);
                break;
            }
        }
        if (spendingCounter!=5){
            System.out.printf("You saved the money for %d days.", daysCounter);
        }
    }
}
