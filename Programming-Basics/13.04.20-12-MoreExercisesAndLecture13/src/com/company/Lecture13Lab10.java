package com.company;

import java.util.Scanner;

public class Lecture13Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        String boxes = scan.nextLine();
        int count = 0;
        int totalSpace = width*height*length;
        int spaceUsed = 0;

        while (!boxes.equals("Done")){
            count = Integer.parseInt(boxes);
            spaceUsed+=count;
            if (spaceUsed>totalSpace){
                break;
            }
            boxes = scan.next();
        }
        if (spaceUsed>totalSpace){
            spaceUsed = spaceUsed-totalSpace;
            System.out.printf("No more free space! You need %d Cubic meters more.", spaceUsed);
        }
        else {
            spaceUsed = totalSpace-spaceUsed;
            System.out.printf("%d Cubic meters left.", spaceUsed);
        }
    }
}
