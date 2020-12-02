package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> chat = new ArrayList<>();

        while (!input.equals("end")) {
            String[] array = input.split(" ");
            String command = array[0];
            String message = array[1];
            switch (command) {
                case "Chat":
                    chat.add(message);
                    break;
                case "Delete":
                    chat.remove(message);
                    break;
                case "Edit":
                    int index = chat.indexOf(message);
                    chat.set(index, array[2]);
                    break;
                case "Pin":
                    chat.remove(message);
                    chat.add(message);
                    break;
                case "Spam":
                    for (int i = 1; i<array.length; i++){
                        chat.add(array[i]);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (String s : chat) {
            System.out.println(s);
        }
    }
}
