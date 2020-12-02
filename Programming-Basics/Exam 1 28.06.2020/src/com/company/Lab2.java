package com.company;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int intelligence = Integer.parseInt(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        String sex = scan.nextLine();
        String role = "";

        if (intelligence>=80&&power>=80&&sex.equals("female")){
            role = "Queen Bee";
        }
        else if (intelligence>=80){
            role = "Repairing Bee";
        }
        else if (intelligence>=60){
            role = "Cleaning Bee";
        }
        else if (power>=80 && sex.equals("male")){
            role = "Drone Bee";
        }
        else if (power>=60){
            role = "Guard Bee";
        }
        else {
            role = "Worker Bee";
        }
        System.out.println(role);
    }
}
