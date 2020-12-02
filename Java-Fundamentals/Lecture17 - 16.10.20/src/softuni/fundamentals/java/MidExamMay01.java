package softuni.fundamentals.java;

import java.util.Scanner;

public class MidExamMay01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = scan.nextInt();
        int employee2 = scan.nextInt();
        int employee3 = scan.nextInt();
        int students = scan.nextInt();

        int studentsAnswered = 0;
        int hourCounter = 0;
        int totalHours = 0;
        int workPerHour = employee1+employee2+employee3;
        while (studentsAnswered<students){
            if (hourCounter==3){
                totalHours++;
                hourCounter=0;
            }
            studentsAnswered+=workPerHour;
            hourCounter++;
            totalHours++;
        }
        System.out.printf("Time needed: %dh.", totalHours);
    }
}