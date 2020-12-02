package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            int a = n.charAt(i)-48;
            sum+=a;
        }
        System.out.println(sum);
    }
}
