package com.company;

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //1m = 1000mm
        //1m = 100cm
        //1cm = 10mm

        double N = Double.parseDouble(scan.nextLine());
        String cm = "cm";
        String mm = "mm";
        String m = "m";
        String in = scan.nextLine();
        String out = scan.nextLine();

        if (in.equals(cm)) {
            if (out.equals(mm)){
                N = N*10;
            }
            else if (out.equals(m)){
                N = N/100;
            }
            System.out.printf("%.3f", N);
        }
        else if (in.equals(mm)) {
            if (out.equals(cm)){
                N = N/10;
            }
            else if (out.equals(m)){
                N = N/1000;
            }
            System.out.printf("%.3f", N);
        }
        else {
            if (out.equals(cm)){
                N = N*100;
            }
            else if (out.equals(mm)){
                N = N*1000;
            }
            System.out.printf("%.3f", N);
        }
    }
}
