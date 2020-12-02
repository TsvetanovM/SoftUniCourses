package com.company;

import java.util.Scanner;

public class Lab10Hard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double temp = Double.parseDouble(scan.nextLine());

        if (temp>=26){
            if (temp <= 35){
                System.out.println("Hot");
            }
            else {
                System.out.println("unknown");
            }
        }
        else if (temp>20){
            System.out.println("Warm");
        }
        else if (temp>14.9){
            System.out.println("Mild");
        }
        else if (temp>12){
            System.out.println("Cool");
        }
        else if (temp>=5){
            System.out.println("Cold");
        }
        else{
            System.out.println("unknown");
        }
    }
}
