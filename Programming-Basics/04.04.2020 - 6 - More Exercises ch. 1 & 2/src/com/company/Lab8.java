package com.company;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double r = Double.parseDouble(scan.nextLine());
        double area = Math.PI * r*r;
        double perimeter = 2*Math.PI*r;

        System.out.printf("%.2f%n%.2f",area,perimeter);
    }
}
