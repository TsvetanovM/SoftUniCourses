package softuni.fundamentals.java;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        String name2 = scan.nextLine();
        String delimiter = scan.nextLine();
        System.out.println(name1+delimiter+name2);
    }
}
