package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab04ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = toIntegerList(scan);
        String[] input = inputConversion(scan);
        String command = input[0];
        while (!command.equals("End")){
            boolean validIndex = true;
            switch (command) {
                case "Add":
                    numbers.add(Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(input[2]);
                    if (index>=numbers.size()||index<0){
                        validIndex = false;
                        break;
                    }
                    numbers.add(index, Integer.parseInt(input[1]));
                    break;
                case "Remove":
                    index = Integer.parseInt(input[1]);
                    if (index>numbers.size()||index<0){
                        validIndex = false;
                        break;
                    }
                    numbers.remove(index);
                    break;
                case "Shift":
                    switch (input[1]){
                        case "left":
                            shiftLeft(numbers, input[2]);
                            break;
                        case "right":
                            shiftRight(numbers, input[2]);
                            break;
                    }
                    break;
            }
            if (!validIndex){
                System.out.println("Invalid index");
            }
                input = inputConversion(scan);
                command = input[0];
        }
        printIntegerList(numbers);
    }

    private static void shiftRight(List<Integer> numbers, String s) {
        for (int i = 0; i < Integer.parseInt(s); i++) {
            int previousValue = numbers.get(numbers.size()-1);
            numbers.remove(numbers.size()-1);
            numbers.add(0, previousValue);
        }
    }

    private static void shiftLeft(List<Integer> numbers, String s) {
        for (int i = 0; i < Integer.parseInt(s); i++) {
            int previousValue = numbers.get(0);
            numbers.remove(0);
            numbers.add(previousValue);
        }
    }

    private static List<Integer> toIntegerList(Scanner scan) {
        String input = scan.nextLine();
        String[] array = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s: array) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static String[] inputConversion(Scanner scanner) {
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public static void printIntegerList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
