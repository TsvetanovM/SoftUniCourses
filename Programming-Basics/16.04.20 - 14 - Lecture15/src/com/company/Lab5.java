package com.company;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        int budget = 0;
        int savings = 0;

        while (!destination.equals("End")){
            budget = Integer.parseInt(scan.nextLine());
            for (int a = 0; a<budget; a+=savings){
                savings = Integer.parseInt(scan.nextLine());
            }
            System.out.println("Going to "+destination+"!");
            destination = scan.nextLine();
        }
    }
}
