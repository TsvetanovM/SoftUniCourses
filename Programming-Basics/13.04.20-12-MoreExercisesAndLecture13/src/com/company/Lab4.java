package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scan.nextLine());
        double dvoikari = 0;
        double troikari = 0;
        double chetvorki = 0;
        double petInagore = 0;
        double totalGrades = 0;

        for (int i =1;i<=studentsCount;i++){
             double grade = Double.parseDouble(scan.nextLine());
            if (grade<=2.99){
                dvoikari+=1;
                totalGrades+=grade;
            }
            else if (grade<=3.99){
                troikari+=1;
                totalGrades+=grade;
            }
            else if (grade<=4.99){
                chetvorki+=1;
                totalGrades+=grade;
            }
            else {
                petInagore+=1;
                totalGrades+=grade;
            }
        }
        dvoikari = dvoikari/studentsCount*100;
        troikari = troikari/studentsCount*100;
        chetvorki = chetvorki/studentsCount*100;
        petInagore = petInagore/studentsCount*100;
        double averageGrade = totalGrades/studentsCount;
        System.out.printf("Top students: %.2f%%%n", petInagore);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", chetvorki);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", troikari);
        System.out.printf("Fail: %.2f%%%n", dvoikari);
        System.out.printf("Average: %.2f", averageGrade);
    }
}
