package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingPop = Integer.parseInt(scan.nextLine());
        int years = Integer.parseInt(scan.nextLine());
        int finalPop = startingPop;
        int newPop;

        for (int i = 1; i<=years; i++){
            newPop = finalPop/10*2 + finalPop;
            if (i%5==0){
                newPop = newPop - (newPop/50*5);
            }
            finalPop = newPop - (newPop/20*2);
        }
        System.out.println("Beehive population: " + finalPop);
    }
}
