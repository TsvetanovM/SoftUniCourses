package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = inputToIntegerList(scan);
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] currentCommand = input.split(" ");
            int currentNumber =Integer.parseInt( currentCommand[1] );
            switch (currentCommand[0]){
                case "Add":
                    numbers.add(currentNumber);
                    break;
                case "Remove":
                    numbers.remove((Integer) currentNumber);
                    break;
                case "RemoveAt":
                    numbers.remove(currentNumber);
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(currentCommand[2]), currentNumber);
            }
            input = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    public static List<Integer> inputToIntegerList(Scanner scan) {
        String input = scan.nextLine();
        String[] tempArray = input.split(" ");
        List <Integer> numbers = new ArrayList<>();
        for (String s : tempArray) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
