package softuni.fundamentals.java;

import java.util.*;

public class Lab02Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] participants = scan.nextLine().split(", ");
        Map<String, Integer> raceInfo = new LinkedHashMap<>();

        for (String participant : participants) {
            raceInfo.put(participant, 0);
        }

        String input = scan.nextLine();

        while (!input.equals("end of race")){
            String name = input.replaceAll("[^A-Za-z]", "");
            if (!raceInfo.containsKey(name)){
                input = scan.nextLine();
                continue;
            }
            String[] numbers = input.split("[^\\d]+");
            String holder = String.join("", numbers);
            int distance = Arrays.stream(holder.split("")).mapToInt(Integer::parseInt).sum();
            raceInfo.put(name, raceInfo.get(name) + distance);
            input = scan.nextLine();
        }

        List<String> forPrint = new ArrayList<>();
        raceInfo.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(3).forEach(e -> forPrint.add(e.getKey()));

        System.out.println("1st place: " + forPrint.get(0));
        System.out.println("2nd place: " + forPrint.get(1));
        System.out.println("3rd place: " + forPrint.get(2));
    }
}
