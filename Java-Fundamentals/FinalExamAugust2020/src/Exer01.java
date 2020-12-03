import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exer01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder destinations = new StringBuilder(scan.nextLine());
//        String regex = "[A-Z][a-z]+";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        List<String> destinations = new ArrayList<>();
//
//        while (matcher.find()) {
//            destinations.add(matcher.group());
//        }

        String input = scan.nextLine();

        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index>=0&&index<destinations.length()) {
                        destinations.insert(index, tokens[2]);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex>=0&&startIndex<destinations.length()&&endIndex>=startIndex&&endIndex<destinations.length()){
                        if (endIndex>destinations.length()-2){
                            destinations.delete(startIndex, destinations.length());
                        }
                        destinations.delete(startIndex, endIndex+1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    int oldIndex = destinations.indexOf(oldString);
                    if (oldIndex>=0){
                        destinations.replace(oldIndex,oldIndex + oldString.length(), newString);
                    }
                    break;
            }
            System.out.println(destinations.toString());
            input = scan.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + destinations.toString());
    }
}
