package com.company;

import java.util.Scanner;

public class Lecture13Lab9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int i = 1;
        double totalGrades = 0;
        int fails = 0;

        while (i<=12){
            double grade = Double.parseDouble(scan.nextLine());
            if (grade<4){
                fails+=1;
                if (fails>1){
                    break;
                }
                continue;
            }
            totalGrades+=grade;
            i++;
        }
        if (fails>1){
            System.out.printf("%s has been excluded at %d grade", name, i);
        }
        else {
            double averageGrade = totalGrades / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }
    }
}
