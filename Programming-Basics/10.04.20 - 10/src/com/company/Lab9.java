package com.company;

import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum1 = 0;
        int sum2 = 0;

        //for (int i = 1; i<=2*n;i++){
            for (int i = 1; i<=n;i++){
                int a = Integer.parseInt(scan.nextLine());
                sum1 = sum1 + a;
            }
            for (int i = n+1; i<=2*n; i++){
                sum2+= Integer.parseInt(scan.nextLine());
            }

        if (sum1 == sum2){
            System.out.printf("Yes, sum = %d", sum1);
        }
        else {
            int difference = sum1-sum2;
            difference = Math.abs(difference);
            System.out.printf("No, diff = %d", difference);
        }
    }
}
