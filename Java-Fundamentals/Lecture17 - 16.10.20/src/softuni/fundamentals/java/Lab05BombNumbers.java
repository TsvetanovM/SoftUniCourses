package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab05BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sequence = toIntegerList(scan);
        String[] specialNumber = inputConversion(scan);
        int bombNumber = Integer.parseInt(specialNumber[0]);
        int power = Integer.parseInt(specialNumber[1]);

        while (sequence.contains(bombNumber)){
            int bombIndex = sequence.indexOf(bombNumber);
            for (int i = bombIndex+power; i>=bombIndex-power; i--){
                if (i<0||i>=sequence.size()) {
                    continue;
                }
                sequence.remove(i);
            }
        }
        int sum = 0;
        for (int number: sequence) {
            sum+=number;
        }
        System.out.println(sum);
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
}
