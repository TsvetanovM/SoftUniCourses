package EncapsulationExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, FootballTeam> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            switch (command) {
                case "Team":
                    teams.put(teamName, new FootballTeam(teamName));
                    break;
                case "Add":
                    if (validTeam(teams, teamName)) {
                        String playerName = tokens[2];
                        String[] stats = {tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]};
                        teams.get(teamName).addPlayer(new Player(tokens[2], Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
                    }
                    break;
                case "Remove":
                    teams.get(teamName).removePlayer(tokens[2]);
                    break;
                case "Rating":
                    if (validTeam(teams, teamName)) {
                        System.out.println(teams.get(teamName).toString());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static boolean validTeam(Map<String, FootballTeam> teams, String teamName) {
        if (!teams.containsKey(teamName)) {
            System.out.println("Team " + teamName + " does not exist.");
            return false;
        }
        return true;
    }

}
