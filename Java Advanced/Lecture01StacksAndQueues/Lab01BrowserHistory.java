package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentURL = "";
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                history.push(input);
            }
            else {
                if (history.size()<=1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                history.pop();
            }
            currentURL = history.peek();
            System.out.println(currentURL);
            input = scanner.nextLine();
        }
    }
}
