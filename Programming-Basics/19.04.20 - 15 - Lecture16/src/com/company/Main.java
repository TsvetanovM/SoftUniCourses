package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int current = 1;
        boolean isBigger = false;

        for (int rows = 1; rows<=n;rows++){
            for (int colms = 1; colms<=rows; colms++){
                if (current>n){
                    isBigger = true;
                    break;
                }
                System.out.print(current + " ");
                current++;
            }
            if (isBigger){
                break;
            }
            System.out.println("");
            //18 - 1; 2 3; 4 5 6; 7 8 9 10; 11 12 13 14 15;
        }
    }
}
