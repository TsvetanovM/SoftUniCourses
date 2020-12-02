package com.company;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double vegprice = Double.parseDouble(scan.nextLine());
        double fruitprice = Double.parseDouble(scan.nextLine());
        int vegtotal = Integer.parseInt(scan.nextLine());
        int fruittotal = Integer.parseInt(scan.nextLine());

        double incomebg = vegprice*vegtotal + fruitprice*fruittotal;
        double incomeeur = incomebg/1.94;

        System.out.printf("%.2f", incomeeur);
    }
}
