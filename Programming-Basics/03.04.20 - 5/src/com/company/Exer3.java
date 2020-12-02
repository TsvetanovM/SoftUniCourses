package com.company;

import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // skorost S - realno chislo; if S<=10 - Slow; 10-50 - average; 51-150 - fast; 151-1000 - ultra fast; >1000 - extremely fast;

        double S = Double.parseDouble(scan.nextLine());

        if (S<=10) {
            System.out.println("slow");
        }
        else if (S<=50) {
            System.out.println("average");
        }
        else if (S<=150){
            System.out.println("fast");
        }
        else if (S<=1000){
            System.out.println("ultra fast");
        }
        else {
            System.out.println("extremely fast");
        }
    }
}
