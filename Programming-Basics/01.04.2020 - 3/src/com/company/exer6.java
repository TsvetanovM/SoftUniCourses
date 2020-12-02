package com.company;

import java.util.Scanner;

public class exer6 {
    public static void main(String[] args) {
        // D = broi dni; N = broi sladkari; T = broi torti; G = broi gofreti; P = broi palachinki; - vsichki celi chisla;
        // 1T = 45lv; 1G = 5.80lv; 1P = 3.20lv; 1/8 ot sumata za produkti;

        Scanner scan = new Scanner(System.in);

        int D = Integer.parseInt(scan.nextLine());
        int N = Integer.parseInt(scan.nextLine());
        int T = Integer.parseInt(scan.nextLine());
        int G = Integer.parseInt(scan.nextLine());
        int P = Integer.parseInt(scan.nextLine());

        double price = (D * (((T * 45) + (G * 5.80) + (P * 3.20))*N)) * 0.875;

        System.out.printf("%.2f", price);
    }
}
