import java.util.Scanner;

public class Exer04TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String instructions = scan.nextLine();

        while (!instructions.equals("Decode")) {
            String[] tokens = instructions.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int lettersToMove = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < lettersToMove; i++) {
                        message += message.charAt(0);
                        message = message.replaceFirst(String.valueOf(message.charAt(0)), "");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    StringBuilder sb = new StringBuilder(message);
                    sb.insert(index, tokens[2]);
                    message = sb.toString();
                    break;
                case "ChangeAll":
                    message = message.replace(tokens[1], tokens[2]);
                    break;

            }
            instructions = scan.nextLine();
        }

        System.out.println("The decrypted message is: " + message);
    }
}
