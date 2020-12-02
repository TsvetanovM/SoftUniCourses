package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingPoints = Integer.parseInt(scan.nextLine());
        String targetSector = "";
        int currentPoints = 0;
        int movesCounter = 0;
        boolean bullseye = false;

        while (startingPoints>0){
            targetSector = scan.nextLine();
            movesCounter++;
            if (targetSector.equals("bullseye")){
                startingPoints = 0;
                bullseye = true;
                break;
            }
            currentPoints = Integer.parseInt(scan.nextLine());
            switch (targetSector){
                case "number section":
                    startingPoints-=currentPoints;
                    break;
                case "double ring":
                    startingPoints-=2*currentPoints;
                    break;
                case "triple ring":
                    startingPoints-=3*currentPoints;
                    break;
            }
        }
        if (startingPoints==0&&!bullseye){
            System.out.printf("Congratulations! You won the game in %d moves!", movesCounter);
        }
        else if (bullseye){
            System.out.printf("Congratulations! You won the game with a bullseye in %d moves!", movesCounter);
        }
        else {
            System.out.printf("Sorry, you lost. Score difference: %d", Math.abs(startingPoints));
        }
    }
}
