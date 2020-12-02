package com.company;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        for (int i = a; i<b; i++){
            String current = ""+i;
            int odd = 0;
            int even = 0;
            for (int c = 0; c<current.length(); c++){
                int currentDigit = Integer.parseInt(""+current.charAt(c));
                if (currentDigit%2==0){
                    even+=currentDigit;
                }
                else {
                    odd+=currentDigit;
                }
            }
            if (odd==even){
                System.out.print(i+" ");
            }
        }
    }
}
