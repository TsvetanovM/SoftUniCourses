import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawKey = scan.nextLine();
        String command = scan.nextLine();
        StringBuilder activationKey = new StringBuilder(rawKey);

        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");
            String action = tokens[0];
            switch (action) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.indexOf(substring)>=0) {
                        System.out.println(rawKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                        ;
                    }
                    break;
                case "Flip":
                    String toCase = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String placeHolder = activationKey.substring(startIndex, endIndex);
                    switch (toCase) {
                        case "Upper":
                            activationKey.replace(startIndex, endIndex, placeHolder.toUpperCase());
                            break;
                        case "Lower":
                            activationKey.replace(startIndex, endIndex, placeHolder.toLowerCase());
                            break;
                    }
                    System.out.println(activationKey.toString());
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    activationKey.delete(startIndex, endIndex);
                    System.out.println(activationKey.toString());
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey.toString());
    }
}
