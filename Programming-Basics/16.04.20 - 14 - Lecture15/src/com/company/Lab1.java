package com.company;

public class Lab1 {
    public static void main(String[] args) {

        for (int h = 0; h <=23 ; h++) {
            for (int m = 0; m<=59; m++){
                for (int s = 0; s <= 59; s++) {
                    System.out.printf("%02d:%02d:%02d%n", h, m, s);
                }
            }
        }
    }
}
