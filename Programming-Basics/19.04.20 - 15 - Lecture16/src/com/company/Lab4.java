package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int jury = Integer.parseInt(scan.nextLine());
        String presentationName = scan.nextLine();
        double grade = 0;
        double averageAll = 0;
        int gradesCount = 0;

        while (!presentationName.equals("Finish")) {
            double totalGrades=0;
            for (int i = 1; i <= jury; i++) {
                grade = Double.parseDouble(scan.nextLine());
                gradesCount++;
                totalGrades+=grade;
                averageAll+=grade;
            }
            System.out.printf("%s - %.2f.%n", presentationName, totalGrades/jury);
            presentationName = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", averageAll/gradesCount);
    }
}
