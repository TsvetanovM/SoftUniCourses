package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String input3 = scan.nextLine();
        String output = "";
        output+=input1.charAt(0);
        output+=input2.charAt(0);
        output+=input3.charAt(0);
        System.out.println(output);
    }
}
