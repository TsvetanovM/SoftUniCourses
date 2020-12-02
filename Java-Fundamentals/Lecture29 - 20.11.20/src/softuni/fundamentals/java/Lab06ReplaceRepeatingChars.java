package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        StringBuilder output = new StringBuilder();
        char starting = line.charAt(0);

        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i)!=starting){
                output.append(starting);
                starting = line.charAt(i);
            }
            if (i==line.length()-1){
                output.append(line.charAt(i));
            }
        }

        System.out.println(output.toString());
    }
}
