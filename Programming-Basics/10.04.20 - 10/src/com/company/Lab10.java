package com.company;

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 1; i<=n; i++){
            int a = Integer.parseInt(scan.nextLine());
            if (i%2==0){
                sumEven+=a;
            }
            else {
                sumOdd+=a;
            }
        }
        if (sumEven == sumOdd){
            System.out.printf("Yes%nSum = %d", sumEven);
        }
        else {
            int difference = Math.abs(sumEven-sumOdd);
            System.out.printf("No%nDiff = %d", difference);
        }
    }
}
