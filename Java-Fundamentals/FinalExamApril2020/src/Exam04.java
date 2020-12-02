import java.util.Scanner;

public class Exam04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            boolean replaced = false;
            switch (command) {
                case "TakeOdd":
                    StringBuilder newPass = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 == 1) {
                            newPass.append(password.charAt(i));
                        }
                    }
                    password.setLength(0);
                    password.append(newPass);
                    break;
                case "Cut":
                    int startingIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password.delete(startingIndex, startingIndex + length);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    while (password.indexOf(substring) != -1) {
                        replaced = true;
                        startingIndex = password.indexOf(substring);
                        length = substring.length();
                        password.replace(startingIndex, startingIndex + length, substitute);
                    }
                    break;
            }
            if (command.equals("Substitute")&&!replaced){
                System.out.println("Nothing to replace!");
                input = scan.nextLine();
                continue;
            }
                System.out.println(password.toString());
                input = scan.nextLine();

        }
        System.out.println("Your password is: " + password);
    }
}
