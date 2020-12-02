package com.company;

import java.util.Scanner;

public class exer5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rent = Double.parseDouble(scan.nextLine());
        //cake = 1/5rent; drinks = 45% cake; animator = 1/3rent;
        double cake = rent/5;
        double drinks = cake*0.55;
        double animator = rent/3;

        double total = rent+cake+drinks+animator;
        System.out.println(total);
    }
}
