package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int floor = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        for (int i = floor; i>=1; i--){
            System.out.println("");
            for (int a = 0;a<rooms;a++){
                if (i==floor){
                    System.out.printf("L%d%d ", i, a);
                }
                else if (i%2==0){
                    System.out.printf("O%d%d ", i, a);
                }
                else {
                    System.out.printf("A%d%d ", i, a);
                }
            }
        }
    }
}
