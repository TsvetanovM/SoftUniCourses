package softuni.fundamentals.java;

import java.util.*;

public class Lab09ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> warSides = new TreeMap<>();
        Map<String, String> warriors = new HashMap<>();

        while (!input.equals("Lumpawaroo")){
            if (input.contains("|")){
                String[] command = input.split("\\|");
                String side = command[0].trim();
                String user = command[1].trim();
                boolean alreadyExists = false;
                for (Map.Entry<String, String> entry : warriors.entrySet()) {
                    if (entry.getKey().equals(user)){
                        alreadyExists = true;
                        break;
                    }
                }
                if (!alreadyExists){
                    warriors.put(user, side);
                    warSides.putIfAbsent(side, new ArrayList<>());
                    warSides.get(side).add(user);
                }
            }
            else {
                String[] command = input.split("->");
                String side = command[1].trim();
                String user = command[0].trim();
                boolean alreadyRegistered = false;
                for (Map.Entry<String, String> entry : warriors.entrySet()) {
                    if (entry.getKey().equals(user)){
                        alreadyRegistered = true;
                        if (!entry.getValue().equals(side)) {
                            String previousSide = entry.getValue();
                            warSides.get(previousSide).remove(user);
                            warSides.get(side).add(user);
                            warriors.put(user, side);
                        }
                        break;
                    }
                }
                if (!alreadyRegistered) {
                    warriors.put(user, side);
                    warSides.putIfAbsent(side, new ArrayList<>());
                    warSides.get(side).add(user);
                }
                System.out.println(user + " joins the " + side + " side!");
            }
            input = scan.nextLine();
        }
        warSides.entrySet().stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .forEach(s -> {
                    if (s.getValue().size()!=0) {
                        System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                        s.getValue().stream()
                                .sorted().forEach(u -> System.out.println("! " + u));
                    }
                });
    }
}
