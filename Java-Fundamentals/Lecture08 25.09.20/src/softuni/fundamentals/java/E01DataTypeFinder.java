package softuni.fundamentals.java;

import java.util.Scanner;

public class E01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")){
            if (input.contains("true") || input.contains("false")){
                System.out.printf("%s is boolean type", input);;
            }
            else if (input.contains(".")){

            }
        }
    }
}
