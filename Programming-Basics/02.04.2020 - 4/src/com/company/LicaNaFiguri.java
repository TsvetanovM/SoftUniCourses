package com.company;

import java.util.Scanner;

public class LicaNaFiguri {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figure = scan.nextLine();

        if (figure.equals("square")) {
            double a = Double.parseDouble(scan.nextLine());
            double area = a * a;
            System.out.println(area);
        }
        else if (figure.equals("rectangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            double area = a * b;
            System.out.println(area);
        }
        else if (figure.equals("circle")) {
            double a = Double.parseDouble(scan.nextLine());
            double area = Math.PI * (a * a);
            System.out.printf("%.2f", area);
        }
        else if (figure.equals("triangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            double area = a/2 * b;
            System.out.printf("%.2f", area);
        }
    }
}
