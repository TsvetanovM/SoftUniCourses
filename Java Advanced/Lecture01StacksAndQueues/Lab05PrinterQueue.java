package softuni.advanced.java;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String result = "";
        while (!input.equals("print")) {
            if(input.equals("cancel")) {
                result = queue.isEmpty() ? "Printer is on standby" : "Canceled " + queue.poll();
                System.out.println(result);
            } else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
