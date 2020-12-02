package com.company;

import java.util.Scanner;

public class ToyStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Puzel/P = 2.60; Kukla/K = 3.00lv; Meche/M = 4.10; Minion/MN = 8.20; Kamionche/KA - 2;
        //50 ili poveche igrachki --> 25% discount; 10% of final bill goes for rent;
        double vacation = Double.parseDouble(scan.nextLine());
        int P = Integer.parseInt(scan.nextLine());
        int K = Integer.parseInt(scan.nextLine());
        int M = Integer.parseInt(scan.nextLine());
        int MN = Integer.parseInt(scan.nextLine());
        int KA = Integer.parseInt(scan.nextLine());

        int toys = P+K+M+MN+KA;

        double price = P*2.60+K*3+M*4.10+MN*8.20+KA*2;

        if (toys >= 50) {
        double discount = price * 0.75;
        double finalprice = discount * 0.9;
        if (finalprice >= vacation) {
            double leftover = finalprice - vacation;
            System.out.printf("Yes! %.2f lv left.", leftover);
        }
        else {
            double needed = vacation - finalprice;
            System.out.printf("Not enough money! %.2f lv needed.", needed);
        }
        }
        else {
            double finalprice = price * 0.9;
            if (finalprice >= vacation) {
                double leftover = finalprice - vacation;
                System.out.printf("Yes! %.2f lv left.", leftover);
            }
            else {
                double needed = vacation - finalprice;
                System.out.printf("Not enough money! %.2f lv needed.", needed);
            }
        }
    }
}
