package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int finish = Integer.parseInt(scan.nextLine());
        int magic = Integer.parseInt(scan.nextLine());
        int combination = 0;
        boolean end = false;

        for (int a= start; a<=finish;a++){
            for(int b=start; b<=finish;b++){
                combination++;
                if (a+b==magic){
                    end = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, a, b, magic);
                    break;
                }
            }
            if (end){
                break;
            }
        }
        if (!end){
            System.out.printf("%d combinations - neither equals %d", combination, magic);
        }
    }
}
