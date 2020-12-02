package com.company;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        boolean isValid = (a>=100 && a<=200) || a==0;
        if (!isValid){
            System.out.println("invalid");
        }
    }
}
