package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	// V - obem na basein;
        int V = Integer.parseInt(scan.nextLine());
        int P1 = Integer.parseInt(scan.nextLine());
        int P2 = Integer.parseInt(scan.nextLine());
        double N = Double.parseDouble(scan.nextLine());

        double pool = P1*N + P2*N;

        if (pool<=V){
            double percentage = pool/V*100;
            double P11 = (P1*N)/pool * 100;
            double P22 = (P2*N)/pool * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", percentage, P11, P22);
        }
        else {
            double overflow = pool - V;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", N, overflow);
        }


    }
}
