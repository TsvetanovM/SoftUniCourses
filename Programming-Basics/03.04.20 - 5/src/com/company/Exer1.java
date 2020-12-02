package com.company;

import java.util.Scanner;

public class Exer1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Трима спортни състезатели финишират за някакъв брой секунди (между 1 и 50). Да се напише програма,
        // която чете времената на състезателите в секунди, въведени от потребителя и пресмята сумарното им време във формат "минути:секунди".
        // Секундите да се изведат с водеща нула (2  "02", 7  "07", 35  "35").
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        int total = a+b+c;
        int minutes = total/60;
        int seconds = total%60;

        System.out.printf("%d:%02d", minutes, seconds);
    }
}
