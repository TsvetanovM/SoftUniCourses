package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();
        int numberOfGames = Integer.parseInt(scan.nextLine());
        String gameName = "";
        int pointsGame = 0;
        double totalVolleyballPoints = 0;
        double totalTennisPoints = 0;
        double totalBadmintonPoints = 0;

        for (int i = 1; i<=numberOfGames; i++){
            gameName = scan.nextLine();
            pointsGame = Integer.parseInt(scan.nextLine());
            switch (gameName){
                case "volleyball":
                    totalVolleyballPoints+= pointsGame;
                    break;
                case "tennis":
                    totalTennisPoints+= pointsGame;
                    break;
                case "badminton":
                    totalBadmintonPoints+=pointsGame;
                    break;
            }
        }
        totalBadmintonPoints = totalBadmintonPoints*1.02;
        totalVolleyballPoints = totalVolleyballPoints*1.07;
        totalTennisPoints = totalTennisPoints*1.05;
        double totalPoints = Math.floor(totalBadmintonPoints+totalVolleyballPoints+totalTennisPoints);

        if (totalBadmintonPoints>=75&&totalVolleyballPoints>=75&&totalTennisPoints>=75){
            System.out.printf("Congratulations, %s! You won the cruise games with %.0f points.", playerName, totalPoints);
        }
        else {
            System.out.printf("Sorry, %s, you lost. Your points are only %.0f", playerName, totalPoints);
        }
    }
}
