package com.company;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int a = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=1; i<=n; i++){
           int b = Integer.parseInt(scan.nextLine());
           sum+=b;
           if (b>a){
               a = b;
           }
        }
        if (a==sum-a){
            System.out.printf("Yes%nSum = %d", a);
        }
        else {
            int b = Math.abs(a - (sum - a));
            System.out.printf("No%nDiff = %d", b);
        }
    }
}
