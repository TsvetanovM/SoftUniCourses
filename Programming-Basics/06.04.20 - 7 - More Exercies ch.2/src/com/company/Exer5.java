package com.company;

import java.util.Scanner;

public class Exer5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ReqHours = Integer.parseInt(scan.nextLine());
        double AvailDays = Double.parseDouble(scan.nextLine());
        int OvertimeWorkers = Integer.parseInt(scan.nextLine());

        double ActualAvailDays = AvailDays*0.9;

        double WorkedHours = ActualAvailDays * 8 + OvertimeWorkers *2 * AvailDays;
        WorkedHours = Math.floor(WorkedHours);

        if (WorkedHours>=ReqHours){
            double TimeLeft = WorkedHours - ReqHours;
            System.out.printf("Yes!%.0f hours left.", TimeLeft);
        }
        else {
            double ExtraTimeNeeded = ReqHours - WorkedHours;
            System.out.printf("Not enough time!%.0f hours needed.", ExtraTimeNeeded);
        }
    }
}
