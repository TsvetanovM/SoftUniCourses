package softuni.fundamentals.java;

import java.util.Random;
import java.util.Scanner;

public class Lab01Randomize {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] array = input.split(" ");
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            int exchange = rnd.nextInt(array.length);
            String previousValue = array[i];
            array[i] = array[exchange];
            array[exchange]= previousValue;
        }
        for (String s : array) {
            System.out.println(s);
        }
    }
}
