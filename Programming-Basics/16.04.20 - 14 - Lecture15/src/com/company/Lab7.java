package com.company;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movie = scan.nextLine();
        int totalSeats = 0;
        String ticket = "";
        int standardCount = 0;
        int studentCount = 0;
        int kidCount = 0;
        double totalMovieCount = 0;

        while (!movie.equals("Finish")){
            totalSeats = Integer.parseInt(scan.nextLine());
            totalMovieCount = 0;
            ticket = scan.nextLine();
            while (!ticket.equals("End")){
                totalMovieCount++;
                switch (ticket){
                    case "standard":
                        standardCount++;
                        break;
                    case "student":
                        studentCount++;
                        break;
                    case "kid":
                        kidCount++;
                        break;
                }
                if (totalMovieCount==totalSeats){
                    break;
                }
                ticket = scan.nextLine();
            }
           double totalCount = totalMovieCount/totalSeats*100;
            System.out.printf("%s - %.2f%% full.%n",movie, totalCount);
            movie = scan.nextLine();
        }
        double total = standardCount+studentCount+kidCount;
        System.out.printf("Total tickets: %.0f%n", total);
        System.out.printf("%.2f%% student tickets.%n", studentCount/total*100);
        System.out.printf("%.2f%% standard tickets.%n", standardCount/total*100);
        System.out.printf("%.2f%% kids tickets.%n", kidCount/total*100);
    }
}
