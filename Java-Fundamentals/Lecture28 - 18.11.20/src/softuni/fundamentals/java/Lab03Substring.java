package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab03Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input =  scan.nextLine();
        String sequence = scan.nextLine();

//        int startingIndex = sequence.indexOf(input);
//        while (startingIndex != -1){
          sequence = sequence.replace(input, "");
//            startingIndex = sequence.indexOf(input);
//        }
        System.out.println(sequence);
    }
}
