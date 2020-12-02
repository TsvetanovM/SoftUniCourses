package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int a = 0; a<=n; a++){
            for (int b = 0; b<=n; b++){
                for (int c=0; c<=n;c++){
                    int sum = a+b+c;
                    if (sum==n){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
