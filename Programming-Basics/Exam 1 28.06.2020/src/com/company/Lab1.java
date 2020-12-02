package com.company;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int beesCount = Integer.parseInt(scan.nextLine());
        int flowersCount = Integer.parseInt(scan.nextLine());

        double totalHoney = beesCount*flowersCount*0.21;
        int honeycombs = (int) Math.floor(totalHoney/100);
        double leftover = totalHoney%100;

        System.out.println(honeycombs + " honeycombs filled.");
        System.out.printf("%.2f grams of honey left.", leftover);
    }
}
