package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int cake = length*width;
        int piecesTaken = 0;

        while (piecesTaken<=cake){
           String input = scan.nextLine();
            if (input.equals("STOP")){
                break;
            }
            piecesTaken+= Integer.parseInt(input);
        }
        if (piecesTaken<=cake){
            System.out.printf("%d pieces are left.", cake - piecesTaken);
        }
        else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(piecesTaken-cake));
        }
    }
}
