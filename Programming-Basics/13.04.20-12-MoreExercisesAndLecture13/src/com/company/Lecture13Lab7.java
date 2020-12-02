package com.company;

import java.util.Scanner;

public class Lecture13Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int a = Integer.MAX_VALUE;
        while (!input.equals("Stop")){
            int currentNumber = Integer.parseInt(input);
            if (currentNumber<a){
                a = currentNumber;
            }
            input = scan.nextLine();
        }
        System.out.println(a);
    }
}