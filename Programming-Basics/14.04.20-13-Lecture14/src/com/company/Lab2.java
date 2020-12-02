package com.company;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int badGrades = Integer.parseInt(scan.nextLine());
        String taskName = scan.nextLine();
        int grade = 0;
        double totalGrades = 0;
        int counter = 0;
        int badGradesCounter = 0;
        String lastProblem = "";

        while (!taskName.equals("Enough")){
            grade = Integer.parseInt(scan.nextLine());
            if (grade<=4){
                badGradesCounter++;
                if (badGradesCounter==badGrades){
                    break;
                }
            }
            totalGrades+=grade;
            counter++;
            lastProblem=taskName;
            taskName = scan.nextLine();
        }
        if (badGradesCounter==badGrades){
            System.out.printf("You need a break, %d poor grades.", badGrades);
        }
        else {
            double averageGrade = totalGrades/counter;
            System.out.printf("Average score: %.2f%n", averageGrade);
            System.out.printf("Number of problems: %d%n", counter);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
