package softuni.fundamentals.java;

import java.util.Scanner;

public class E05Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputLines = Integer.parseInt(scan.nextLine());
        String message = "";
        char currentLetter;
        for (int i = 0; i < inputLines ; i++) {
            String input = scan.nextLine();
            int length = input.length();
            int mainDigit = input.charAt(0) - 48;
            if (mainDigit==0){
                currentLetter = (char) (mainDigit+32);
                message+= currentLetter;
                continue;
            }
            int offset = (mainDigit - 2) * 3;
            if (mainDigit >= 8) {
                offset++;
            }
            int letterIndex = offset + length - 1;
            currentLetter = (char) (letterIndex + 97);
            message += currentLetter;
        }
        System.out.println(message);
    }
}
