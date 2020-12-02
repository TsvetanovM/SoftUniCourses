package com.company;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N1 = Integer.parseInt(scan.nextLine());
        int N2 = Integer.parseInt(scan.nextLine());
        String whatToDo = scan.nextLine();
        double result = 0;

        switch (whatToDo) {
            case "+":
                result = N1 + N2;
                break;
            case "-":
                result = N1 - N2;
                break;
            case "*":
                result = N1 * N2;
                break;
            case "/":
                if (N2 == 0) {
                    System.out.printf("Cannot divide %d by zero ", N1);
                } else {
                    result = (double) N1 / (double) N2;
                    System.out.printf("%d / %d = %.2f", N1, N2, result);
                }
                break;
            case "%":
                if (N2 == 0) {
                    System.out.printf("Cannot divide %d by zero ", N1);
                } else {
                    result = (double) N1 % (double) N2;
                    System.out.printf("%d %% %d = %.0f", N1, N2, result);
                }
        }
        if ((whatToDo.equals("+") && result%2==0)||(whatToDo.equals("-")&& result%2==0)||(whatToDo.equals("*")&& result%2==0)) {
            System.out.printf("%d %s %d = %.0f - even", N1, whatToDo, N2, result);
        }
        else if ((whatToDo.equals("+") && result%2!=0)||(whatToDo.equals("-")&&result%2!=0)||(whatToDo.equals("*")&&result%2!=0)) {
            System.out.printf("%d %s %d = %.0f - odd", N1, whatToDo, N2, result);
        }
    }
}
