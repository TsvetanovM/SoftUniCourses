package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        String alphabet = "abcdefghi";

        for (int a=1;a<=n;a++){
            for (int b = 1; b<=n; b++){
                for (int c = 0; c<l; c++){
                    char o = alphabet.charAt(c);
                    for (int d = 0; d<l; d++){
                        char x = alphabet.charAt(d);
                        for (int i = 1; i<=n; i++){
                            if (i>a&&i>b){
                                System.out.printf("%d%d%c%c%d ", a, b, o, x, i);
                            }
                        }
                    }
                }
            }
        }
    }
}
