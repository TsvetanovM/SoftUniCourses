package com.company;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int a = 1111;
        int b = 9999;

        for (int i = a; i<=b; i++){
            String current = ""+i;
            boolean isTrue = true;
            int l = current.length();
            for (int j = 0; j<l; j++){
                int c = Integer.parseInt(""+current.charAt(j));
                if (c==0){
                    isTrue = false;
                    break;
                }
                if (N%c!=0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                System.out.print(i+" ");
            }
        }
    }
}
