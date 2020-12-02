package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab06CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstDeck = toIntegerList(scan);
        List<Integer> secondDeck = toIntegerList(scan);
        while (firstDeck.size()>0 && secondDeck.size()>0) {
            int firstCard = firstDeck.get(0);
            int secondCard = secondDeck.get(0);
            firstDeck.remove(0);
            secondDeck.remove(0);
            if (firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }
            if (secondCard>firstCard){
                secondDeck.add(secondCard);
                secondDeck.add(firstCard);
            }
        }
        int sum = 0;
        if (firstDeck.isEmpty()){
            for (int card:secondDeck) {
                sum+=card;
            }
            System.out.println("Second player wins! Sum: " +sum);
        }
        else {
            for (int card:firstDeck){
                sum+=card;
            }
            System.out.println("First player wins! Sum: " +sum);
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
}
