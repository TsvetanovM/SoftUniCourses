package com.company;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int countP1 = 0;
        int countP2 = 0;
        int countP3 = 0;
        int countP4 = 0;
        int countP5 = 0;

        for (int i = 1; i<=n; i++){
            int a = Integer.parseInt(scan.nextLine());
            if (a<200){
                countP1+=1;
            }
            else if (a<400){
                countP2+=1;
            }
            else if (a<600){
                countP3+=1;
            }
            else if (a<800){
                countP4+=1;
            }
            else {
                countP5+=1;
            }
        }
        double totalCount = countP1+countP2+countP3+countP4+countP5;
        double P1 = countP1/totalCount*100;
        double P2 = countP2/totalCount*100;
        double P3 = countP3/totalCount*100;
        double P4 = countP4/totalCount*100;
        double P5 = countP5/totalCount*100;
        System.out.printf("%.2f%%%n", P1);
        System.out.printf("%.2f%%%n", P2);
        System.out.printf("%.2f%%%n", P3);
        System.out.printf("%.2f%%%n", P4);
        System.out.printf("%.2f%%%n", P5);
    }
}
