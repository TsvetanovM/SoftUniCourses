package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MidExamAugust03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputAsArray = input.split(" ");
        List<String> sequence = new ArrayList<>(Arrays.asList(inputAsArray));
        input = scan.nextLine();
        int roundCounter = 0;
        boolean hasWon = false;
        while (!input.equals("end")) {
            int[] command = inputAsIntegers(input);
            int firstIndex = command[0];
            int secondIndex = command[1];
            roundCounter++;
            if (firstIndex==secondIndex||firstIndex>=sequence.size()||firstIndex<0||secondIndex>=sequence.size()||secondIndex<0){
                String addedElement = "-";
                addedElement+= roundCounter;
                addedElement+= "a";
                sequence.add(sequence.size()/2, addedElement);
                sequence.add(sequence.size()/2, addedElement);
                System.out.println("Invalid input! Adding additional elements to the board");
                input = scan.nextLine();
                continue;
            }
            if (sequence.get(firstIndex).equals(sequence.get(secondIndex))){
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(firstIndex));
                if (firstIndex<secondIndex){
                    sequence.remove(secondIndex);
                    sequence.remove(firstIndex);
                }
                else {
                    sequence.remove(firstIndex);
                    sequence.remove(secondIndex);
                }
            }
            else {
                System.out.println("Try again!");
            }
            if (sequence.isEmpty()){
                hasWon = true;
                break;
            }
            input = scan.nextLine();
        }
        if (hasWon){
            System.out.printf("You have won in %d turns!", roundCounter);
        }
        else {
            System.out.println("Sorry you lose :(");
            for (String s : sequence) {
                System.out.print(s+" ");
            }
        }
    }

    public static int[] inputAsIntegers(String input){
        String[] array = input.split(" ");
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = Integer.parseInt(array[i]);
        }
        return output;
    }
}
