package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());

        if (a>=-100&&a<=100&&a!=0){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
