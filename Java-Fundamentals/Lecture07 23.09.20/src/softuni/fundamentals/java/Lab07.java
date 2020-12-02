package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String input3 = scan.nextLine();
        String output = "";
        char space = 32;
        output+=input3.charAt(0);
        output+= space;
        output+=input2.charAt(0);
        output+= space;
        output+=input1.charAt(0);
        System.out.println(output);
    }
}
