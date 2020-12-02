package com.company;

import java.util.Scanner;

public class Exer7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // current Record = r; Metri = m; sekundi za 1m = s; na vseki 15m: - 12.5sec;
        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double vreme = Double.parseDouble(scan.nextLine());

        double penalty = distance/15;
        penalty = Math.floor(penalty);
        double deduction = penalty * 12.5;
        double time = distance * vreme+deduction;

        if (time<record){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        }
        else {
            time = time - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", time);
        }
    }
}
