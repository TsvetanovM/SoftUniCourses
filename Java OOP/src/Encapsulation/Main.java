package Encapsulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Team team = new Team("Black Eagles");

        int n = Integer.parseInt(reader.readLine());
        List<Person> players = new ArrayList<>();

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            players.add(person);
        }

        for (Person player : players) {
            team.addPerson(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
