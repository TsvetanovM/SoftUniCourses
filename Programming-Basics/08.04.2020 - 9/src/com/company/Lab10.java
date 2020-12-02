package com.company;

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String year = scan.nextLine();
        int holidays = Integer.parseInt(scan.nextLine());
        int weekendsAtHome = Integer.parseInt(scan.nextLine());
        int weekendsInSofia = 48 - weekendsAtHome;
        double nonWorkingWeekends = weekendsInSofia * (3.0/4);
        double playingHolidays = holidays * (2.0/3);
        double totalPlay = weekendsAtHome + nonWorkingWeekends + playingHolidays;

        if (year.equals("leap")){
            totalPlay = totalPlay*1.15;
        }
        totalPlay = Math.floor(totalPlay);
        System.out.printf("%.0f", totalPlay);
    }
}
