package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = Double.parseDouble(scan.nextLine());
        double maxOdd = Integer.MIN_VALUE;
        double maxEven = Integer.MIN_VALUE;
        double minOdd = Integer.MAX_VALUE;
        double minEven = Integer.MAX_VALUE;
        double sumOdd = 0;
        double sumEven = 0;

        for (double i = 1; i<=n; i++){
            double a = Double.parseDouble(scan.nextLine());
            if (i%2==0){
                sumEven+=a;
                if (a>maxEven){
                    maxEven = a;
                }
                if (a<minEven){
                    minEven = a;
                }
            }
            else {
                sumOdd+=a;
                if (a>maxOdd){
                    maxOdd = a;
                }
                if (a<minOdd){
                    minOdd = a;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", sumOdd);
        if (minOdd!=Integer.MAX_VALUE){
            System.out.printf("OddMin=%.2f,%n", minOdd);
        }
        else {
            System.out.printf("OddMin=No,%n");
        }
        if (maxOdd!=Integer.MIN_VALUE){
            System.out.printf("OddMax=%.2f,%n", maxOdd);
        }
        else {
            System.out.printf("OddMax=No,%n");
        }
        System.out.printf("EvenSum=%.2f,%n", sumEven);
        if (minEven!=Integer.MAX_VALUE){
            System.out.printf("EvenMin=%.2f,%n", minEven);
        }
        else {
            System.out.printf("EvenMin=No,%n");
        }
        if (maxEven!=Integer.MIN_VALUE){
            System.out.printf("EvenMax=%.2f%n", maxEven);
        }
        else {
            System.out.printf("EvenMax=No%n");
        }
    }
}
