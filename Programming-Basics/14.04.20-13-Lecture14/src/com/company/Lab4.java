package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stepsToday = "";
        int stepsCounter = 0;
        int currentSteps = 0;

        while (stepsCounter<10000){
            stepsToday = scan.nextLine();
            if (stepsToday.equals("Going home")){
                stepsToday = scan.nextLine();
                currentSteps = Integer.parseInt(stepsToday);
                stepsCounter+=currentSteps;
                break;
            }
            currentSteps = Integer.parseInt(stepsToday);
            stepsCounter+=currentSteps;
        }
        if (stepsCounter>=10000){
            System.out.println("Goal reached! Good job!");
            System.out.println(stepsCounter-10000 + " steps over the goal!");
        }
        else {
            System.out.printf("%d more steps to reach goal.", 10000-stepsCounter);
        }
    }
}
