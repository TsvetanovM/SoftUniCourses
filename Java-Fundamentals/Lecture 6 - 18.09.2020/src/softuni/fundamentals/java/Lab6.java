package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length() ; i++) {
            int a = input.charAt(i) - 48;
            if (a==0){
                sum+=1;
                continue;
            }
            int currentNumber = a;
            for (int y = a-1; y>=1; y--){
                currentNumber *= y;
            }
            sum +=currentNumber;
        }
        int n = Integer.parseInt(input);
        if (sum==n){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
