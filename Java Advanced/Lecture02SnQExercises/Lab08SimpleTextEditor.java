package softuni.advanced.java;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> textHistory = new ArrayDeque<>();
        textHistory.push("");
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    String textAdd = textHistory.peek() + input[1];
                    textHistory.push(textAdd);
                    break;
                case "2":
                    String textDelete = textHistory.peek();
                    textDelete = textDelete.substring(0,  textDelete.length() - Integer.parseInt(input[1]));
                    textHistory.push(textDelete);
                    break;
                case "3":
                    char element = textHistory.peek().charAt(Integer.parseInt(input[1]) - 1);
                    System.out.println(element);
                    break;
                case "4":
                    if (textHistory.size()>0) {
                        textHistory.pop();
                    }
                    break;
            }
        }
    }
}
