package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab7 {

    public static void main(String[] args) {
        //cena kvadrat - 7.61 s dds; 18% discount ot krainata cena;
        //vhod konzola - kv.m; izhod - final price and discount;

        Scanner scan = new Scanner(System.in);
        double pricesqm = 7.61;
        double sqm = Double.parseDouble(scan.nextLine());
        double price = sqm * pricesqm;
        double discount = 0.18 * price;
        double finalprice = price - discount;

        //DecimalFormat df2 = new DecimalFormat("#.00");

        //df2.setRoundingMode(RoundingMode.UP);
        //System.out.println("The final price is: " + df2.format(finalprice));
        //System.out.println("The discount is: " + df2.format(discount));

        System.out.printf("The final price is: %.2f lv.%nThe discount is: %.2f lv.", finalprice, discount); // %n is how to get to a new line in printf.
    }
}
