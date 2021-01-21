package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab08BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentURL = "";
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.size()<=1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                forwardHistory.push(history.peek());
                history.pop();
            } else if (input.equals("forward")){
                if (forwardHistory.size()>0) {
                    history.push(forwardHistory.peek());
                    System.out.println(forwardHistory.pop());
                } else {
                    System.out.println("no next URLs");
                }
                input = scanner.nextLine();
                continue;
            } else {
                history.push(input);
                forwardHistory.clear();
            }
                currentURL = history.peek();
                System.out.println(currentURL);
                input = scanner.nextLine();
        }
    }
}
