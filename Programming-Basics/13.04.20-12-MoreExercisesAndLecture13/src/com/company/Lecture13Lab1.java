package com.company;

import java.util.Scanner;

public class Lecture13Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        while (!word.equals("Stop")){
            System.out.println(word);
            word = scan.nextLine();
        }
    }
}
