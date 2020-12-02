package com.company;

import java.util.Scanner;

public class Exer8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Изискване за социална стипендия - доход на член от семейството по-малък от минималната работна заплата и успех над 4.5
        //Размер на социалната стипендия - 35% от минималната работна заплата.
        //Изискване за стипендия за отличен успех - успех над 5.5, включително. Размер на стипендията за отличен успех - успехът на ученика, умножен по коефициент 25.
        //Напишете програма, която при въведени доход, успех и минимална работна заплата, дава информация дали ученик има право да получава стипендия,
        // и стойността на стипендията, която е по-висока за него.
        double income = Double.parseDouble(scan.nextLine());
        double grade = Double.parseDouble(scan.nextLine());
        double minSalary = Double.parseDouble(scan.nextLine());
        double gradeScholarship = 0;
        double socialScholarship = 0;

        if (grade>=5.50){
            gradeScholarship = grade*25;
        }
        if (income<minSalary){
            if (grade>4.50){
                socialScholarship = minSalary * 0.35;
            }
        }
        if (socialScholarship>gradeScholarship){
            socialScholarship = Math.floor(socialScholarship);
            System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
        }
        else {
            if (gradeScholarship!=0){
                gradeScholarship = Math.floor(gradeScholarship);
                System.out.printf("You get a scholarship for excellent results %.0f BGN", gradeScholarship);
            }
            else {
                System.out.println("You cannot get a scholarship!");
            }
        }
    }
}
