package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab02ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = toIntegerList(scan);
        String input = scan.nextLine();
        while (!input.equals("end")){
            String[] currentInput = input.split("\\s+");
            if (currentInput[0].equals("Delete")) {
                int element = Integer.parseInt(currentInput[1]);
                int index = numbers.indexOf(element);
                while (index >= 0) {
                    numbers.remove(index);
                    index = numbers.indexOf(element);
                }
            }
            else if (currentInput[0].equals("Insert")){
                int currentIndex = Integer.parseInt(currentInput[2]);
                if (currentIndex < numbers.size() && currentIndex >= 0) {
                            numbers.add(currentIndex, Integer.parseInt(currentInput[1]));
                }
            }
            input = scan.nextLine();
        }
        printIntegerList(numbers);
    }

    private static List<Integer> toIntegerList(Scanner scan) {
        String input = scan.nextLine();
        String[] array = input.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s: array) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    public static void printIntegerList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
