package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab04StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMessage = scan.nextLine();
            int keyLetters = 0;
            Pattern pat = Pattern.compile("[star]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pat.matcher(encryptedMessage);
            while (matcher.find()){
                keyLetters++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                int newSymbol = encryptedMessage.charAt(j) - keyLetters;
                decryptedMessage.append((char) newSymbol);
            }

            String validator = "[^@!:>-]*@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldierCount>\\d+)";
            Pattern pattern = Pattern.compile(validator);
            Matcher match = pattern.matcher(decryptedMessage.toString());

            if (match.find()) {
                String attackType = match.group("attackType");
                switch (attackType) {
                    case "A":
                        attackedPlanets.add(match.group("planetName"));
                        break;
                    case "D":
                        destroyedPlanets.add(match.group("planetName"));
                        break;
                }
            }
        }

        attackedPlanets.sort(String::compareTo);
        destroyedPlanets.sort(String::compareTo);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.forEach(p -> System.out.println("-> " + p));
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.forEach(p -> System.out.println("-> " + p));
    }
}
