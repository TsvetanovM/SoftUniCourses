package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Да се напише конзолна програма, която прочита възраст (десетично число) и пол ("m" или "f"), въведени от потребителя, и отпечатва обръщение измежду следните:
        //•	"Mr." - мъж (пол "m") на 16 или повече години
        //•	"Master" - момче (пол "m") под 16 години
        //•	"Ms." - жена (пол "f") на 16 или повече години
        //•	"Miss" - момиче (пол "f") под 16 години
        double age = Double.parseDouble(scan.nextLine());
        String sex = scan.next();

        if (age>=16){
            switch (sex){
                case "m":
                    System.out.println("Mr.");
                    break;
                case "f":
                    System.out.println("Ms.");
                    break;
            }
        }
        else {
            switch (sex){
                case "m":
                    System.out.println("Master");
                    break;
                case "f":
                    System.out.println("Miss");
                    break;
            }
        }
    }
}
