package com.company;

import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int examHour = Integer.parseInt(scan.nextLine());
        int examMinute = Integer.parseInt(scan.nextLine());
        int arrivalHour = Integer.parseInt(scan.nextLine());
        int arrivalMinute = Integer.parseInt(scan.nextLine());

        int timeInMinutes = examHour * 60 + examMinute;
        int arrivalInMinutes = arrivalHour * 60 + arrivalMinute;
        int difference = timeInMinutes - arrivalInMinutes;

        if (arrivalInMinutes<=timeInMinutes){
            if (arrivalInMinutes+30<timeInMinutes){
              if (arrivalInMinutes+59<timeInMinutes){
                  int hour = difference/60;
                  int minutes = difference%60;
                  System.out.printf("Early%n%d:%02d hours before the start", hour, minutes);
              }
              else {
                  System.out.printf("Early%n%d minutes before the start", difference);
              }
            }
            else {
                if (arrivalInMinutes!=timeInMinutes){
                    System.out.printf("On time%n%d minutes before the start", difference);
                }
                else {
                    System.out.println("On time");
                }
            }
        }
        else {
            if (arrivalInMinutes<=timeInMinutes+59){
                difference = arrivalInMinutes - timeInMinutes;
                System.out.printf("Late%n%d minutes after the start", difference);
            }
            else {
                difference = arrivalInMinutes - timeInMinutes;
                int hour = difference/60;
                int minutes = difference %60;
                System.out.printf("Late%n%d:%02d hours after the start", hour, minutes);
            }
        }
    }
}
