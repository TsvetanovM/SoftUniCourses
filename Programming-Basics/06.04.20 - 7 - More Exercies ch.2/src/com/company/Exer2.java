package com.company;

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 30 000 minutes in a year; rabotni dni - 63 minutes a day; day off - 127 minutes a day;
        int daysoff = Integer.parseInt(scan.next());

        int playtime = (365 - daysoff) * 63 + daysoff * 127;

        if (playtime>30000){
            double extra = playtime - 30000;
            double hours = extra/60;
            hours = Math.floor(hours);
            double minutes = extra % 60;

            System.out.printf("Tom will run away%n%.0f hours and %.0f minutes more for play", hours, minutes);
        }
        else {
            double less = 30000 - playtime;
            double hours = less/60;
            hours = Math.floor(hours);
            double minutes = less % 60;
            System.out.printf("Tom sleeps well%n%.0f hours and %.0f minutes less for play", hours, minutes);
        }
    }
}
