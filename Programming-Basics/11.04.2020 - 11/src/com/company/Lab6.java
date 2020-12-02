package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tabsOpen = Integer.parseInt(scan.nextLine());
        double salary = Double.parseDouble(scan.nextLine());

        for (int i=1; i<=tabsOpen;i++){
            String website = scan.nextLine();
            switch (website){
                case "Facebook":
                    salary-=150;
                    break;
                case "Instagram":
                    salary-=100;
                    break;
                case "Reddit":
                    salary-=50;
                    break;
            }
            if (salary<=0){
                i=tabsOpen+1;
                System.out.println("You have lost your salary.");
            }
        }
        if (salary>0){
            System.out.printf("%.0f", salary);
        }
    }
}
