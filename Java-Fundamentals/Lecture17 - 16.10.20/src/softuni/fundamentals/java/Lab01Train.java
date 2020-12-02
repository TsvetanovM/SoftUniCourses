package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab01Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = toIntegerList(scan);
        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            if (input.contains("Add")){
                String[] currentLine = input.split(" ");
                wagons.add(Integer.parseInt(currentLine[1]));
            }
            else {
                int waitingToSit = Integer.parseInt(input);
                for (int i = 0; i<wagons.size(); i++){
                    if (maxCapacity-wagons.get(i)>=waitingToSit) {
                        int newCount = wagons.get(i)+waitingToSit;
                        wagons.set(i, newCount);
                        break;
                    }
                }
            }
            input = scan.nextLine();
        }
        printIntegerList(wagons);
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
