package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = inputToIntegerList(scan);
        String input = scan.nextLine();
        List<Integer> forPrint = new ArrayList<>();
        while (!input.equals("end")) {
            String[] currentCommand = input.split(" ");
            switch (currentCommand[0]) {
                case "Contains":
                    int currentNumber = Integer.parseInt(currentCommand[1]);
                    if (numbers.contains(currentNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (currentCommand[1].equals("even")) {
                        for (int number : numbers) {
                            if (number % 2 == 0) {
                                forPrint.add(number);
                            }
                        }
                    }
                        else {
                        for (int number : numbers) {
                            if (number % 2 == 1) {
                                forPrint.add(number);
                            }
                        }
                        }
                        System.out.println(forPrint.toString().replaceAll("[\\[\\],]", ""));
                        break;
                        case "Get":
                            int sum = 0;
                            for (int number: numbers) {
                                sum += number;
                            }
                            System.out.println(sum);
                            break;
                        case "Filter":
                            int filterNumber = Integer.parseInt(currentCommand[2]);
                            switch (currentCommand[1]) {
                                case "<":
                                    for(int number: numbers){
                                        if (number<filterNumber){
                                            forPrint.add(number);
                                        }
                                    }
                                    break;
                                case ">":
                                    for(int number: numbers){
                                        if (number>filterNumber){
                                            forPrint.add(number);
                                        }
                                    }
                                    break;
                                case "<=":
                                    for(int number: numbers){
                                        if (number<=filterNumber){
                                            forPrint.add(number);
                                        }
                                    }
                                    break;
                                case ">=":
                                    for(int number: numbers){
                                        if (number>=filterNumber){
                                            forPrint.add(number);
                                        }
                                    }
                                    break;
                            }
                            System.out.println(forPrint.toString().replaceAll("[\\[\\],]", ""));
                            break;
            }
            while (forPrint.size()>0){
                forPrint.remove(0);
            }
                    input = scan.nextLine();
        }
    }

    public static List<Integer> inputToIntegerList(Scanner scan) {
        String input = scan.nextLine();
        String[] tempArray = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : tempArray) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
