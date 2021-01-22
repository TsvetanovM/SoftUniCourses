package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "YES";
        if (input.length()%2!=0) {
            result = "NO";
        } else {
            ArrayDeque<Character> openingStack = new ArrayDeque<>();
            ArrayDeque<Character> closingStack = new ArrayDeque<>();
            for (int i = 0; i < input.length()/2; i++) {
                openingStack.push(input.charAt(i));
            }
            for (int i = input.length()/2; i < input.length(); i++) {
                closingStack.offer(input.charAt(i));
            }


            while (!openingStack.isEmpty()) {
                if (openingStack.peek().equals('{')) {
                    if (!closingStack.peek().equals('}')) {
                        result = "NO";
                        break;
                    }
                } else if (openingStack.peek().equals('[')) {
                    if (!closingStack.peek().equals(']')) {
                        result = "NO";
                        break;
                    }
                } else if (openingStack.peek().equals('(')) {
                    if (!closingStack.peek().equals(')')) {
                        result = "NO";
                        break;
                    }
                }
                openingStack.pop();
                closingStack.poll();
            }
        }
        System.out.println(result);
    }
}
