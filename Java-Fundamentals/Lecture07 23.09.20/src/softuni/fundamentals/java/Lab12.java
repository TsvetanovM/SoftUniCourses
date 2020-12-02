package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++){
            int sum = 0;
                sum += i % 10;
                sum += i / 10;
               if (sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> True%n",i);;
            }
            else {
                   System.out.printf("%d -> False%n",i);;
            }
        }
    }
}
