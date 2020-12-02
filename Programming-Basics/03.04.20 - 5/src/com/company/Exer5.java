package com.company;

import java.util.Scanner;

public class Exer5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        int minute = Integer.parseInt(scan.nextLine());

        int m = minute+15;

        if (m>=60) {
            m = m % 60;
            hour = hour+1;
        }
        if (hour == 24){
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, m);
    }
}
