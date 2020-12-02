package softuni.fundamentals.java;

import java.util.Scanner;

public class E02NameLastDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int num = input.charAt(input.length()-1)-48;
        if (num == 0){
            System.out.println("zero");
        }
        if (num == 1){
            System.out.println("one");
        }
        if (num == 2){
            System.out.println("two");
        }
        if (num == 3){
            System.out.println("three");
        }
        if (num == 4){
            System.out.println("four");
        }
        if (num == 5){
            System.out.println("five");
        }
        if (num == 6){
            System.out.println("six");
        }
        if (num == 7){
            System.out.println("seven");
        }
        if (num == 8){
            System.out.println("eight");
        }
        if (num == 9){
            System.out.println("nine");
        }
    }
}
