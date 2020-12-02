package com.company;

import java.util.Scanner;

public class MoreExercisesLab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bottlesCount = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int totalCleaningSoap = bottlesCount*750;
        int counter = 1;
        int plates = 0;
        int pots = 0;

        while (!input.equals("End")){
            int toWash = Integer.parseInt(input);
            if (counter<=2){
                totalCleaningSoap-=toWash*5;
                plates+=toWash;
                counter++;
            }
            else {
                totalCleaningSoap-=toWash*15;
                pots+=toWash;
                counter = 1;
            }
            if (totalCleaningSoap<0) {
                break;
            }
            input = scan.nextLine();
        }
        if (totalCleaningSoap<0){
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(totalCleaningSoap));
        }
        else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", plates, pots);
            System.out.printf("Leftover detergent %d ml.", totalCleaningSoap);
        }
    }
}
