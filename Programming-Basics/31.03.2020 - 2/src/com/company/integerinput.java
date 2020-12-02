package com.company;

import java.util.Scanner;

public class integerinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(count + 33);
        //System.out.println("5" + 33); - shows the difference between entering text in the console and text converted into int.


    }
}
