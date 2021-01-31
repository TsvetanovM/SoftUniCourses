import java.util.*;
import java.util.stream.Collectors;

public class Lab03Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 50;

        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int card1 = firstPlayer.iterator().next();
            firstPlayer.remove(card1);
            int card2 = secondPlayer.iterator().next();
            secondPlayer.remove(card2);

            if (card1>card2) {
                addCards(firstPlayer, card1, card2);
            } else if (card2 > card1){
                addCards(secondPlayer, card1, card2);
            } else {
                firstPlayer.add(card1);
                secondPlayer.add(card2);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    private static void addCards(Set<Integer> player, int card1, int card2) {
        player.add(card1);
        player.add(card2);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static Set<Integer> readSet(Scanner scanner) {
       return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
    }

    private static void printSet(Set<Integer> set) {
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
