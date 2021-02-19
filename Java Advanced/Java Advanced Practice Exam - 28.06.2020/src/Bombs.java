import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    private static final int DATURA_BOMB = 40;
    private static int daturaCount = 0;
    private static final int CHERRY_BOMB = 60;
    private static int cherryCount = 0;
    private static final int SMOKE_DECOY_BOMB = 120;
    private static int smokeCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstSequence = readIntArray(scanner);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        for (int effect : firstSequence) {
            bombEffects.offer(effect);
        }
        int[] secondSequence = readIntArray(scanner);
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        for (int casing : secondSequence) {
            bombCasings.push(casing);
        }

        while (!bombCasings.isEmpty() && !bombEffects.isEmpty()) {
            int value = bombCasings.peek() + bombEffects.peek();
            if (isBomb(value)){
                bombCasings.pop();
                bombEffects.poll();
            } else {
                int newValue = bombCasings.pop() - 5;
                bombCasings.push(newValue);
            }
            if (pouchFilled()){
                break;
            }
        }
        String output = (bombCasings.isEmpty() || bombEffects.isEmpty())
                ? "You don't have enough materials to fill the bomb pouch."
                : "Bene! You have successfully filled the bomb pouch!";
        System.out.println(output);

        printDeque(bombEffects, "Bomb Effects: ");
        printDeque(bombCasings, "Bomb Casings: ");

        System.out.println("Cherry Bombs: " + cherryCount);
        System.out.println("Datura Bombs: " + daturaCount);
        System.out.println("Smoke Decoy Bombs: " + smokeCount);
    }

    private static void printDeque(ArrayDeque<Integer> deque, String type) {
        if (deque.isEmpty()) {
            System.out.println(type + "empty");
        } else {
            if (type.equals("Bomb Effects: ")) {
                System.out.print(type + deque.poll());
            } else {
                System.out.print(type + deque.pop());
            }
            for (Integer effect : deque) {
                System.out.print(", " + effect);
            }
            System.out.println();
        }
    }

    private static boolean pouchFilled() {
        return daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3;
    }

    private static boolean isBomb(int value) {
        if (value == DATURA_BOMB) {
            daturaCount++;
            return true;
        }
        if (value == CHERRY_BOMB) {
            cherryCount++;
            return true;
        }
        if (value == SMOKE_DECOY_BOMB) {
            smokeCount++;
            return true;
        }
        return false;
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
