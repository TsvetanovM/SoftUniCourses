package softuni.fundamentals.java;

import java.util.Scanner;

public class E02LeftToRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            long input1 = scan.nextLong();
            long input2 = scan.nextLong();
            int sum = 0;
            if (input1>input2) {
                String i1 = String.valueOf(input1);
                for (int j = 0; j < i1.length(); j++) {
                    sum+= i1.charAt(j)-48;
                }
            }
            else {
                String i2 = String.valueOf(input2);
                for (int j = 0; j < i2.length(); j++) {
                    sum+= i2.charAt(j)-48;
                }
            }
            System.out.println(sum);
        }
    }
}
