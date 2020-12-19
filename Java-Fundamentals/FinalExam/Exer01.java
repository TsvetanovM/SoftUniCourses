import java.util.Scanner;

public class Exer01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s");
            String command = tokens[0];
            switch (command) {
                case "Translate":
                    text = text.replace(tokens[1], tokens[2]);
                    System.out.println(text);
                    break;
                case "Includes":
                    if (!text.contains(tokens[1])) {
                        System.out.println("False");
                    } else {
                        System.out.println("True");
                    }
                    break;
                case "Start":
                    if (text.indexOf(tokens[1])==0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    StringBuilder sb = new StringBuilder(text);
                    System.out.println(sb.lastIndexOf(tokens[1]));
                    break;
                case "Remove":
                    sb = new StringBuilder(text);
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    sb.delete(startIndex, startIndex + endIndex);
                    text = sb.toString();
                    System.out.println(text);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
