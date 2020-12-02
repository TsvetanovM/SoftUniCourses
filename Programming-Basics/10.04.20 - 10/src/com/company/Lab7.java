package com.company;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 1; i<=n; i++){
            int b = Integer.parseInt(scan.nextLine());
            sum=sum+b;
        }
        System.out.println(sum);
    }
}
