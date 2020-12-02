package softuni.fundamentals.java;

import java.util.*;

public class Lab10SoftuniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<Integer>> userData = new TreeMap<>();
        Map<String, Integer> languageData = new TreeMap<>();

        while (!input.equals("exam finished")){
            String[] currentEntry = input.split("-");
            String username = currentEntry[0];
            if (!input.contains("banned")){
                String language = currentEntry[1];
                int points = Integer.parseInt(currentEntry[2]);
                userData.putIfAbsent(username, new ArrayList<>());
                userData.get(username).add(points);
                Integer previousTally = languageData.get(language);
                if (previousTally==null){
                    previousTally = 0;
                }
                languageData.put(language, ++previousTally);
            } else {
                userData.remove(username);
            }
            input = scan.nextLine();
        }
        System.out.println("Results:");
        userData.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().stream().mapToInt(Integer::intValue).max().orElse(0),
                        e1.getValue().stream().mapToInt(Integer::intValue).max().orElse(0)))
                .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue().stream().mapToInt(Integer::intValue).max().orElse(0)));

        System.out.println("Submissions:");
        languageData.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}
