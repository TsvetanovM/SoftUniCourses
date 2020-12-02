package softuni.fundamentals.java;

import java.util.Scanner;

public class E01SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int big = 0;
        int med = 0;
        int small = 0;

        if (a>=b){
            if (a>=c){
                big = a;
                if (c>b){
                   med = c;
                   small = b;
                }
                else {
                    med = b;
                    small = c;
                }
            }
            else {
               big = c;
               med = a;
               small = b;
            }
        }
        else {
            if (b>=c){
                big = b;
                if (c>a){
                    small = a;
                    med = c;
                }
                else {
                    small = c;
                    med = a;
                }
            }
            else {
                big = c;
                med = b;
                small = a;
            }
        }
        System.out.println(big);
        System.out.println(med);
        System.out.println(small);
    }
}
