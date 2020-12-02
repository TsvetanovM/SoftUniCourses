package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pskumria = Double.parseDouble(scan.nextLine());
        double pcaca = Double.parseDouble(scan.nextLine());
        double palamud = Double.parseDouble(scan.nextLine());
        double safrid = Double.parseDouble(scan.nextLine());
        int midi = Integer.parseInt(scan.nextLine());

        double ppalamud = pskumria * 1.6;
        double psafrid = pcaca * 1.8;

        double finalprice = palamud*ppalamud + safrid*psafrid + midi*7.5;

        System.out.printf("%.2f", finalprice);
    }
}
