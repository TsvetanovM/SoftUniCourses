package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        ArrayDeque<String> circle = new ArrayDeque<>();

        for (String kid : kids) {
            circle.offer(kid);
        }

        int passes = Integer.parseInt(scanner.nextLine());

        while (circle.size()>1) {

            for (int i = 1; i < passes; i++) {
                circle.offer(circle.poll());
            }

            System.out.println("Removed " + circle.poll());

        }

        System.out.println("Last is " + circle.peek());
    }
}
