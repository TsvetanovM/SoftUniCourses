import java.util.Scanner;

public class E01SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(scan.nextLine());
        String instructions = scan.nextLine();

        while (!instructions.equals("Reveal")) {
            String[] operations = instructions.split(":\\|:");
            String command = operations[0];
            boolean isValid = true;
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(operations[1]);
                    concealedMessage.insert(index, " ");
                    break;
                case "Reverse": {
                    String substring = operations[1];
                    int substringIndex = concealedMessage.indexOf(substring);
                    if (substringIndex >= 0) {
                        StringBuilder reversedSubstring = new StringBuilder(concealedMessage.substring(substringIndex, substringIndex + substring.length()));
                        concealedMessage.delete(substringIndex, substringIndex + substring.length());
                        reversedSubstring.reverse();
                        concealedMessage.append(reversedSubstring);
                    } else {
                        System.out.println("error");
                        isValid = false;
                    }
                    break;
                }
                case "ChangeAll":
                    String substring = operations[1];
                    String replacement = operations[2];
                    int substringIndex = concealedMessage.indexOf(substring);
                    while (substringIndex!=-1){
                        concealedMessage.replace(substringIndex, substringIndex+substring.length(), replacement);
                        substringIndex = concealedMessage.indexOf(substring);
                    }
                    break;
            }
            if (isValid) {
                System.out.println(concealedMessage);
            }
            instructions = scan.nextLine();
        }
        System.out.println("You have a new text message: " + concealedMessage);
    }
}
