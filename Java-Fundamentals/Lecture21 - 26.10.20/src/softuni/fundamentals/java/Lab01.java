package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        byte b = Byte.parseByte(scan.nextLine());
        int counter = 0;
        while (n>0){
            int current = n & 1;
            if (current == b){
                counter++;
            }
            n = n >> 1;
//            if (n%2==b) {
//                counter ++;
//            }
//            n = n/2;
        }
        System.out.println(
                counter
        );
    }
}
