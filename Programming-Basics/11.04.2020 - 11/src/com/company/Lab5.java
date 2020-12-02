package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double p1Count = 0;
        double p2Count = 0;
        double p3Count = 0;

        for (int i = 1; i<=n; i++){
            int a = Integer.parseInt(scan.nextLine());
            if (a%2==0){
                p1Count+=1;
            }
            if (a%3==0){
                p2Count+=1;
            }
            if (a%4==0){
                p3Count+=1;
            }
        }
        double p1 = p1Count/n*100;
        double p2 = p2Count/n*100;
        double p3 = p3Count/n*100;

        System.out.printf("%.2f%%%n",p1);
        System.out.printf("%.2f%%%n",p2);
        System.out.printf("%.2f%%%n",p3);
    }
}
