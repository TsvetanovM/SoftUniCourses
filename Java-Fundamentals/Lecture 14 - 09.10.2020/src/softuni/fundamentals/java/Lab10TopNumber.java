package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab10TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isTopNumber(i)){
                System.out.println(i);
            }
        }
    }

    static boolean isTopNumber (int n) {
        String number = String.valueOf(n);
        int sum = 0;
        boolean hasOddDigit = false;
        for (int i = 0; i < number.length(); i++) {
            int current = number.charAt(i)-48;
            sum += current;
            if (current%2!=0){
                hasOddDigit = true;
            }
        }
        return (sum%8==0 && hasOddDigit);
    }
}
