package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02CharacterMultiplier {
    public static void main(String[] args) {
        String[] input = new Scanner(System.in).nextLine().split("\\s");
        long result = sumOfChars(input[0], input[1]);
        System.out.println(result);
    }

    static long sumOfChars(String one, String two){
        StringBuilder first = new StringBuilder(one);
        StringBuilder second = new StringBuilder(two);
        long sum = 0L;

        while (first.length()>0 && second.length()>0){
            int a = first.charAt(0);
            int b = second.charAt(0);
            sum += a*b;
            first.deleteCharAt(0);
            second.deleteCharAt(0);
        }

        if (first.length()>0){
            for (int i = 0; i < first.length(); i++) {
                sum += first.charAt(i);
            }
        }

        if (second.length()>0) {
            for (int i = 0; i < second.length(); i++) {
                sum += second.charAt(i);
            }
        }
        return sum;
    }
}
