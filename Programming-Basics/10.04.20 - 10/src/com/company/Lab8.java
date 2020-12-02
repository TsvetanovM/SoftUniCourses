package com.company;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        for (int i=1; i<=n; i++){
            int a= Integer.parseInt(scan.nextLine());
            if (a>maxNumber){
                maxNumber = a;
            }
            if (a<minNumber){
                minNumber = a;
            }
        }
        System.out.printf("Max number: %d%nMin number: %d", maxNumber, minNumber);
    }
}
