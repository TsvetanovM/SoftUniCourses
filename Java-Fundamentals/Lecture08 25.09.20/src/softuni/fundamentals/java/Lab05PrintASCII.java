package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab05PrintASCII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int finish = Integer.parseInt(scan.nextLine());
        for (int i = 0; i <= finish-start ; i++) {
            char current = (char) ((char) i+start);
            System.out.printf("%c ", current);
        }
    }
}
