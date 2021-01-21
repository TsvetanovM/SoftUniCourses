package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> circle = new ArrayDeque<>();
        int cycleCounter = 1;

        for (String kid : kids) {
            circle.offer(kid);
        }

        int passes = Integer.parseInt(scanner.nextLine());


        while (circle.size()>1) {

            for (int i = 1; i < passes; i++) {
                circle.offer(circle.poll());
            }

            boolean isPrime = true;
            if (cycleCounter == 1) {
                isPrime = false;
            }
            for (int i = 2; i<= cycleCounter/2; i++) {
                if (cycleCounter % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Prime " + circle.peek());
            } else {
                System.out.println("Removed " + circle.poll());
            }

            cycleCounter++;
        }

        System.out.println("Last is " + circle.peek());
    }
}
